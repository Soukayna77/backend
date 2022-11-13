package com.example.tt_recouvrement.service;


import com.example.tt_recouvrement.model.Reclamation;
import com.example.tt_recouvrement.model.response.Response;
import com.example.tt_recouvrement.repository.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReclamationService {

    @Autowired
    private ReclamationRepository reclamationRepository;


    public Response<Reclamation> saveReclamation(Reclamation reclamation) {
        reclamation.setCreated(new Date());
        return new Response<>("200","save reclamation",reclamationRepository.save(reclamation));
    }

    public Response<Reclamation> updateReclamation(Reclamation reclamation, String id_reclamation) {
        reclamation.setId(id_reclamation);
        return new Response<>("200","update reclamation",reclamationRepository.save(reclamation));
    }

    public Response<List<Reclamation>> getAll() {
        return new Response<>("200","all reclamation",reclamationRepository.findAll());
    }

    public Response<Reclamation> deleteReclamation(String id_reclamation) {
        try{
            reclamationRepository.findById(id_reclamation).get();
            reclamationRepository.deleteById(id_reclamation);
            return new Response<>("200","deleted",null);
        } catch (Exception e) {
            return new Response<>("406","not found",null);
        }
    }

    public Response<Reclamation> getByIdReclamation(String id_reclamation) {
        try{
            return new Response<>("200","get reclamation with id "+id_reclamation,reclamationRepository.findById(id_reclamation).get());
        } catch (Exception e) {
            return new Response<>("406","reclamation not found",null);
        }
    }


}
