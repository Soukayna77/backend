package com.example.tt_recouvrement.controller;


import com.example.tt_recouvrement.model.Client;
import com.example.tt_recouvrement.model.Contrat;
import com.example.tt_recouvrement.model.response.Response;
import com.example.tt_recouvrement.service.ClientService;
import com.example.tt_recouvrement.service.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/contrat")
@CrossOrigin("*")
public class ContratController {


    @Autowired
    private ContratService contratService;

    @Autowired
    private ClientService clientService;


    @PostMapping("{id_client}")
    public Response<Contrat> saveContrat(@RequestBody Contrat contrat,@PathVariable String id_client ) {
        Client client = clientService.getByIdClient(id_client).getData();
        System.out.println("id"+client.getId());
        return contratService.saveContrat(contrat,client);
    }


    @PutMapping("{id_contrat}/{id_facture}")
    public Response<Contrat> updateContrat(@RequestBody Contrat contrat,@PathVariable String id_contrat,@PathVariable String id_facture) {
        System.out.println("here update contrat controller" + id_contrat + "id object " + contrat.getId());

        return contratService.updateContrat(contrat,id_contrat,id_facture);
    }


    @DeleteMapping("{id_contrat}")
    public Response<Contrat> deleteContrat(@PathVariable String id_contrat) {
        return contratService.deleteContrat(id_contrat);
    }


    @GetMapping("")
    public Response<List<Contrat>> getAllContrat() {
        return contratService.getAll();
    }


    @GetMapping("{id_contrat}")
    public Response<Contrat> getByIdContrat(@PathVariable String id_contrat) {
        return contratService.getByIdContrat(id_contrat);
    }
}
