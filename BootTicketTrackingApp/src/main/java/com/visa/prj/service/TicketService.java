package com.visa.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.TicketDao;
import com.visa.prj.entity.Ticket;

@Service
public class TicketService {
	
	@Autowired
	private TicketDao ticketDao;
	
	public void raiseTicket(Ticket t) {
		ticketDao.save(t);
	}

	public void resolveTicket(Ticket t) {
		ticketDao.save(t);
	}

	public List<Ticket> findAll() {
		return ticketDao.findAll();
	}
	
	public Ticket findById(Long id) {
		return ticketDao.findById(id);
	}

}
