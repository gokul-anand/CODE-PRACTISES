package com.visa.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.EmployeeDao;
import com.visa.prj.dao.RoleDao;
import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Role;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private RoleDao roleDao;
	
	public List<Employee> findAll(){
		return employeeDao.findAll();
	}

	public void addEmployee(Employee e) {
		employeeDao.save(e);
	}

	public Role findById(Long id) {
		return roleDao.findByid(id);
	}

	public Role findByRole(String role) {
		return roleDao.findByRole(role);
	}
}
