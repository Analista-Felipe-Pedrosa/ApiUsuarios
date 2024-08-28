package com.br.cotiinformatica.domain.dtos;

import java.util.Date;
import java.util.UUID;

public class AutenticarUsuarioResponse {
	private UUID id;
	private String nome;
	private String email;
	private Date dataHoraAcesso;
	private String tokenAcesso;
	private Date dataHoraExpiracao;
	private String nomePerfil;
	
	public AutenticarUsuarioResponse() {
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

	public Date getDataHoraAcesso() {
		return dataHoraAcesso;
	}

	public void setDataHoraAcesso(Date dataHoraAcesso) {
		this.dataHoraAcesso = dataHoraAcesso;
	}

	public String getTokenAcesso() {
		return tokenAcesso;
	}

	public void setTokenAcesso(String tokenAcesso) {
		this.tokenAcesso = tokenAcesso;
	}

	public Date getDataHoraExpiracao() {
		return dataHoraExpiracao;
	}

	public void setDataHoraExpiracao(Date dataHoraExpiracao) {
		this.dataHoraExpiracao = dataHoraExpiracao;
	}

	public String getNomePerfil() {
		return nomePerfil;
	}

	public void setNomePerfil(String nomePerfil) {
		this.nomePerfil = nomePerfil;
	}

	@Override
	public String toString() {
		return "AutenticarUsuarioResponse [id=" + id + ", nome=" + nome + ", email=" + email + ", dataHoraAcesso="
				+ dataHoraAcesso + ", tokenAcesso=" + tokenAcesso + ", dataHoraExpiracao=" + dataHoraExpiracao
				+ ", nomePerfil=" + nomePerfil + "]";
	}		
}
