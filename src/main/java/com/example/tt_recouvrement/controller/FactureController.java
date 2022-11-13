package com.example.tt_recouvrement.controller;

import com.example.tt_recouvrement.model.Facture;
import com.example.tt_recouvrement.model.response.Response;
import com.example.tt_recouvrement.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/facture")
@CrossOrigin("*")
public class FactureController {

    @Autowired
    private FactureService factureService;

    @PostMapping("")
    public Response<Facture> saveFacture(@RequestBody Facture facture) {
        return factureService.saveFacture(facture);
    }

    @PutMapping("{id_facture}")
    public Response<Facture> updateFacture(@RequestBody Facture facture,@PathVariable String id_facture) {
        return factureService.updateFacture(facture,id_facture);
    }

    @DeleteMapping("{id_facture}")
    public Response<Facture> deleteFacture(@PathVariable String id_facture) {
        return factureService.deleteFacture(id_facture);
    }

    @GetMapping("")
    public Response<List<Facture>> getAllFacture() {
        return factureService.getAll();
    }

    @GetMapping("{id_facture}")
    public Response<Facture> getByIdFacture(@PathVariable String id_facture) {
        return factureService.getByIdFacture(id_facture);
    }
}
