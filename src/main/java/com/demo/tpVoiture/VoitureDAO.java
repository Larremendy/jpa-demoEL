package com.demo.tpVoiture;

import com.demo.jpa.Address;
import com.demo.jpa.EntityManagerSingleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

public class VoitureDAO {

    public static void save(Voiture a){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

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

    public static Voiture findById(Integer id){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        return entityManager.find(Voiture.class, id);
    }

    public static List<Voiture> findAll(){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        // JPQL : sorte de requete SQL mais avec les classes Java
        Query query  = entityManager.createQuery("SELECT a FROM Voiture a");// SELECT * FROM persons;
        return query.getResultList();
    }


    public static void delete(Voiture a){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
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
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            Query query  = entityManager.createQuery("DELETE FROM Voiture a WHERE a.id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            tx.commit();
        }catch (Exception e){
            System.out.println("Erreur lors de la modification");
            tx.rollback();
        }
    }


    public static void update(Voiture a){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
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
