package com.demo.jpa;

import jakarta.persistence.*;

public class EntityManagerSingleton {

    private static EntityManager entityManager;

    public static EntityManager getEntityManager(String dataSourceName) {

        if (entityManager == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(dataSourceName);
            entityManager = emf.createEntityManager();
            //emf.close(); // <----- NON sinon on ne peut plus utiliser le EntityManager
        }

        return entityManager;
    }
}