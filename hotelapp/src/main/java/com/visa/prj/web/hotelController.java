package com.visa.prj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.SearchCriteria;
import com.visa.prj.entity.User;
import com.visa.prj.service.BookingService;

@Controller
public class hotelController {
	@Autowired
	private BookingService bookingService;
	
	@RequestMapping(value = "search.do")
	public String getSearchForm(Model m) {
		m.addAttribute("searchCriteria",new SearchCriteria());
		return "searchForm.jsp";
	}
	
	@RequestMapping(value = "hotels.do")
	public String fetchHotels(@ModelAttribute("searchCriteria") SearchCriteria s, Model m) {
		m.addAttribute("hotelList", bookingService.findHotels(s.getSearchString()) );
		return "searchResults.jsp";
	}
	
	@RequestMapping(value = "viewHotel.do")
	public String viewHotelDetails(@RequestParam("id") long id, Model m) {
		Hotel h = bookingService.getHotelById(id);
		m.addAttribute("hotel", h);
		return "showHotel.jsp";
	}
	
	
}
