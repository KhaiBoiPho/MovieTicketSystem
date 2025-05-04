/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.movieticketsystem.model;

/**
 *
 * @author khai
 */

import java.util.concurrent.atomic.AtomicBoolean;

public class Seat {
    private int seatNumber;
    private AtomicBoolean isAvailable;

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.isAvailable = new AtomicBoolean(true); // Mặc định ghế trống
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isAvailable() {
        return isAvailable.get();
    }

    public boolean reserve() {
        return isAvailable.compareAndSet(true, false);
    }
    
    public void cancelReservation() {
        isAvailable.set(true);
    }
}
