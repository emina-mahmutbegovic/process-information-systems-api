package com.example.processinformationsystemsapplication.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "termin_emitovanja")
public class TerminEmitovanja {

    @Id
    @Column(name = "vrijeme_pocetka")
    private java.sql.Time vrijemePocetka;

    @Column(name = "vrijeme_zavrsetka", unique = true, nullable = false)
    private java.sql.Time vrijemeZavrsetka;

    @Column(name = "datum_emitovanja", nullable = false)
    private java.sql.Date datumEmitovanja;

    @ManyToOne
    @JoinColumn(name = "id_epizode", nullable = false)
    private Epizoda epizoda;

    public Time getVrijemePocetka() {
        return vrijemePocetka;
    }

    public void setVrijemePocetka(Time vrijemePocetka) {
        this.vrijemePocetka = vrijemePocetka;
    }

    public Time getVrijemeZavrsetka() {
        return vrijemeZavrsetka;
    }

    public void setVrijemeZavrsetka(Time vrijemeZavrsetka) {
        this.vrijemeZavrsetka = vrijemeZavrsetka;
    }

    public Date getDatumEmitovanja() {
        return datumEmitovanja;
    }

    public void setDatumEmitovanja(Date datumEmitovanja) {
        this.datumEmitovanja = datumEmitovanja;
    }

    public Epizoda getEpizoda() {
        return epizoda;
    }

    public void setEpizoda(Epizoda epizoda) {
        this.epizoda = epizoda;
    }
}

