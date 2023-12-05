package com.example.processinformationsystemsapplication.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "epizoda")
public class Epizoda {

    @Id
    @Column(name = "id_epizode", length = 36)
    private String idEpizode;

    @Column(name = "naziv_epizode", length = 50, unique = true, nullable = false)
    private String nazivEpizode;

    @Column(name = "broj_epizode", nullable = false)
    private int brojEpizode;

    @Column(name = "broj_sezone", nullable = false)
    private int brojSezone;

    @Column(name = "opis_epizode", length = 500)
    private String opisEpizode;

    @ManyToOne
    @JoinColumn(name = "id_emisije", nullable = false)
    private Emisija emisija;

    public Epizoda(String nazivEpizode,
                   int brojEpizode,
                   int brojSezone,
                   String opisEpizode,
                   Emisija emisija){
        this.idEpizode = String.valueOf(UUID.randomUUID());
        this.nazivEpizode = nazivEpizode;
        this.brojEpizode = brojEpizode;
        this.brojSezone = brojSezone;
        this.opisEpizode = opisEpizode;
        this.emisija = emisija;
    }

    public Epizoda() {}

    public String getIdEpizode() {
        return idEpizode;
    }

    public String getNazivEpizode() {
        return nazivEpizode;
    }

    public void setNazivEpizode(String nazivEpizode) {
        this.nazivEpizode = nazivEpizode;
    }

    public int getBrojEpizode() {
        return brojEpizode;
    }

    public void setBrojEpizode(int brojEpizode) {
        this.brojEpizode = brojEpizode;
    }

    public int getBrojSezone() {
        return brojSezone;
    }

    public void setBrojSezone(int brojSezone) {
        this.brojSezone = brojSezone;
    }

    public String getOpisEpizode() {
        return opisEpizode;
    }

    public void setOpisEpizode(String opisEpizode) {
        this.opisEpizode = opisEpizode;
    }

    public Emisija getEmisija() {
        return emisija;
    }

    public void setEmisija(Emisija emisija) {
        this.emisija = emisija;
    }
}

