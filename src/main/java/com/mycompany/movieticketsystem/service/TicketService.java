package com.mycompany.movieticketsystem.service;

import com.mycompany.movieticketsystem.model.Movie;
import com.mycompany.movieticketsystem.model.Seat;
import com.mycompany.movieticketsystem.model.Ticket;
import com.mycompany.movieticketsystem.repository.SeatRepository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    private final SeatRepository seatRepository;
    private final Map<Integer, Ticket> tickets = new ConcurrentHashMap<>();
    private final ReentrantLock lock = new ReentrantLock();
    
    public TicketService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public boolean reserveSeat(Seat seat) {
        lock.lock();
        try {
            if (seat != null && seat.isAvailable()) {
                seat.reserve(); // Đánh dấu ghế là đã bán
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }
    
    private String generateReservationCode() {
        int code = (int) (Math.random() * 1_000_000);
        return String.format("%06d", code);
    }
    
    public Ticket getTicketForSeat(int seatNumber) {
        return tickets.get(seatNumber);
    }
    
    public Ticket bookTicket(Movie movie, int seatNumber, String reservationCode) {
        Seat seat = seatRepository.getSeat(seatNumber);

        if (reserveSeat(seat)) {
            Ticket ticket = new Ticket(movie, seat, reservationCode);
            tickets.put(seatNumber, ticket);
            return ticket;
        }

        return null;
    }

    public boolean cancelTicket(int seatNumber, String enteredCode) {
        lock.lock();
        try {
            Ticket ticket = tickets.get(seatNumber);
            if (ticket != null && ticket.getReservationCode().equals(enteredCode)) {
                Seat seat = ticket.getSeat();
                seat.cancelReservation();
                tickets.remove(seatNumber);
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

}