package com.zubairy.crs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zubairy.crs.model.Booking;

@Repository
public interface BookingDao extends JpaRepository<Booking, Long>{

}
