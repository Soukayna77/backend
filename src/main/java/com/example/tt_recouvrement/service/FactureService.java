package com.example.tt_recouvrement.service;


import com.example.tt_recouvrement.model.Facture;
import com.example.tt_recouvrement.model.response.Response;
import com.example.tt_recouvrement.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FactureService {

     @Autowired
    private FactureRepository factureRepository;

    public Response<Facture> saveFacture(Facture facture) {
        facture.setCreated(new Date());
        return new Response<>("200","save Facture",factureRepository.save(facture));
    }

    public Response<Facture> updateFacture(Facture facture, String id_facture) {
        facture.setId(id_facture);
        return new Response<>("200","update Facture",factureRepository.save(facture));
    }

    public Response<List<Facture>> getAll() {
        return new Response<>("200","all Facture",factureRepository.findAll());
    }

    public Response<Facture> deleteFacture(String id_facture) {
        try{
            factureRepository.findById(id_facture).get();
            factureRepository.deleteById(id_facture);
            return new Response<>("200","deleted Facture",null);
        } catch (Exception e) {
            return new Response<>("406","not found Facture",null);
        }
    }

    public Response<Facture> getByIdFacture(String id_facture) {
        try{
            return new Response<>("200","get Facture with id "+id_facture,factureRepository.findById(id_facture).get());
        } catch (Exception e) {
            return new Response<>("406","Facture not found",null);
        }
    }
}
