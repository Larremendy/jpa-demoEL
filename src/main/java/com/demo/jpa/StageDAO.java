package com.demo.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

public class StageDAO {
    private static EntityManager entityManager = EntityManagerSingleton.getEntityManager("demojpa");

    public static void save(Stage a){

       EntityTransaction tx = entityManager.getTransaction();
       try {
            tx.begin();
            entityManager.persist(a);
            tx.commit();
        }catch (Exception e){
            System.out.println("Erreur lors de l'enregistrement");
            tx.rollback();
        }
    }

    public static Stage findById(Integer id){

        return entityManager.find(Stage.class, id);
    }

    public static List<Stage> findAll(){

        // JPQL : sorte de requete SQL mais avec les classes Java
        Query query  = entityManager.createQuery("SELECT a FROM Stage a");// SELECT * FROM persons;
        return query.getResultList();
    }


    public static void delete(Stage a){

        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.remove(a);
            tx.commit();
        }catch (Exception e){
            System.out.println("Erreur lors de la suppression");
            tx.rollback();
        }
    }

    public static void deleteById(Integer id){
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            Query query  = entityManager.createQuery("DELETE FROM Stage a WHERE a.id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            tx.commit();
        }catch (Exception e){
            System.out.println("Erreur lors de la modification");
            tx.rollback();
        }
    }


    public static void update(Stage a){

        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.merge(a);
            tx.commit();
        }catch (Exception e){
            System.out.println("Erreur lors de la modification");
            tx.rollback();
        }
    }
}
