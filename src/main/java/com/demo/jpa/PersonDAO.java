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
            System.out.println("Erreur lors de l'enregistrement: ");
           e.printStackTrace();
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

    public static List<Person> findAllV2(){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        Query query  = entityManager.createNativeQuery("SELECT * FROM persons", Person.class);
        return query.getResultList();
    }

    // avec le SELECT de JPQL on recupere une liste de String
    public static List<String> getNames(){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        // JPQL : sorte de requete SQL mais avec les classes Java
        Query query  = entityManager.createQuery("SELECT p.lastName FROM Person p");// SELECT * FROM persons;
        return query.getResultList();
    }

    // Pour créer une liste de Person partiellement remplis
    // SELECT new Person(p.firstName, p.lastName) FROM ...
    public static List<Person> findAllPersonsPartial() {
        List<Person> persons = null;
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        try {
            TypedQuery<Person> query = entityManager.createQuery("SELECT new Person(p.firstName, p.lastName) FROM Person p", Person.class);
            persons = query.getResultList();
        } catch (Exception e) {
            System.out.println("Erreur lors de la récupération des personnes");
        }

        return persons;
    }

    /* non terminé...
    // Pour créer une liste de Person partiellement remplis
    // SELECT new Person(p.firstName, p.lastName) FROM ...
    public static Object[] findAllPersonsStrings() {

        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        try {
            TypedQuery query = entityManager.createQuery("SELECT p.firstName, p.lastName FROM Person p", Object[].class);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Erreur lors de la récupération des personnes");
        }

        return null;
    }
     */


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

    public static void deleteById(Integer id){
        Person p = findById(id);
        delete(p);
    }

    public static void deleteByIdV2(Integer id){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            Query query  = entityManager.createQuery("DELETE FROM Person p WHERE p.id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            tx.commit();
        }catch (Exception e){
            System.out.println("Erreur lors de la modification");
            tx.rollback();
        }
    }


    public static void update(Person personToUpdate){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.merge(personToUpdate);
            tx.commit();
        }catch (Exception e){
            System.out.println("Erreur lors de la modification");
            tx.rollback();
        }
    }

    public static List<Person> findByLastName(String lastName){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Query query  = entityManager.createQuery("SELECT p FROM Person p WHERE p.lastName = :lastName");
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

}
