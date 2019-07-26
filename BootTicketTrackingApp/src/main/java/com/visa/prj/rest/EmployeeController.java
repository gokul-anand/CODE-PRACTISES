package com.visa.prj.rest;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Role;
import com.visa.prj.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value = "/employees")
	public List<Employee> getEmployees(){
		return employeeService.findAll();
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee>  addBooking(@RequestBody Employee e){
		Set<Role> roles = e.getRoles();
		
		for (Role role : roles) {
			Role r = null;
			if(role.getId() != null)
				r= employeeService.findById(role.getId());
			else if (role.getRole()!=null)
				r = employeeService.findByRole(role.getRole());
			role = r;
		}
		e.setRoles(roles);
		employeeService.addEmployee(e);
		return new ResponseEntity<>(e,HttpStatus.CREATED);
	}
	
}
