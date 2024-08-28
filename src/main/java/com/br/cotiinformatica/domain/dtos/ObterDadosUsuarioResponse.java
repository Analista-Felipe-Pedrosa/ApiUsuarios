package com.br.cotiinformatica.domain.dtos;

import java.util.UUID;

public class ObterDadosUsuarioResponse {

	private UUID id;
	private String nome;
	private String email;
	private String nomePerfil;
	
	public ObterDadosUsuarioResponse() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomePerfil() {
		return nomePerfil;
	}

	public void setNomePerfil(String nomePerfil) {
		this.nomePerfil = nomePerfil;
	}

	@Override
	public String toString() {
		return "ObterDadosUsuarioResponse [id=" + id + ", nome=" + nome + ", email=" + email + ", nomePerfil="
				+ nomePerfil + "]";
	}			
}
