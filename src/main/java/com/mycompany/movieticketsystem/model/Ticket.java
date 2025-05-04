package com.mycompany.movieticketsystem.model;

/**
 * Represents a movie ticket in the system.
 * 
 * @author khai
 */
import java.time.LocalDateTime;

public class Ticket {
    private Movie movie;
    private Seat seat;
    private LocalDateTime bookingTime;
    private String reservationCode;

    public Ticket(Movie movie, Seat seat, String reservationCode) {
        this.movie = movie;
        this.seat = seat;
        this.bookingTime = LocalDateTime.now();
        this.reservationCode = reservationCode;
    }

    public String getReservationCode() {
        return reservationCode;
    }

    public Movie getMovie() {
        return movie;
    }

    public Seat getSeat() {
        return seat;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }
}