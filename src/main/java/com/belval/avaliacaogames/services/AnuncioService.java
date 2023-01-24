package com.belval.avaliacaogames.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belval.avaliacaogames.entities.Anuncio;
import com.belval.avaliacaogames.repositories.AnuncioRepository;

@Service
public class AnuncioService {

	@Autowired
	private AnuncioRepository repository;
	
	public List<Anuncio> findAll(){
		return repository.findAll();
	}
	
	public Anuncio findById(Long id) {
		Optional<Anuncio> obj = repository.findById(id);
		return obj.get();
	}
}
