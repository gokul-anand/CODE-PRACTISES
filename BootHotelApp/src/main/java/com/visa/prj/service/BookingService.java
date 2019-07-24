package com.visa.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.BookingDao;
import com.visa.prj.entity.Booking;

@Service
public class BookingService {
	@Autowired
	private BookingDao bookingDao;
	
	public List<Booking> findAll()
	{
		return bookingDao.findAll();
	}

	@Transactional
	public void addBooking(Booking b) {
		bookingDao.save(b);
	}
}
