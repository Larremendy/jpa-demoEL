package com.demo;

import com.demo.jpa.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SportTest
{
    @Test
    public void testSport(){
        Person marie = new Person("Marie", "Dupont");
        PersonDAO.save(marie);
        Person alain = new Person("Alain", "Dufour");
        PersonDAO.save(alain);
        Person said = new Person("Said", "Dominguez");
        PersonDAO.save(said);

        Sport foot = new Sport("Foot");
        foot.addSportif(marie);
        foot.addSportif(alain);
        SportDAO.save(foot);

        Sport basket = new Sport("Basket");
        basket.addSportif(alain);
        basket.addSportif(said);
        SportDAO.save(basket);
    }

    @Test
    void testLectureSport(){
        Sport sport = SportDAO.findById(2);
        List<Person> sportifs = sport.getSportifs();
        for(Person p : sportifs)
            System.out.println(p);
    }

    @Test
    void testLectureSportif(){
        Person sportif = PersonDAO.findById(18);
        sportif.getSports().forEach(
                s -> System.out.println(s)
        );
    }


}
