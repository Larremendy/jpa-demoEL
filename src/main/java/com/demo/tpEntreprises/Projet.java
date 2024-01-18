package com.demo.tpEntreprises;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="projets")
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;
    private String description;

    @ManyToMany
    @JoinTable(
            name="projets_employes",
            joinColumns = @JoinColumn(name="projet_id"),
            inverseJoinColumns = @JoinColumn(name="employe_id")
    )
    private List<Employe> employes = new ArrayList<>();

    public Projet() {
    }

    public Projet(String nom) {
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

    public void addEmploye(Employe e){
        employes.add(e);
    }
}
