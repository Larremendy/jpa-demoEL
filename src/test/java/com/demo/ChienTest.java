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

    @Test
    public void testCascadeRemove(){
        Chien chien = ChienDAO.findById(1);
        ChienDAO.delete(chien);
    }

    @Test
    public void testCascadePersist(){
        Person xavier = new Person("Xavier", "Durand");

        Chien chien = new Chien("Rocky", "Teckel", 5);
        chien.setMaitre(xavier);
        ChienDAO.save(chien);
    }


}
