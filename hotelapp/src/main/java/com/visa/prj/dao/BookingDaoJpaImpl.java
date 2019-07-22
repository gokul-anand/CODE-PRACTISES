package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;

@Repository
public class BookingDaoJpaImpl implements BookingDao {

	@PersistenceContext
	private EntityManager em;
	@Override
	public List<Hotel> findHotels(String criteria) {
		TypedQuery<Hotel> query = em.createQuery("from Hotel where hotel_name LIKE :hn OR address LIKE :a", Hotel.class);
		query.setParameter("hn","%"+criteria+"%");
		query.setParameter("a", "%"+criteria+"%");
		return query.getResultList();
	}

	@Override
	public Hotel findHotelById(long id) {
		return em.find(Hotel.class, id);
	}
	
//	@Transactional
	@Override
	public User getUser(String email, String password) {
		User u = em.find(User.class, email);
		if (u.getPassword().equals(password)) {
			return u;
		} else {
			return null;
		}
	}

	@Transactional
	@Override
	public long createBooking(Booking booking) {
		System.out.println(booking);
		User u = booking.getUser();
		booking.setUser( getUser(u.getEmail(), u.getPassword()) );
		em.persist(booking);
		return 0;
	}

	@Override
	public List<Booking> getAllBookingsOfUser(User user) {
		TypedQuery<Booking> query = em.createQuery("from Booking where user_email=:ue", Booking.class);
		query.setParameter("ue",user.getEmail());
		return query.getResultList();
		
	}

}
