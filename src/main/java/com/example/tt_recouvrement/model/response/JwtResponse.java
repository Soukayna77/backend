package com.example.tt_recouvrement.model.response;


import com.example.tt_recouvrement.model.Client;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtResponse {

    private String token;

    private String refreshtToken;

    private UserDetails userDetails;

    private Client client;

    private Long id_user;

    private String role;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public JwtResponse(String token, String refreshtToken, UserDetails userDetails, Client client) {
        this.token = token;
        this.refreshtToken = refreshtToken;
        this.userDetails = userDetails;
        this.client = client;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefreshtToken() {
        return refreshtToken;
    }

    public void setRefreshtToken(String refreshtToken) {
        this.refreshtToken = refreshtToken;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
}
