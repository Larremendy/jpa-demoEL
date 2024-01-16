package com.demo;


import com.demo.jpa.Person;
import com.demo.jpa.PersonDAO;

import java.util.List;
import java.util.Objects;

public class App
{
    public static void main( String[] args )
    {
/*
        Person jcd = new Person("Jean-Christophe", "Dominguez");
        System.out.println(jcd);
        PersonDAO.save(jcd);
        // Hibernate a mis à jour automatiquement l'id de notre objet
        System.out.println(jcd);*/

/*
        Person person = PersonDAO.findById(2);
        System.out.println(person);*/

        /*
        List<Person> persons = PersonDAO.findAll();
        for(Person p : persons){
            System.out.println(p);
        }


        List<String> names = PersonDAO.getNames();
        for(String name : names){
            System.out.println(name);
        }

        List personsWithFirstName = PersonDAO.findAllPersonsWithFirstName();
        for(Object p : personsWithFirstName){
            System.out.println(p.getClass());
        }*/

/*
        Person person = PersonDAO.findById(2);
        PersonDAO.delete(person);*/

/*
        Person person = PersonDAO.findById(1);
        person.setLastName("Hoffman");
        PersonDAO.update(person);*/

        // Attention le update() va faire un INSERT SQL au lieu du UPDATE SQL
        // si on ne fournit pas un id existant.
        Person marie = new Person("Marie", "Dupont");
        PersonDAO.update(marie);
    }
}
