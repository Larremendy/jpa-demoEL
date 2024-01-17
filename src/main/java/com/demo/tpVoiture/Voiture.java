package com.demo.tpVoiture;

import jakarta.persistence.*;

@Entity
@Table(name = "voitures")
public class Voiture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String marque;
    private String modele;
    @Column(name="annee_fabrication")
    private int anneeFabrication;
    private String immatriculation;
    private int kilometrage;

    public Voiture() {
    }

    public Voiture(String marque, String modele, int anneeFabrication, String immatriculation, int kilometrage) {
        this.marque = marque;
        this.modele = modele;
        this.anneeFabrication = anneeFabrication;
        this.immatriculation = immatriculation;
        this.kilometrage = kilometrage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getAnneeFabrication() {
        return anneeFabrication;
    }

    public void setAnneeFabrication(int anneeFabrication) {
        this.anneeFabrication = anneeFabrication;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "id=" + id +
                ", marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", anneeFabrication=" + anneeFabrication +
                ", immatriculation='" + immatriculation + '\'' +
                ", kilometrage=" + kilometrage +
                '}';
    }
}
