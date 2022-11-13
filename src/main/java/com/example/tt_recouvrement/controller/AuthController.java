package com.example.tt_recouvrement.controller;



import com.example.tt_recouvrement.model.Client;
import com.example.tt_recouvrement.model.User;
import com.example.tt_recouvrement.model.response.JwtResponse;
import com.example.tt_recouvrement.model.response.Response;
import com.example.tt_recouvrement.model.response.SignInRequest;
import com.example.tt_recouvrement.repository.ClientRepository;
import com.example.tt_recouvrement.security.TokenUtil;
import com.example.tt_recouvrement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/auth")
public class AuthController {

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("user")
    public List<User> findAllUser() {
        return userService.findAll();
    }


    @PostMapping(value = {"","/"})
    public Response<JwtResponse> signIn(@RequestBody SignInRequest signInRequest){

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = userService.loadUserByUsername(signInRequest.getUsername());
        String token = tokenUtil.generateToken(userDetails);
        String refreshtToken = tokenUtil.generateRefreshtToken(userDetails);
        Client client = clientRepository.findClientByEmail(signInRequest.getUsername());

        JwtResponse response = new JwtResponse(token,refreshtToken,userDetails,client);
        return new Response<>("200","connect succ",response);

    }


}

