package com.br.cotiinformatica.infrastrutures.repositories;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.br.cotiinformatica.infrastrutures.collection.LogMensageria;

public interface LogMensageriaRepository extends MongoRepository<LogMensageria, UUID> {

}
