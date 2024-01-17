package com.demo;

import static org.junit.jupiter.api.Assertions.*;

import com.demo.jpa.Address;
import com.demo.jpa.AddressDAO;
import com.demo.jpa.Person;
import com.demo.jpa.PersonDAO;
import org.junit.jupiter.api.Test;

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
}
