package com.demo;

import com.demo.jpa.Chien;
import com.demo.jpa.ChienDAO;
import com.demo.jpa.Person;
import com.demo.jpa.PersonDAO;
import com.demo.tpVoiture.Voiture;
import com.demo.tpVoiture.VoitureDAO;
import org.junit.jupiter.api.Test;

public class ChienTest
{
    @Test
    public void testChien(){
        Person marie = new Person("Marie", "Dupont");
        PersonDAO.save(marie);

        Chien medor = new Chien("Medor", "Teckel", 5);
        medor.setMaitre(marie);
        ChienDAO.save(medor);
    }


}
