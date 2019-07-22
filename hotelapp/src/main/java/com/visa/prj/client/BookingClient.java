package com.visa.prj.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;
import com.visa.prj.service.BookingService;

public class BookingClient {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.visa");
		ctx.refresh();

		BookingService service = ctx.getBean("bookingService", BookingService.class);
		Hotel h1 = service.getHotelById(1);
		Hotel h2 = service.getHotelById(2);
		System.out.println(h1);

		User u1 = service.getUser("u1@visa.com", "u1");
		User u2 = service.getUser("u2@visa.com", "u2");
		System.out.println(u1);
		
		SimpleDateFormat date_formater = new SimpleDateFormat("dd/mm/yyyy");
		Date d1=null,d2=null,d3=null;
		try {
			d1 = date_formater.parse("22/07/2019");
			d2 = date_formater.parse("24/07/2019");
			d3 = date_formater.parse("26/07/2019");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Booking b1 = new Booking();
		b1.setBeds(2);
		b1.setHotel(h1);
		b1.setSmoking(false);
		b1.setUser(u1);
		b1.setCheckinDate(d1);
		b1.setCheckoutDate(d2);
		
		service.bookHotel(b1);
		System.out.println("Booking Made : " + b1.getId());
		Booking b2 = new Booking();
		b2.setBeds(2);
		b2.setHotel(h2);
		b2.setSmoking(false);
		b2.setUser(u1);
		b2.setCheckinDate(d1);
		b2.setCheckoutDate(d3);
		
		service.bookHotel(b2);
		
		List<Booking> bookings = service.getBookingsOfUser(u1);
		
		for (Booking booking : bookings) {
			System.out.println(booking);
		}
		
		List<Hotel> hotels = service.findHotels("Ave");
		
		for (Hotel hotel : hotels) {
			System.out.println(hotel);
		}
		
	}

}
