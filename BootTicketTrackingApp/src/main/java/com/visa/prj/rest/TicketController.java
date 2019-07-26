package com.visa.prj.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.prj.entity.Ticket;
import com.visa.prj.service.TicketService;

@RestController
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@GetMapping(value = "tickets")
	public List<Ticket> getTickets()
	{
		return ticketService.findAll();
	}
	
	@PostMapping(value = "/raiseTicket")
	public ResponseEntity<Ticket>  raiseTicket(@RequestBody Ticket t){
		t.setLoggedDate(new Date());
		ticketService.raiseTicket(t);
		return new ResponseEntity<>(t,HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/resolveTicket")
	public ResponseEntity<Ticket>  resolveTicket(@RequestBody Ticket t){
		Ticket oldTicket = ticketService.findById(t.getId());
		oldTicket.setResolvedBy(t.getResolvedBy());
		oldTicket.setResolveInfo(t.getResolveInfo());
		oldTicket.setResolvedOn(new Date());
		ticketService.resolveTicket(oldTicket);
		return new ResponseEntity<>(oldTicket,HttpStatus.CREATED);
	}
	
}
