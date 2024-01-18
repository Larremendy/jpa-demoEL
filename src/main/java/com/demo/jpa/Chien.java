package com.demo.jpa;

import jakarta.persistence.*;

@Entity
@Table(name="chiens")
public class Chien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;
    private String race;
    private int age;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="person_id")
    private Person maitre;

    public Chien() {
    }

    public Chien(String nom, String race, int age) {
        this.nom = nom;
        this.race = race;
        this.age = age;
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

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getMaitre() {
        return maitre;
    }

    public void setMaitre(Person maitre) {
        this.maitre = maitre;
    }
}
