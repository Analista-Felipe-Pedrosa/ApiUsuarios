package com.br.cotiinformatica.infrastrutures.collection;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Document(collection = "log_mensageria")
public class LogMensageria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private UUID id;
	private Date dataHora;
	private String operacao;
	private String status;
	private String descricao;
	
	public LogMensageria() {
		// TODO Auto-generated constructor stub
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogMensageria other = (LogMensageria) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "LogMensageria [id=" + id + ", dataHora=" + dataHora + ", operacao=" + operacao + ", status=" + status
				+ ", descricao=" + descricao + "]";
	}		
}
