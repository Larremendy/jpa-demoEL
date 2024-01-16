package com.demo;


import com.demo.jpa.Person;
import com.demo.jpa.PersonDAO;

public class App
{
    public static void main( String[] args )
    {
        /*
        Person jcd = new Person("Jean-Christophe", "Dominguez");
        PersonDAO.save(jcd);*/


        Person person = PersonDAO.findById(2);
        System.out.println(person);
    }
}
