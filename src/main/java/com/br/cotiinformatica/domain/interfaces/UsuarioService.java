package com.br.cotiinformatica.domain.interfaces;

import com.br.cotiinformatica.domain.dtos.AutenticarUsuarioRequest;
import com.br.cotiinformatica.domain.dtos.AutenticarUsuarioResponse;
import com.br.cotiinformatica.domain.dtos.CriarUsuarioRequest;
import com.br.cotiinformatica.domain.dtos.CriarUsuarioResponse;
import com.br.cotiinformatica.domain.dtos.ObterDadosUsuarioResponse;

public interface UsuarioService {

	 CriarUsuarioResponse criar(CriarUsuarioRequest request) throws Exception;
	 
	 AutenticarUsuarioResponse autenticar(AutenticarUsuarioRequest request) throws Exception;
	 
	 ObterDadosUsuarioResponse obterDados(String Token) throws Exception;
	 	 
}
