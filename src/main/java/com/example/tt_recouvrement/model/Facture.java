package com.example.tt_recouvrement.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document
public class Facture {

    @Id
    private String id;
    private Long numFacture;
    private Double amount;
    private String description;
    private Date dateStart;
    private Date dateEnd;
    private Date created;
    private boolean etat;

    public boolean isEtat() {

        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public Facture(Double amount, String description) {
        this.amount = amount;
        this.description = description;
        this.created = new Date();
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getNumFacture() {
        return numFacture;
    }

    public void setNumFacture(Long numFacture) {
        this.numFacture = numFacture;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
