package com.zubairy.crs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zubairy.crs.dao.BookingDao;
import com.zubairy.crs.model.Booking;

@Service
public class BookingService {

	@Autowired
	private BookingDao dao;
	
	public Booking saveBooking(Booking booking) {
        return dao.save(booking);
    }
}
