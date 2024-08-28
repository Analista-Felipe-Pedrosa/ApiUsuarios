package com.br.cotiinformatica.domain.services;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.cotiinformatica.domain.dtos.AutenticarUsuarioRequest;
import com.br.cotiinformatica.domain.dtos.AutenticarUsuarioResponse;
import com.br.cotiinformatica.domain.dtos.CriarUsuarioRequest;
import com.br.cotiinformatica.domain.dtos.CriarUsuarioResponse;
import com.br.cotiinformatica.domain.dtos.MensagemUsuarioResponse;
import com.br.cotiinformatica.domain.dtos.ObterDadosUsuarioResponse;
import com.br.cotiinformatica.domain.exception.AcessoNegadoException;
import com.br.cotiinformatica.domain.exception.EmailJaCadastradoException;
import com.br.cotiinformatica.domain.interfaces.UsuarioService;
import com.br.cotiinformatica.domain.models.Usuario;
import com.br.cotiinformatica.infrastrutures.components.JwtTokenComponent;
import com.br.cotiinformatica.infrastrutures.components.RabbitMQProducerComponent;
import com.br.cotiinformatica.infrastrutures.components.SHA256Components;
import com.br.cotiinformatica.infrastrutures.repositories.PerfilRepository;
import com.br.cotiinformatica.infrastrutures.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImp implements UsuarioService {

	@Autowired // injeção de dependência
	private UsuarioRepository usuarioRepository;

	@Autowired // injeção de dependência
	private PerfilRepository perfilRepository;

	@Autowired
	private SHA256Components sha256Components;
	
	@Autowired
	private JwtTokenComponent jwtTokenComponent;
	
	@Autowired
	private RabbitMQProducerComponent rabbitMQProducerComponent;

	@Override
	public CriarUsuarioResponse criar(CriarUsuarioRequest request) throws Exception {

		if (usuarioRepository.findByEmail(request.getEmail()) != null) {
			throw new EmailJaCadastradoException();
		}

		Usuario usuario = new Usuario();

		usuario.setId(UUID.randomUUID());
		usuario.setNome(request.getNome());
		usuario.setEmail(request.getEmail());
		usuario.setSenha(sha256Components.hash(request.getSenha()));
		usuario.setPerfil(perfilRepository.findByNome("DEFAULT"));
		usuarioRepository.save(usuario);
		
		// Escrever mensagem de boas vindas para o Usuário
		MensagemUsuarioResponse mensagem = new MensagemUsuarioResponse();
		mensagem.setEmailDestinatario(usuario.getEmail());
		mensagem.setAssunto("Confirmação de cadastro");
		mensagem.setTexto("Ola " + usuario.getNome() + ". Parabéns seu cadastro foi realizado com Sucesso !");
		
		// Enviando a Mensagem para fila 		
		rabbitMQProducerComponent.send(mensagem);

		// 
		CriarUsuarioResponse response = new CriarUsuarioResponse();
		response.setId(usuario.getId());
		response.setNome(usuario.getNome());
		response.setEmail(usuario.getEmail());
		response.setDataHoraCadastro(new Date());

		return response;
	}

	@Override
	public AutenticarUsuarioResponse autenticar(AutenticarUsuarioRequest request) throws Exception {
		// consultando o usuário no banco de dados
		// através do email e da senha
		
		Usuario usuario = usuarioRepository.findByEmailAndSenha(request.getEmail(), sha256Components.hash(request.getSenha()));
		
		// verificando se o usuário não foi encontrado
		if (usuario == null)
			throw new AcessoNegadoException();
		
		//retornando os dados do usuário autenticado
		AutenticarUsuarioResponse response = new AutenticarUsuarioResponse();
		response.setId(usuario.getId());
		response.setNome(usuario.getNome());
		response.setEmail(usuario.getEmail());
		response.setDataHoraAcesso(new Date());

		response.setTokenAcesso(jwtTokenComponent.generateToken(usuario)); 			
		response.setDataHoraExpiracao(jwtTokenComponent.getExpirationDate());
		response.setNomePerfil(usuario.getPerfil().getNome());
		
		return response;
	}

	@Override
	public ObterDadosUsuarioResponse obterDados(String Token) throws Exception {
		
		String email = jwtTokenComponent.getEmailFromToken(Token);
		
		// consultando os dados do usuário através do email.
		
		Usuario usuario = usuarioRepository.findByEmail(email);
		
		// verifica se usuário foi encontrado
		
		if (usuario == null) 
			throw new AcessoNegadoException();
			
			//retornando os dados do usuário
			ObterDadosUsuarioResponse response = new ObterDadosUsuarioResponse();
			response.setId(usuario.getId());
			response.setNome(usuario.getNome());
			response.setEmail(usuario.getEmail());
			response.setNomePerfil(usuario.getPerfil().getNome());
			
			return response;							
	}
}
