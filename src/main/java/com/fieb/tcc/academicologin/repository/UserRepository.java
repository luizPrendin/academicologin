package com.fieb.tcc.academicologin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fieb.tcc.academicologin.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
 
	User findByEmail(String email);
	
}
