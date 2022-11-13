package com.example.tt_recouvrement.controller;

import com.example.tt_recouvrement.model.Reclamation;
import com.example.tt_recouvrement.model.response.Response;
import com.example.tt_recouvrement.repository.ReclamationRepository;
import com.example.tt_recouvrement.service.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reclamation")
@CrossOrigin("*")
public class ReclamationController {

    @Autowired
    private ReclamationService reclamationService;

    @Autowired
    private ReclamationRepository reclamationRepository;

    @PostMapping("")
    public Response<Reclamation> saveReclamation(@RequestBody Reclamation reclamation) {
        reclamation.setEtat(false);
        return reclamationService.saveReclamation(reclamation);
    }

    @PutMapping("{id_reclamation}")
    public Response<Reclamation> updateReclamation(@RequestBody Reclamation reclamation,@PathVariable String id_reclamation) {
        return reclamationService.updateReclamation(reclamation,id_reclamation);
    }

    @DeleteMapping("{id_reclamation}")
    public Response<Reclamation> deleteReclamation(@PathVariable String id_reclamation) {
        return reclamationService.deleteReclamation(id_reclamation);
    }

    @GetMapping("")
    public Response<List<Reclamation>> getAllReclamation() {
        return reclamationService.getAll();
    }

    @GetMapping("{id_reclamation}")
    public Response<Reclamation> getByIdReclamation(@PathVariable String id_reclamation) {
        return reclamationService.getByIdReclamation(id_reclamation);
    }

    @GetMapping("archive/{id_reclamation}")
    public Reclamation updateArchive(@PathVariable String id_reclamation) {
        Reclamation reclamation = reclamationRepository.findById(id_reclamation).orElse(null);
        reclamation.setEtat(true);
        return reclamationRepository.save(reclamation);

    }
}
