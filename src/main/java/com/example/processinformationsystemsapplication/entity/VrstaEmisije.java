package com.example.processinformationsystemsapplication.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vrsta_emisije")
public class VrstaEmisije {

    @Id
    @Column(name = "id_vrste_emisije", length = 36)
    private String idVrsteEmisije;

    @Column(name = "naziv_vrste_emisije", length = 50, unique = true, nullable = false)
    private String nazivVrsteEmisije;

    public String getIdVrsteEmisije() {
        return idVrsteEmisije;
    }

    public String getNazivVrsteEmisije() {
        return nazivVrsteEmisije;
    }

    public void setNazivVrsteEmisije(String nazivVrsteEmisije) {
        this.nazivVrsteEmisije = nazivVrsteEmisije;
    }
}

