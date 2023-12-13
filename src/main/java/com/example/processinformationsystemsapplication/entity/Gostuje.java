package com.example.processinformationsystemsapplication.entity;

import jakarta.persistence.*;

@Entity
@IdClass(GostujeId.class)
@Table(name = "gostuje")
public class Gostuje {

    @Id
    private String id_gosta;

    @Id
    private String id_emisije;

    // Constructors, getters, and setters

    public String getId_gosta() {
        return id_gosta;
    }

    public void setId_gosta(String id_gosta) {
        this.id_gosta = id_gosta;
    }

    public String getId_emisije() {
        return id_emisije;
    }

    public void setId_emisije(String id_emisije) {
        this.id_emisije = id_emisije;
    }
}
