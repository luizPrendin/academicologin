package com.belval.avaliacaogames.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.belval.avaliacaogames.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
