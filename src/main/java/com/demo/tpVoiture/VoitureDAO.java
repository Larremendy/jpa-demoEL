package com.demo.tpVoiture;

import com.demo.jpa.Address;
import com.demo.jpa.EntityManagerSingleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

public class VoitureDAO {

    private static EntityManager entityManager = EntityManagerSingleton.getEntityManager("tpvoiture");

    public static void save(Voiture a){

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
        return entityManager.find(Voiture.class, id);
    }

    public static List<Voiture> findAll(){

        // JPQL : sorte de requete SQL mais avec les classes Java
        Query query  = entityManager.createQuery("SELECT a FROM Voiture a");// SELECT * FROM persons;
        return query.getResultList();
    }


    public static void delete(Voiture a){
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
