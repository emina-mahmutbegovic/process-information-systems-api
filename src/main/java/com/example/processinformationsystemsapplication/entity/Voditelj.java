package com.example.processinformationsystemsapplication.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "voditelj", uniqueConstraints = {
        @UniqueConstraint(name = "jedinstven_ime_prezime_telefon_voditelj_set",
                columnNames = {"ime_voditelja", "prezime_voditelja", "kontakt_telefon_voditelja"})
})
public class Voditelj {

    @Id
    @Column(name = "id_voditelja", length = 36)
    private String idVoditelja;

    @Column(name = "ime_voditelja", length = 50, nullable = false)
    private String imeVoditelja;

    public Voditelj(String imeVoditelja,
                   String prezimeVoditelja,
                   String kontaktTelefonVoditelja) {
        this.idVoditelja = String.valueOf(UUID.randomUUID());
        this.imeVoditelja = imeVoditelja;
        this.prezimeVoditelja = prezimeVoditelja;
        this.kontaktTelefonVoditelja = kontaktTelefonVoditelja;
    }

    public Voditelj() {}

    public String getIdVoditelja() {
        return idVoditelja;
    }

    public String getImeVoditelja() {
        return imeVoditelja;
    }

    public void setImeVoditelja(String imeVoditelja) {
        this.imeVoditelja = imeVoditelja;
    }

    public String getPrezimeVoditelja() {
        return prezimeVoditelja;
    }

    public void setPrezimeVoditelja(String prezimeVoditelja) {
        this.prezimeVoditelja = prezimeVoditelja;
    }

    public String getKontaktTelefonVoditelja() {
        return kontaktTelefonVoditelja;
    }

    public void setKontaktTelefonVoditelja(String kontaktTelefonVoditelja) {
        this.kontaktTelefonVoditelja = kontaktTelefonVoditelja;
    }

    @Column(name = "prezime_voditelja", length = 50, nullable = false)
    private String prezimeVoditelja;

    @Column(name = "kontakt_telefon_voditelja", length = 50, unique = true, nullable = false)
    private String kontaktTelefonVoditelja;
}

