package com.br.cotiinformatica.infrastrutures.components;

import java.util.Date;
import java.util.UUID;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.cotiinformatica.domain.dtos.MensagemUsuarioResponse;
import com.br.cotiinformatica.infrastrutures.collection.LogMensageria;
import com.br.cotiinformatica.infrastrutures.repositories.LogMensageriaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RabbitMQProducerComponent {
	
	/*
	 * Permitir acessar o servidor do RabbitMQ
	 */
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	/*
	 * Permitir acessar a fila do servidor
	 */
	@Autowired
	private Queue queue;
	
	/*
	 * Permitir serializar os dados que serão gravados na fila
	 * enviar estes dados para a fila em formato JSON
	 */
	@Autowired
	private ObjectMapper objectMapper;
	
	
	/*
	 * Permitir aceso ao repositório para gravação de dados no banco do mongoDB
	 * 
	 */
	@Autowired
	private LogMensageriaRepository logMensageriaRepository;
	
	/*
	 * Método para gravar uma mensagem de usuário na fila
	 */
	public void send(MensagemUsuarioResponse mensagem) throws Exception {
		
		LogMensageria logMensageria = new LogMensageria();
		logMensageria.setId(UUID.randomUUID());
		logMensageria.setDataHora(new Date());
		logMensageria.setOperacao("ENVIO DE MENSAGEM PARA A FILA");
		
		try {
			//serializar os dados da mensagem em formato JSON
			String json = objectMapper.writeValueAsString(mensagem);			
			
			//enviando para o servidor de mensageria (fila)
			rabbitTemplate.convertAndSend(queue.getName(), json);	
			
			logMensageria.setStatus("SUCESSO");
			logMensageria.setDescricao(json);
		} catch (Exception e) {
			logMensageria.setStatus("ERRO");
			logMensageria.setDescricao(e.getMessage());
		}finally {
			logMensageriaRepository.save(logMensageria);
		}
		
	}	
}


