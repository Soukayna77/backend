package com.example.tt_recouvrement.repository;


import com.example.tt_recouvrement.model.Publicity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicityRepository extends MongoRepository<Publicity,String> {
}
