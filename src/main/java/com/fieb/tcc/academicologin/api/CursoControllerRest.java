package com.fieb.tcc.academicologin.api;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fieb.tcc.academicologin.model.Curso;
import com.fieb.tcc.academicologin.service.CursoService;
import com.fieb.tcc.academicologin.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class CursoControllerRest {
	
	@Autowired
	CursoService cursoService;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/instructor/courses")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public Curso saveCourse(@RequestBody Curso curso) {
		 
		return  cursoService.save(curso);
	}
	
	@GetMapping("/instructor/courses")
	public ResponseEntity<Collection<Curso>> getAllCourses(){
		return ResponseEntity.ok().body(cursoService.findAll());
	}
	
}
