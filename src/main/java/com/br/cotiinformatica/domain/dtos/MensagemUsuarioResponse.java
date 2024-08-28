package com.br.cotiinformatica.domain.dtos;

public class MensagemUsuarioResponse {

	private String emailDestinatario;
	private String assunto;
	private String texto;
	
	public MensagemUsuarioResponse() {
		// TODO Auto-generated constructor stub
	}

	public String getEmailDestinatario() {
		return emailDestinatario;
	}

	public void setEmailDestinatario(String emailDestinatario) {
		this.emailDestinatario = emailDestinatario;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "MensagemUsuarioResponse [emailDestinatario=" + emailDestinatario + ", assunto=" + assunto + ", texto="
				+ texto + "]";
	}		
}
