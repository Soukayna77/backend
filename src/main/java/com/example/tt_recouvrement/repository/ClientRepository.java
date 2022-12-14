package com.example.tt_recouvrement.repository;

import com.example.tt_recouvrement.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<Client,String> {

    Client findClientByEmail(String email);
}
