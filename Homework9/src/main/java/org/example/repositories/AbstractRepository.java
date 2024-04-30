package org.example.repositories;

import jakarta.persistence.EntityManager;
import org.example.Database;

import java.util.List;

public interface AbstractRepository<T> {
    // creeaz  camputi in baza de date
    default void create(T u) {
        try (EntityManager em = Database.getEntityManagerFactory().createEntityManager()) {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        }
    }
    T findByID(int id);
    List<T> findByName(String name);
}
