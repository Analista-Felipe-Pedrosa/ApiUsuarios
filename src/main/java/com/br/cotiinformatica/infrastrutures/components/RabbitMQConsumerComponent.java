package com.br.cotiinformatica.infrastrutures.components;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
@Component
public class RabbitMQConsumerComponent {
	/*
	 * Método para ler e processar cada mensagem contida na fila
	 * do servidor de mensageria (RabbitMQ)
	 */
	@RabbitListener(queues = { "mensagens-usuarios" })
	public void proccess(@Payload String message) throws Exception {
		
		//imprimir o conteúdo lido da fila no console do eclipse
		//TODO integrar com o Outlook e enviar por email
		System.out.println("\nMENSAGEM PROCESSADA COM SUCESSO:");
		System.out.println(message);
	}
}

