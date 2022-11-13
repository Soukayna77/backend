package com.example.tt_recouvrement.repository;

import com.example.tt_recouvrement.model.Reclamation;
import com.example.tt_recouvrement.model.Stage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamationRepository extends MongoRepository<Reclamation,String> {
}
