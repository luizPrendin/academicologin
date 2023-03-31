package com.fieb.tcc.academicologin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fieb.tcc.academicologin.model.User;
import com.fieb.tcc.academicologin.service.UserService;
import com.fieb.tcc.academicologin.web.dto.UserDto;

@Controller
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/users/home")
	public String home() {
		return "index";
	}
	@GetMapping("/usrers/perfil/{username}")
	public String showPerfilForm(@PathVariable("username")String username, ModelMap model) {
		
		UserDto userDto= new UserDto();
		userDto.setEmail(username);
		User user= userService.findByEmail(userDto);
		model.addAttribute("user",user);
		
		
		return "update-registration";
	}
	

}
