package com.fieb.tcc.academicologin;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fieb.tcc.academicologin.model.Role;
import com.fieb.tcc.academicologin.service.UserService;

@SpringBootApplication
public class AcademicologinApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcademicologinApplication.class, args);
		
	}
	
	@Bean
	CommandLineRunner run(UserService userService) {
		return args ->{
			/*userService.saveRole(new Role("ROLE_USER"));
			userService.saveRole(new Role("ROLE_ADMIN"));
			userService.saveRole(new Role("ROLE_INSTRUCTOR"));
			userService.saveRole(new Role("ROLE_STUDENT"));
			*/
		};
	
	}
}
