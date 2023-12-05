package com.example.processinformationsystemsapplication.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "gost", uniqueConstraints = {
        @UniqueConstraint(name = "jedinstven_ime_prezime_telefon_gost_set",
                columnNames = {"ime_gosta", "prezime_gosta", "kontakt_telefon_gosta"})
})
public class Gost {

    @Id
    @Column(name = "id_gosta", length = 36)
    private String idGosta;

    @Column(name = "ime_gosta", length = 50, nullable = false)
    private String imeGosta;

    @Column(name = "prezime_gosta", length = 50, nullable = false)
    private String prezimeGosta;

    @Column(name = "biografija_gosta", length = 500, nullable = false)
    private String biografijaGosta;

    @Column(name = "kontakt_telefon_gosta", length = 50, unique = true, nullable = false)
    private String kontaktTelefonGosta;

    public Gost(String imeGosta,
         String prezimeGosta,
         String biografijaGosta,
         String kontaktTelefonGosta) {
        this.idGosta = String.valueOf(UUID.randomUUID());
        this.imeGosta = imeGosta;
        this.prezimeGosta = prezimeGosta;
        this.biografijaGosta = biografijaGosta;
        this.kontaktTelefonGosta = kontaktTelefonGosta;
    }

    public Gost() {}

    public String getIdGosta() {
        return idGosta;
    }

    public String getImeGosta() {
        return imeGosta;
    }

    public void setImeGosta(String imeGosta) {
        this.imeGosta = imeGosta;
    }

    public String getPrezimeGosta() {
        return prezimeGosta;
    }

    public void setPrezimeGosta(String prezimeGosta) {
        this.prezimeGosta = prezimeGosta;
    }

    public String getBiografijaGosta() {
        return biografijaGosta;
    }

    public void setBiografijaGosta(String biografijaGosta) {
        this.biografijaGosta = biografijaGosta;
    }

    public String getKontaktTelefonGosta() {
        return kontaktTelefonGosta;
    }

    public void setKontaktTelefonGosta(String kontaktTelefonGosta) {
        this.kontaktTelefonGosta = kontaktTelefonGosta;
    }
}

