package com.belval.avaliacaogames.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belval.avaliacaogames.entities.Item_Troca;
import com.belval.avaliacaogames.entities.Produto;
import com.belval.avaliacaogames.entities.Troca;
import com.belval.avaliacaogames.repositories.Item_TrocaRepository;

@Service
public class Item_TrocaService {

	@Autowired
	private Item_TrocaRepository repository;

	public List<Item_Troca> findAll() {
		return repository.findAll();
	}

	public Item_Troca findById(Long id) {
		Optional<Item_Troca> obj = repository.findById(id);
		return obj.get();
	}
	
	public Item_Troca findByProdutoAndTroca(Produto produto, Troca troca) {
		Optional<Item_Troca> obj = repository.findByProdutoAndTroca(produto, troca);
		if (obj.isPresent()) {
			return obj.get();
		} else {
			return null;
		}
	}
	
	public List<Item_Troca> findByTroca(Troca troca) {
		return repository.findByTroca(troca);
	}
	/*
	 * public List<Item_Troca> findByUsuario(Usuario usuario) { return
	 * repository.findByUsuario(usuario); }
	 * 
	 * public Item_Troca findByProduto(Produto produto) { Optional<Item_Troca> obj =
	 * repository.findByProduto(produto); if (obj.isPresent()) { return obj.get(); }
	 * else { return new Item_Troca(); } }
	 */
}
