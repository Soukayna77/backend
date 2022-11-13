package com.example.tt_recouvrement.controller;

import com.example.tt_recouvrement.model.Client;
import com.example.tt_recouvrement.model.User;
import com.example.tt_recouvrement.model.response.Response;
import com.example.tt_recouvrement.service.ClientService;
import com.example.tt_recouvrement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/client")
@CrossOrigin("*")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private UserService userService;

    @PostMapping("")
    public Response<Client> saveClient(@RequestBody Client client) {

        User user = new User(client.getEmail(),client.getPassword(),client.getName());
        Client client1 = clientService.saveClient(client).getData();
        user.setClient(client1);
        userService.save(user);

        return new Response<>("200","ajout ok",client1);
    }

    @PutMapping("{id_client}")
    public Response<Client> updateClient(@RequestBody Client client,@PathVariable String id_client) {
        return clientService.updateClient(client,id_client);
    }

    @DeleteMapping("{id_client}")
    public Response<Client> deleteClient(@PathVariable String id_client) {
        return clientService.deleteClient(id_client);
    }

    @GetMapping("")
    public Response<List<Client>> getAllClient() {
        return clientService.getAll();
    }

    @GetMapping("{id_client}")
    public Response<Client> getByIdClient(@PathVariable String id_client) {
        return clientService.getByIdClient(id_client);
    }
}
