package com.example.tt_recouvrement.model;


import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Client extends User {

    private Long tel1;
    private Long tel2;
    private List<Contrat> contrats;
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Contrat> getContrats() {
        return contrats;
    }

    public void setContrats(List<Contrat> contrats) {
        this.contrats = contrats;
    }

    public Long getTel1() {
        return tel1;
    }

    public void setTel1(Long tel1) {
        this.tel1 = tel1;
    }

    public Long getTel2() {
        return tel2;
    }

    public void setTel2(Long tel2) {
        this.tel2 = tel2;
    }
}
