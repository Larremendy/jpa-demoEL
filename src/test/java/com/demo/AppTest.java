package com.demo;

import static org.junit.jupiter.api.Assertions.*;

import com.demo.jpa.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

public class AppTest
{
    @Test
    public void testSaveAddress(){
        Address address = new Address("rue de la Paix", "Paris", 13);
        AddressDAO.save(address);
    }

    @Test
    public void testSavePersonAddress(){
        Address address = new Address("rue de la Paix", "Paris", 13);
        AddressDAO.save(address);

        Person marie = new Person("Marie", "Dupont");
        marie.setAddress(address);
        PersonDAO.save(marie);
    }

    @Test
    public void testStage(){
        Person marie = new Person("Marie", "Dupont");
        PersonDAO.save(marie);

        Person alain = new Person("Alain", "Dufour");
        PersonDAO.save(alain);

        Person said = new Person("Said", "Dominguez");
        PersonDAO.save(said);

        Stage salsa = new Stage("Stage Salsa", "pratique avancée de la Salsa",
                LocalDateTime.of(2024, 12, 13, 9,30));
        salsa.addIntern(marie);
        salsa.addIntern(alain);
        StageDAO.save(salsa);

        Stage java = new Stage("Java pour les nuls", "les fondamentaux du langage",
                LocalDateTime.of(2024, 4, 13, 9,30));
        java.addIntern(alain);
        java.addIntern(said);
        StageDAO.save(java);

    }

    @Test
    public void testLectureStage(){

        Stage stage = StageDAO.findById(2);
        List<Person> participants = stage.getInterns();
        for (Person p : participants){
            System.out.println(p);
        }

    }

    @Test
    public void testNonCascade(){
        Address address = new Address("rue de la Paix", "Paris", 13);

        Person marie = new Person("Marie", "Dupont");
        marie.setAddress(address);
        PersonDAO.save(marie);
    }


}
