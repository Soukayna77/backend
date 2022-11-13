package com.example.tt_recouvrement.service;


import com.example.tt_recouvrement.model.Stage;
import com.example.tt_recouvrement.model.response.Response;
import com.example.tt_recouvrement.repository.StageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StageService {

    @Autowired
    private StageRepository stageRepository;


    public Response<Stage> saveStage(Stage stage) {
        stage.setCreated(new Date());
        return new Response<>("200","save stage",stageRepository.save(stage));
    }

    public Response<Stage> updateStage(Stage stage, String id_stage) {
        stage.setId(id_stage);
        return new Response<>("200","update stage",stageRepository.save(stage));
    }

    public Response<List<Stage>> getAll() {
        return new Response<>("200","all stage",stageRepository.findAll());
    }

    public Response<Stage> deleteStage(String id_stage) {
        try{
            stageRepository.findById(id_stage).get();
            stageRepository.deleteById(id_stage);
            return new Response<>("200","deleted",null);
        } catch (Exception e) {
            return new Response<>("406","not found",null);
        }
    }

    public Response<Stage> getByIdStage(String id_stage) {
        try{
            return new Response<>("200","get stage with id "+id_stage,stageRepository.findById(id_stage).get());
        } catch (Exception e) {
            return new Response<>("406","stage not found",null);
        }
    }




}
