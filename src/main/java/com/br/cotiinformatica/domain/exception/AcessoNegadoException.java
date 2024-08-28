package com.br.cotiinformatica.domain.exception;

public class AcessoNegadoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Acesso negado. Usuário não encontrado.";
	}

}
