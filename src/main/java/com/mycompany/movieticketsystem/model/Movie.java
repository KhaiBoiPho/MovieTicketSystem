/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.movieticketsystem.model;

/**
 *
 * @author khai
 */
public class Movie {
    private String title;
    private String genre;
    private double ticketPrice;

    public Movie(String title, String genre, double ticketPrice) {
        this.title = title;
        this.genre = genre;
        this.ticketPrice = ticketPrice;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
}


