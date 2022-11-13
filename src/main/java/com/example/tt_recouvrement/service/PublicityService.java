package com.example.tt_recouvrement.service;


import com.example.tt_recouvrement.model.Publicity;
import com.example.tt_recouvrement.model.response.Response;
import com.example.tt_recouvrement.repository.PublicityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PublicityService {

    @Autowired
    private PublicityRepository publicityRepository;

    public Response<Publicity> savePublicity(Publicity publicity) {
        publicity.setCreated(new Date());
        return new Response<>("200","save publicity",publicityRepository.save(publicity));
    }

    public Response<Publicity> updatePublicity(Publicity publicity, String id_publicity) {
        publicity.setId(id_publicity);
        return new Response<>("200","update publicity",publicityRepository.save(publicity));
    }

    public Response<List<Publicity>> getAll() {
        return new Response<>("200","all publicity",publicityRepository.findAll());
    }

    public Response<Publicity> deletePublicity(String id_publicity) {
        try{
            publicityRepository.findById(id_publicity).get();
            publicityRepository.deleteById(id_publicity);
            return new Response<>("200","deleted publicity",null);
        } catch (Exception e) {
            return new Response<>("406","not found publicity",null);
        }
    }

    public Response<Publicity> getByIdPublicity(String id_publicity) {
        try{
            return new Response<>("200","get publicity with id "+id_publicity,publicityRepository.findById(id_publicity).get());
        } catch (Exception e) {
            return new Response<>("406","publicity not found",null);
        }
    }

}
