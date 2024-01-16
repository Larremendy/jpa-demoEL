package com.demo.jpa;

import jakarta.persistence.*;

public class EntityManagerSingleton {

    private static EntityManager entityManager;

    public static EntityManager getEntityManager() {

        if (entityManager == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa");
            entityManager = emf.createEntityManager();
            //emf.close(); // <----- NON sinon on ne peut plus utiliser le EntityManager
        }

        return entityManager;
    }
}