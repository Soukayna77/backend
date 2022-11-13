package com.example.tt_recouvrement.repository;

import com.example.tt_recouvrement.model.Contrat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratRepository extends MongoRepository<Contrat,String>{
}
