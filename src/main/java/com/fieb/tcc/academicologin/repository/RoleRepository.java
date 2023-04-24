package com.fieb.tcc.academicologin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fieb.tcc.academicologin.model.Role;



@Repository
public interface RoleRepository extends JpaRepository<Role , Long>{

	Role findByName(String rolename);
	
		
	

}
