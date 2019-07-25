package com.visa.prj.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;

public class BookingRestTemplate {
	public static void main(String[] args) {
		String url = "http://localhost:8080/bookings";
		RestTemplate template = new RestTemplate();
		getBookings(template, url);
		postBooking(template, url);
	}

	private static void getBookings(RestTemplate template, String url) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		String json = template.getForObject(url, String.class);
		System.out.println(json);
	}

	private static void postBooking(RestTemplate template, String url) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		SimpleDateFormat date_formater = new SimpleDateFormat("dd-MM-yyyy");
		Date d1=null,d2=null,d3=null;
		try {
			d1 = date_formater.parse("22-07-2019");
			d2 = date_formater.parse("24-07-2019");
			d3 = date_formater.parse("26-07-2019");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Booking b1 = new Booking();
		b1.setBeds(2);
		Hotel h1 = new Hotel();
		h1.setId(1L);
		b1.setHotel(h1);
		b1.setSmoking(false);
		User u1 = new User();
		u1.setEmail("c3@visa.com");
		b1.setUser(u1);
//		b1.setCheckinDate(d1);
//		b1.setCheckoutDate(d2);
		b1= new Booking();
		HttpEntity<Booking> requestEntity = new HttpEntity<Booking>(b1, headers);

		ResponseEntity<Booking> result = template.postForEntity(url, requestEntity, Booking.class);
		System.out.println(result.getStatusCode()); // 201
		System.out.println(result.getBody().getId());
	}
}
