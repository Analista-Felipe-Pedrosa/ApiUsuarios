package com.br.cotiinformatica.domain.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class AutenticarUsuarioRequest {
	
	@Email(message = "Por favor informe um endereço de email válido.")
	@NotEmpty(message = "Por favor informe o Email do Usuário.")
	private String email;
	
	@Size(min = 8, message = "Por favor informe a senha com pelo menos 8 caracteres.")
	@NotEmpty(message = "Por favor Informe a Senha do Usuario.")
	private String senha;
	
	public AutenticarUsuarioRequest() {
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "AutenticarUsuarioRequest [email=" + email + ", senha=" + senha + "]";
	}		
}
