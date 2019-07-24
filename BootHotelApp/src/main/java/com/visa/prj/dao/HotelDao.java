package com.visa.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.visa.prj.entity.Hotel;

public interface HotelDao extends JpaRepository<Hotel, Integer> {
	@Query(" from Hotel h where h.name like %:criteria% or h.address like %:criteria%")
	List<Hotel> findByCriteria(@Param("criteria") String criteria);
}
