package com.visa.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.BookingDao;
import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;

@Service
public class BookingService {
	@Autowired
	private BookingDao bookingDao;

	public Hotel getHotelById(long id) {
		return bookingDao.findHotelById(id);
	}

	public User getUser(String email, String password) {
		return bookingDao.getUser(email, password);
	}
	
	public boolean bookHotel(Booking b) {
		if (bookingDao.createBooking(b)==0) {
			return true;
		}else {
			return false;
		}
	}
	
	public List<Booking> getBookingsOfUser(User u){
		return bookingDao.getAllBookingsOfUser(u);
	}
	
	public List<Hotel> findHotels(String criteria){
		return bookingDao.findHotels(criteria);
	}
}
