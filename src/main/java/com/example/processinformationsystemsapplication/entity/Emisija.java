package com.example.processinformationsystemsapplication.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "emisija")
public class Emisija {

    @Id
    @Column(name = "id_emisije", length = 36)
    private String idEmisije;

    @Column(name = "naziv_emisije", length = 50, unique = true, nullable = false)
    private String nazivEmisije;

    @Column(name = "opis_emisije", length = 500)
    private String opisEmisije;

    @Column(name = "trajanje_emisije", nullable = false)
    private int trajanjeEmisije;

    @Column(name = "ocjena_emisije", nullable = false)
    private int ocjenaEmisije;

    @ManyToOne
    @JoinColumn(name = "id_vrste_emisije", nullable = false)
    private VrstaEmisije vrstaEmisije;

    @ManyToOne
    @JoinColumn(name = "id_voditelja", nullable = false)
    private Voditelj voditelj;

    @ManyToOne
    @JoinColumn(name = "id_urednika", nullable = false)
    private Urednik urednik;

    @ManyToOne
    @JoinColumn(name = "id_gosta")
    private Gost gost;

    public Emisija(String nazivEmisije,
                   String opisEmisije,
                   int trajanjeEmisije,
                   int ocjenaEmisije,
                   VrstaEmisije vrstaEmisije,
                   Voditelj voditelj,
                   Urednik urednik,
                   Gost gost){
        this.idEmisije = String.valueOf(UUID.randomUUID());
        this.nazivEmisije = nazivEmisije;
        this.opisEmisije = opisEmisije;
        this.trajanjeEmisije = trajanjeEmisije;
        this.ocjenaEmisije = ocjenaEmisije;
        this.vrstaEmisije = vrstaEmisije;
        this.voditelj = voditelj;
        this.urednik = urednik;
        this.gost = gost;
    }

    public Emisija() {}

    public String getIdEmisije() {
        return idEmisije;
    }

    public void setIdEmisije(String idEmisije) {
        this.idEmisije = idEmisije;
    }

    public String getNazivEmisije() {
        return nazivEmisije;
    }

    public void setNazivEmisije(String nazivEmisije) {
        this.nazivEmisije = nazivEmisije;
    }

    public String getOpisEmisije() {
        return opisEmisije;
    }

    public void setOpisEmisije(String opisEmisije) {
        this.opisEmisije = opisEmisije;
    }

    public int getTrajanjeEmisije() {
        return trajanjeEmisije;
    }

    public void setTrajanjeEmisije(int trajanjeEmisije) {
        this.trajanjeEmisije = trajanjeEmisije;
    }

    public int getOcjenaEmisije() {
        return ocjenaEmisije;
    }

    public void setOcjenaEmisije(int ocjenaEmisije) {
        this.ocjenaEmisije = ocjenaEmisije;
    }

    public VrstaEmisije getVrstaEmisije() {
        return vrstaEmisije;
    }

    public void setVrstaEmisije(VrstaEmisije vrstaEmisije) {
        this.vrstaEmisije = vrstaEmisije;
    }

    public Voditelj getVoditelj() {
        return voditelj;
    }

    public void setVoditelj(Voditelj voditelj) {
        this.voditelj = voditelj;
    }

    public Urednik getUrednik() {
        return urednik;
    }

    public void setUrednik(Urednik urednik) {
        this.urednik = urednik;
    }

    public Gost getGost() {
        return gost;
    }

    public void setGost(Gost gost) {
        this.gost = gost;
    }
}

