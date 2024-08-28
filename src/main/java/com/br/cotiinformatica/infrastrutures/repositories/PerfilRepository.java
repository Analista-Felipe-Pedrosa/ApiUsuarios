package com.br.cotiinformatica.infrastrutures.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.cotiinformatica.domain.models.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, UUID>{
	
	Perfil findByNome(String nome);

}
