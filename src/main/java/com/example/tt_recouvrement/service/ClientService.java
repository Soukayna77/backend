package com.example.tt_recouvrement.service;


import com.example.tt_recouvrement.model.Client;
import com.example.tt_recouvrement.model.response.Response;
import com.example.tt_recouvrement.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    public Response<Client> saveClient(Client client) {
        client.setCreated(new Date());
        return new Response<>("200","save client",clientRepository.save(client));
    }

    public Response<Client> updateClient(Client client, String id_client) {
        client.setId(id_client);
        return new Response<>("200","update client",clientRepository.save(client));
    }

    public Response<List<Client>> getAll() {
        return new Response<>("200","all client",clientRepository.findAll());
    }

    public Response<Client> deleteClient(String id_client) {
        try{
            clientRepository.findById(id_client).get();
            clientRepository.deleteById(id_client);
            return new Response<>("200","deleted",null);
        } catch (Exception e) {
            return new Response<>("406","not found",null);
        }
    }

    public Response<Client> getByIdClient(String id_client) {
        try{
            return new Response<>("200","get client with id "+id_client,clientRepository.findById(id_client).get());
        } catch (Exception e) {
            return new Response<>("406","client not found",null);
        }
    }
}
