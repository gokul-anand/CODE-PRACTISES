package com.visa.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.UserDao;
import com.visa.prj.entity.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public List<User> findAll()
	{
		return userDao.findAll();
	}
	
	@Transactional
	public void addUser(User u) {
		userDao.save(u);
	}
}
