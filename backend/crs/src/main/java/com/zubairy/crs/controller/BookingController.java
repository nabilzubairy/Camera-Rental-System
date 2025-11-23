package com.zubairy.crs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zubairy.crs.model.Booking;
import com.zubairy.crs.service.BookingService;
import com.zubairy.crs.service.EmailService;
import com.zubairy.crs.utility.PdfGenerator;

@RestController
@RequestMapping("booking")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class BookingController {

	
	@Autowired
    private BookingService service;
	
	@Autowired
	private EmailService emailService;

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) throws Exception {
        Booking saved = service.saveBooking(booking);

        byte[] pdf = PdfGenerator.generateInvoice(
                "User ID " + booking.getUserId(),
                booking.getTotalAmount(),
                booking.getFromDate(),
                booking.getToDate()
        );

        emailService.sendInvoice(
                booking.getEmail(),
                "Camera Rental Booking Invoice",
                "Thank you for booking. Please find your invoice attached.",
                pdf
        );

        return saved;
    }
}
