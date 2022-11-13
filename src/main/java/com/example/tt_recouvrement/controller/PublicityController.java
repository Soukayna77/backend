package com.example.tt_recouvrement.controller;


import com.example.tt_recouvrement.model.Publicity;
import com.example.tt_recouvrement.model.response.Response;
import com.example.tt_recouvrement.service.PublicityService;
import com.example.tt_recouvrement.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/publicity")
@CrossOrigin("*")
public class PublicityController {

    @Autowired
    private PublicityService publicityService;

    @Autowired
    private StorageService storageService;

    @PostMapping("")
    public Response<Publicity> savePublicity(@RequestBody Publicity publicity) {
        return publicityService.savePublicity(publicity);
    }

    @PostMapping("image")
    public Response<Publicity> savePublicityWithImage(@RequestParam("file") MultipartFile file, Publicity publicity){

        String newFileName = storageService.CreateNameImage(file);
        storageService.store(file,newFileName);
        publicity.setPicture(newFileName);
        return publicityService.savePublicity(publicity);
    }

    @PutMapping("{id_publicity}")
    public Response<Publicity> updatePublicity(@RequestBody Publicity publicity,@PathVariable String id_publicity) {
        return publicityService.updatePublicity(publicity,id_publicity);
    }

    @DeleteMapping("{id_publicity}")
    public Response<Publicity> deletePublicity(@PathVariable String id_publicity) {
        return publicityService.deletePublicity(id_publicity);
    }

    @GetMapping("")
    public Response<List<Publicity>> getAllPublicity() {
        return publicityService.getAll();
    }

    @GetMapping("{id_publicity}")
    public Response<Publicity> getByIdPublicity(@PathVariable String id_publicity) {
        return publicityService.getByIdPublicity(id_publicity);
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
