package com.example.tt_recouvrement.repository;


import com.example.tt_recouvrement.model.Facture;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FactureRepository extends MongoRepository<Facture,String> {

List<Facture> findAll(Sort sort);
}
