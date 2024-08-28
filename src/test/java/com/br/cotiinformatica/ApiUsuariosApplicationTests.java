package com.br.cotiinformatica;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.br.cotiinformatica.domain.dtos.CriarUsuarioRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ApiUsuariosApplicationTests {

	@Autowired
	
	private MockMvc mockMvc; //Executa chamadas para API
	
	@Autowired
	
	private ObjectMapper objectMapper; // Envia e recebe dados em formato JSON
	
	private static String nomeUsuario;
	private static String emailUsuario; // Armazenar o Email do Usuario cadastrado
	
	@Test
	@Order(1)
	public void criarUsuarioComSucessoTest() throws Exception{
		CriarUsuarioRequest request = new CriarUsuarioRequest();
		Faker faker = new Faker();
		
		//criando os dados para cadastro do usuário
		request.setNome(faker.name().fullName());
		request.setEmail(faker.internet().emailAddress());
		request.setSenha("@Teste123");
		
		//executando a chamada para a API
		mockMvc.perform(post("/api/usuario/criar") //endereço do endpoint
				.contentType("application/json") //formato dos dados (json)
				.content(objectMapper.writeValueAsString(request))) //envio dos dados
				.andExpect(status().isOk()); //verificando que o retorno foi sucesso

		nomeUsuario = request.getNome();
		emailUsuario = request.getEmail();
	}
	
	@Test
	@Order(2)
	public void emailJaCadastradoTest() throws Exception{
		CriarUsuarioRequest request = new CriarUsuarioRequest();
		
		//criando os dados para cadastro do usuário
		request.setNome(nomeUsuario); //mesmo nome cadastrado no teste anterior
		request.setEmail(emailUsuario); //mesmo email cadastrado no teste anterior
		request.setSenha("@Teste123");
		
		//executando a chamada para a API e capturando o retorno
		MvcResult result = mockMvc.perform(post("/api/usuario/criar") //endereço do endpoint
				.contentType("application/json") //formato dos dados (json)
				.content(objectMapper.writeValueAsString(request))) //envio dos dados
				.andExpect(status().isUnprocessableEntity()) //verificando o retorno HTTP 422	
				.andReturn(); //capturar o retorno da API
		
		//capturando a mensagem de erro
		String content = result.getResponse().getContentAsString(StandardCharsets.UTF_8);
		//verificando a mensagem (asserção / verificação)
		assertTrue(content.contains("Email informado já esta cadastrado, tente outro !"));

		
	}
	
	@Test
	@Order(3)
	public void validacaoDeCamposObrigatoriosTest() throws Exception{
		CriarUsuarioRequest request = new CriarUsuarioRequest();
		
		//enviando os campos vazios
		request.setNome(null);
		request.setEmail(null);
		request.setSenha(null);
		
		//executando a chamada para a API e capturando o retorno
		MvcResult result = mockMvc.perform(post("/api/usuario/criar")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isBadRequest())
				.andReturn();
		
		//capturando as mensagens de erro obtidas
		String content = result.getResponse().getContentAsString(StandardCharsets.UTF_8);
		
		//verificando as mensagens de erro
		assertTrue(content.contains("Por favor informe o Nome do Usuário"));
		assertTrue(content.contains("Por favor informe o Email do Usuário"));
		assertTrue(content.contains("Por favor informe a senha do Usuário"));
	}

}
