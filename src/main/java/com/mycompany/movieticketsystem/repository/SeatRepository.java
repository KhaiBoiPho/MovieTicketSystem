package com.mycompany.movieticketsystem.repository;

import com.mycompany.movieticketsystem.model.Seat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Repository;

@Repository
public class SeatRepository {
    private final List<Seat> seats;

    public SeatRepository(int numberOfSeats) {
        this.seats = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= numberOfSeats; i++) {
            seats.add(new Seat(i));
        }
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public Seat getSeat(int seatNumber) {
        if (seatNumber < 1 || seatNumber > seats.size()) {
            return null;
        }
        return seats.get(seatNumber - 1); // Ghế số 1 có chỉ số 0 trong danh sách
    }
    
    public List<Seat> getAvailableSeats() {
        List<Seat> availableSeats = new ArrayList<>();
        for (Seat seat : seats) {
            if (seat.isAvailable()) {
                availableSeats.add(seat);
            }
        }
        return availableSeats;
    }
}
