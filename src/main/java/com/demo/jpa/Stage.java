package com.demo.jpa;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="stages")
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    private LocalDateTime schedule;

    public Stage() {
    }

    public Stage(String name, String description, LocalDateTime schedule) {
        this.name = name;
        this.description = description;
        this.schedule = schedule;
    }

    @ManyToMany
    private List<Person> interns = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getSchedule() {
        return schedule;
    }

    public void setSchedule(LocalDateTime schedule) {
        this.schedule = schedule;
    }

    public List<Person> getInterns() {
        return interns;
    }

    public void setInterns(List<Person> interns) {
        this.interns = interns;
    }

    public void addIntern(Person p){
        interns.add(p);
    }
}
