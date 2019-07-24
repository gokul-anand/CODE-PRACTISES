package com.visa.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.HotelDao;
import com.visa.prj.entity.Hotel;

@Service
public class HotelService {
	@Autowired
	private HotelDao hotelDao;
	
	public List<Hotel> findAll(){
		return hotelDao.findAll();
	}
	
	@Transactional
	public void addHotel(Hotel h) {
		hotelDao.save(h);
	}
	
	public List<Hotel> findByCriteria(String criteria){
		return hotelDao.findByCriteria(criteria);
	}
}
