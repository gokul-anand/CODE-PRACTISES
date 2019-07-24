package com.visa.prj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.prj.entity.Booking;
import com.visa.prj.service.BookingService;

@RestController
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@GetMapping ("bookings")
	public @ResponseBody List<Booking> getUsers(){
		System.out.println(bookingService.findAll());
		return bookingService.findAll();
	}
	
	@PostMapping("bookings")
	public ResponseEntity<Booking>  addBooking(@RequestBody Booking b){
		bookingService.addBooking(b);
		return new ResponseEntity<>(b,HttpStatus.CREATED);
	}
}
