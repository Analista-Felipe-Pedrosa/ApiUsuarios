package com.br.cotiinformatica.domain.dtos;

import java.util.Date;
import java.util.UUID;

public class CriarUsuarioResponse {

	private UUID id;
	private String nome;
	private String email;
	private Date dataHoraCadastro;

	public CriarUsuarioResponse() {
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

	public Date getDataHoraCadastro() {
		return dataHoraCadastro;
	}

	public void setDataHoraCadastro(Date dataHoraCadastro) {
		this.dataHoraCadastro = dataHoraCadastro;
	}

	@Override
	public String toString() {
		return "CriarUsuarioResponse [id=" + id + ", nome=" + nome + ", email=" + email + ", dataHoraCadastro="
				+ dataHoraCadastro + "]";
	}		
}
