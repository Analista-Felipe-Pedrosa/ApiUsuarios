package com.br.cotiinformatica.domain.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CriarUsuarioRequest {
	
	@NotEmpty(message = "Por favor informe o Nome do Usuário")
	@Size(min = 8, max = 100, message = "Informe o nome do Usuário com 8 a 100 caracteres")
	private String nome;
	
	@Email(message = "Informe um endereço de email válido")
	@NotEmpty(message = "Por favor informe o Email do Usuário")	
	private String email;
	
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$",
			message = "Informe a senha com letras minúsculas, maiúsculas, números, símbolos e pelo menos 8 caracteres.")
	@NotEmpty(message = "Por favor informe a senha do Usuário")
	private String senha;
	
	public CriarUsuarioRequest() {
		// TODO Auto-generated constructor stub
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "CriarUsuarioRequest [nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
	}		
}
