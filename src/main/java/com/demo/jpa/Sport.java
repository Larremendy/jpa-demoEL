package com.demo.jpa;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="sports")
public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Person> sportifs = new ArrayList<>();

    public Sport() {
    }

    public Sport(String nom) {
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

    public List<Person> getSportifs() {
        return sportifs;
    }

    public void setSportifs(List<Person> sportifs) {
        this.sportifs = sportifs;
    }

    public void addSportif(Person p){
        sportifs.add(p);
    }

    @Override
    public String toString() {
        return "Sport{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", sportifs=" + sportifs +
                '}';
    }
}
