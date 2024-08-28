package com.br.cotiinformatica.domain.models;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_perfil")
public class Perfil {

	@Id
	@Column(name = "id")
	private UUID id;
	
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	@OneToMany(mappedBy = "perfil")
	private List<Usuario> usuarios;
	
	public Perfil() {
		// TODO Auto-generated constructor stub
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "Perfil [id=" + id + ", nome=" + nome + ", usuarios=" + usuarios + "]";
	}		
}
