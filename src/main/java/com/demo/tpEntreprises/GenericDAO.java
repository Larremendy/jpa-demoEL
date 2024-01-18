package com.demo.tpEntreprises;

import com.demo.jpa.EntityManagerSingleton;
import jakarta.persistence.*;

import java.util.List;

public class GenericDAO<T> {
    private Class<T> entityClass;

    private EntityManager entityManager = EntityManagerSingleton.getEntityManager("demojpa");
    private EntityTransaction tx = entityManager.getTransaction();

    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void save(T entity) {
        tx.begin();
        entityManager.persist(entity);
        tx.commit();
    }

    public T findById(Integer id) {
        return entityManager.find(entityClass, id);
    }

    public void update(T entityToUpdate) {
        tx.begin();
        entityManager.merge(entityToUpdate);
        tx.commit();
    }

    public void delete(T entityToDelete) {
        tx.begin();
        entityManager.remove(entityToDelete);
        tx.commit();
    }

    public List<T> findAll() {
        TypedQuery<T> query = entityManager.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass);
        return query.getResultList();
    }
}