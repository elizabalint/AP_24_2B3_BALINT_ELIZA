package org.example.repositories;

import jakarta.persistence.EntityManager;
import org.example.connection.Database;
import org.example.models.Genre;

import java.util.List;

public class GenreRepository {
    // creeaza un camp in tabela genres
    public void create(String name) {
        try(EntityManager em = Database.getEntityManagerFactory().createEntityManager()){
            em.getTransaction().begin();
            em.persist(name);
            em.getTransaction().commit();
        }
    }
    // gaseste un element dupa id ul specificat
    public Genre findByID(Long id) {
        try(EntityManager em = Database.getEntityManagerFactory().createEntityManager()){
            return em.find(Genre.class, id);
        }
    }
    // gaseste un obiect dupa numele specificat
    public List<Genre> findByName(String name) {
        try(EntityManager em = Database.getEntityManagerFactory().createEntityManager()){
            return em.createQuery("SELECT a FROM Genre a WHERE a.name LIKE :name", Genre.class)
                    .setParameter("name", name)
                    .getResultList();
        }
    }
}
