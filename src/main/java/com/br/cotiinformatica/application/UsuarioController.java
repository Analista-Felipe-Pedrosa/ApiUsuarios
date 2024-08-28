package com.br.cotiinformatica.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.cotiinformatica.domain.dtos.AutenticarUsuarioRequest;
import com.br.cotiinformatica.domain.dtos.AutenticarUsuarioResponse;
import com.br.cotiinformatica.domain.dtos.CriarUsuarioRequest;
import com.br.cotiinformatica.domain.dtos.CriarUsuarioResponse;
import com.br.cotiinformatica.domain.dtos.ObterDadosUsuarioResponse;
import com.br.cotiinformatica.domain.interfaces.UsuarioService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	
	@Autowired //injeção de dependência
	private UsuarioService usuarioService;
	
	@PostMapping("criar")
	public CriarUsuarioResponse criar(@RequestBody @Valid CriarUsuarioRequest request) throws Exception{
		return usuarioService.criar(request); 
	}
	
	@PostMapping("autenticar")
	public AutenticarUsuarioResponse autenticar(@RequestBody @Valid AutenticarUsuarioRequest request) throws Exception{
		return usuarioService.autenticar(request);
	}
	
	@GetMapping("obter-dados")
	public ObterDadosUsuarioResponse obterDados(HttpServletRequest request) throws Exception{
		
		// extraindo o token		
		String token = request.getHeader("Authorization").replace("Bearer", "").trim();
		
		// consultando os dados do usuário
		
		return usuarioService.obterDados(token);
	}
	

}
