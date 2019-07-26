package com.visa.prj.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.visa.prj.entity.Role;

public interface RoleDao extends JpaRepository<Role, Long> {

	@Query(" from Role r where r.role = :role")
	Role findByRole(@Param("role")String role);
	
	@Query(" from Role r where r.id = :id")
	Role findByid(@Param("id") Long id);

}
