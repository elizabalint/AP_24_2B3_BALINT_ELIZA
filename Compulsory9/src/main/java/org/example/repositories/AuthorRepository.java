package org.example.repositories;

import jakarta.persistence.EntityManager;
import org.example.connection.Database;
import org.example.models.Author;

import java.util.List;

public class AuthorRepository {
    // creeaza un camp in tabela authors
    public void create(String name) {
        try(EntityManager em = Database.getEntityManagerFactory().createEntityManager()){
            em.getTransaction().begin();
            em.persist(name);
            em.getTransaction().commit();
        }
    }
    // gaseste un element dupa id ul specificat
    public Author findByID(int id) {
        System.out.println("here");
        try(EntityManager em = Database.getEntityManagerFactory().createEntityManager()){
            return em.find(Author.class, id);
        }
    }
    // gaseste un obiect dupa numele specificat
    public List<Author> findByName(String name) {
        try(EntityManager em = Database.getEntityManagerFactory().createEntityManager()){
            return em.createQuery("SELECT a FROM Author a WHERE a.name LIKE :name", Author.class)
                    .setParameter("name", name)
                    .getResultList();

        }
    }
}
