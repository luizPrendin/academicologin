package com.fieb.tcc.academicologin.service;

import java.util.Collection;

import com.fieb.tcc.academicologin.model.Curso;

public interface CursoService {

	Curso save(Curso curso);
	Collection<Curso> findAll();
	Curso findById(Long id);
	
	
	
}
