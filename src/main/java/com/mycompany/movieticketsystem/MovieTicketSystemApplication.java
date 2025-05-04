package com.mycompany.movieticketsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mycompany.movieticketsystem.repository.SeatRepository;
import com.mycompany.movieticketsystem.service.TicketService;

@SpringBootApplication
public class MovieTicketSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieTicketSystemApplication.class, args);
    }
    
    @Bean
    public SeatRepository seatRepository() {
        return new SeatRepository(10); // 10 ghế
    }
    
    @Bean
    public TicketService ticketService(SeatRepository seatRepository) {
        return new TicketService(seatRepository);
    }
}