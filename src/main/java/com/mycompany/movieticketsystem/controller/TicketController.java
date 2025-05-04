package com.mycompany.movieticketsystem.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author khai
 */
import com.mycompany.movieticketsystem.model.Movie;
import com.mycompany.movieticketsystem.model.Ticket;
import com.mycompany.movieticketsystem.repository.SeatRepository;
import com.mycompany.movieticketsystem.service.TicketService;
import java.util.Random;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TicketController {
    private final SeatRepository seatRepo;
    private final TicketService ticketService;
    private final Movie movie = new Movie("Siêu nhân gao", "Action", 100);
    private String generateRandomCode() {
        Random random = new Random();
        int code = random.nextInt(1000000);
        return String.format("%06d", code); // Chuyển mã thành chuỗi 6 số
    }

    public TicketController(SeatRepository seatRepo, TicketService ticketService) {
        this.seatRepo = seatRepo;
        this.ticketService = ticketService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("seats", seatRepo.getSeats());
        model.addAttribute("movie", movie);
        return "index";
    }

    @PostMapping("/reserve")
    public String reserveSeat(@RequestParam int seatNumber, RedirectAttributes redirectAttributes) {
        String reservationCode = generateRandomCode();
        Ticket ticket = ticketService.bookTicket(movie, seatNumber, reservationCode);

        if (ticket != null) {
            redirectAttributes.addFlashAttribute("message", "Đặt vé thành công cho ghế số " + seatNumber + ". Mã đặt vé của bạn là: " + reservationCode);
            redirectAttributes.addFlashAttribute("reservationCode", reservationCode);
        } else {
            redirectAttributes.addFlashAttribute("message", "Ghế số " + seatNumber + " đã được đặt.");
        }

        return "redirect:/";
    }

    @PostMapping("/cancel")
    public String cancelSeat(@RequestParam("seatNumber") int seatNumber,
                             @RequestParam("enteredCode") String enteredCode,
                             RedirectAttributes redirectAttributes) {

        boolean success = ticketService.cancelTicket(seatNumber, enteredCode);

        if (success) {
            redirectAttributes.addFlashAttribute("message", "Huỷ vé thành công cho ghế số " + seatNumber);
        } else {
            redirectAttributes.addFlashAttribute("message", "Không thể huỷ vé. Mã đặt vé không đúng hoặc ghế chưa được đặt.");
        }

        return "redirect:/";
    }
}