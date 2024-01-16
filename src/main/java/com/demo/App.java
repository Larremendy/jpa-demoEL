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
        PersonDAO.save(jcd);*/

/*
        Person person = PersonDAO.findById(2);
        System.out.println(person);*/

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
        }

    }
}
