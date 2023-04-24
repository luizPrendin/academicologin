package com.fieb.tcc.academicologin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fieb.tcc.academicologin.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

	
	
}
