package com.br.cotiinformatica.domain.exception;

public class EmailJaCadastradoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Email informado já esta cadastrado, tente outro !";
	}
	
}
