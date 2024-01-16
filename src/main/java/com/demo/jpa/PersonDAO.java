package com.demo.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PersonDAO {

    // objectif du DAO (Database Access Object)
    // implémenter les opérations de base de type CRUD

    public static void save(Person person){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

       EntityTransaction tx = entityManager.getTransaction();
       try {
            tx.begin();
            entityManager.persist(person);
            tx.commit();
        }catch (Exception e){
            System.out.println("Erreur lors de l'enregistrement");
            tx.rollback();
        }
    }

    public static Person findById(Integer id){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        return entityManager.find(Person.class, id);
    }

}
