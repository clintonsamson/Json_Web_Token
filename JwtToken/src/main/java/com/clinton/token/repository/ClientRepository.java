package com.clinton.token.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.clinton.token.model.Client;

public interface ClientRepository extends MongoRepository<Client, Long> {

	Client findByClientName(String username);

}
