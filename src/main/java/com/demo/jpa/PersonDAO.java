package com.demo.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

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

    public static List<Person> findAll(){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        // JPQL : sorte de requete SQL mais avec les classes Java
        Query query  = entityManager.createQuery("SELECT p FROM Person p");// SELECT * FROM persons;
        return query.getResultList();
    }

    // avec le SELECT de JPQL on recupere une liste de String
    public static List<String> getNames(){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        // JPQL : sorte de requete SQL mais avec les classes Java
        Query query  = entityManager.createQuery("SELECT p.lastName FROM Person p");// SELECT * FROM persons;
        return query.getResultList();
    }

    // ??? SOLUTION pour créer une liste de Person partiellement remplis
    // à corriger
    public static List<Person> findAllPersonsWithFirstName() {
        List<Person> persons = null;
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        try {
            TypedQuery<Person> query = entityManager.createQuery("SELECT p.firstName FROM Person p", Person.class);
            persons = query.getResultList();
        } catch (Exception e) {
            System.out.println("Erreur lors de la récupération des personnes");
        }

        return persons;
    }

    public static void delete(Person person){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.remove(person);
            tx.commit();
        }catch (Exception e){
            System.out.println("Erreur lors de la suppression");
            tx.rollback();
        }
    }

}
