package com.demo;

import com.demo.jpa.*;
import com.demo.tpVoiture.Voiture;
import com.demo.tpVoiture.VoitureDAO;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

public class VoitureTest
{
    @Test
    public void testVoiture(){
        Voiture v1 = new Voiture("Mercedes", "Sprinter", 2022, "xxxx1234", 2000);
        VoitureDAO.save(v1);
    }

    @Test
    public void testVoitureLongString(){
        Voiture v1 = new Voiture("Mercedes", "Sprinter", 2022,
                "0123456789", 2000);
        VoitureDAO.save(v1);
    }

}
