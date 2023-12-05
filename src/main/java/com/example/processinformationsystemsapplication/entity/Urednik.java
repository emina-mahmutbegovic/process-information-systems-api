package com.example.processinformationsystemsapplication.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "urednik", uniqueConstraints = {
        @UniqueConstraint(name = "jedinstven_ime_prezime_telefon_urednik_set",
                columnNames = {"ime_urednika", "prezime_urednika", "kontakt_telefon_urednika"})
})
public class Urednik {

    @Id
    @Column(name = "id_urednika", length = 36)
    private String idUrednika;

    @Column(name = "ime_urednika", length = 50, nullable = false)
    private String imeUrednika;

    @Column(name = "prezime_urednika", length = 50, nullable = false)
    private String prezimeUrednika;

    @Column(name = "kontakt_telefon_urednika", length = 50, unique = true, nullable = false)
    private String kontaktTelefonUrednika;

    public Urednik(String imeUrednika,
                String prezimeUrednika,
                String kontaktTelefonUrednika) {
        this.idUrednika = String.valueOf(UUID.randomUUID());
        this.imeUrednika = imeUrednika;
        this.prezimeUrednika = prezimeUrednika;
        this.kontaktTelefonUrednika = kontaktTelefonUrednika;
    }

    public Urednik() {}

    public String getIdUrednika() {
        return idUrednika;
    }

    public String getImeUrednika() {
        return imeUrednika;
    }

    public void setImeUrednika(String imeUrednika) {
        this.imeUrednika = imeUrednika;
    }

    public String getPrezimeUrednika() {
        return prezimeUrednika;
    }

    public void setPrezimeUrednika(String prezimeUrednika) {
        this.prezimeUrednika = prezimeUrednika;
    }

    public String getKontaktTelefonUrednika() {
        return kontaktTelefonUrednika;
    }

    public void setKontaktTelefonUrednika(String kontaktTelefonUrednika) {
        this.kontaktTelefonUrednika = kontaktTelefonUrednika;
    }
}

