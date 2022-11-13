package com.example.tt_recouvrement.utils;

import com.example.tt_recouvrement.model.Client;
import com.example.tt_recouvrement.model.User;
import com.example.tt_recouvrement.repository.ClientRepository;
import com.example.tt_recouvrement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FirstTimeInitializer implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private ClientRepository clientRepository;


    @Override
    public void run(String... args) throws Exception {


        if(userService.findAll().isEmpty()){

            Client client = new Client();
            client.setRole("admin");
            client.setEmail("TTAdmin@gmail.com");
            client.setName("TTAdmin");
            clientRepository.save(client);

            User user = new User("TTAdmin@gmail.com","password","TTAdmin");
            userService.save(user);
        }

    }
}
