package com.example.tt_recouvrement.controller;

import com.example.tt_recouvrement.model.Publicity;
import com.example.tt_recouvrement.model.Stage;
import com.example.tt_recouvrement.model.response.Response;
import com.example.tt_recouvrement.service.StageService;
import com.example.tt_recouvrement.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/stage")
@CrossOrigin("*")
public class StageController {

    @Autowired
    private StageService stageService;

    @Autowired
    private StorageService storageService;


    @PostMapping("")
    public Response<Stage> saveStage(@RequestBody Stage stage) {
        return stageService.saveStage(stage);
    }

    @PutMapping("{id_stage}")
    public Response<Stage> updateStage(@RequestBody Stage stage,@PathVariable String id_stage) {
        return stageService.updateStage(stage,id_stage);
    }

    @PostMapping("image")
    public Response<Stage> saveStageWithImage(@RequestParam("file") MultipartFile file, Stage stage){

        String newFileName = storageService.CreateNameImage(file);
        storageService.store(file,newFileName);
        stage.setPicture(newFileName);
        return stageService.saveStage(stage);
    }

    @DeleteMapping("{id_stage}")
    public Response<Stage> deleteStage(@PathVariable String id_stage) {
        return stageService.deleteStage(id_stage);
    }

    @GetMapping("")
    public Response<List<Stage>> getAllStage() {
        return stageService.getAll();
    }

    @GetMapping("{id_stage}")
    public Response<Stage> getByIdStage(@PathVariable String id_stage) {
        return stageService.getByIdStage(id_stage);
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
}
