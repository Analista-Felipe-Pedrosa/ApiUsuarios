package com.br.cotiinformatica.infrastrutures.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.cotiinformatica.domain.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

	Usuario findByEmail(String email);
	Usuario findByEmailAndSenha(String email, String senha);
}
