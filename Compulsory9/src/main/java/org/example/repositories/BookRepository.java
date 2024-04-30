package org.example.repositories;

import jakarta.persistence.EntityManager;
import org.example.connection.Database;
import org.example.models.Book;

import java.util.List;

public class BookRepository {
    // creeaza un camp in tabela books
    public void create(String name) {
        try(EntityManager em = Database.getEntityManagerFactory().createEntityManager()){
            em.getTransaction().begin();
            em.persist(name);
            em.getTransaction().commit();
        }
    }
    // gaseste un element dupa id ul specificat
    public Book findByID(Long id) {
        try(EntityManager em = Database.getEntityManagerFactory().createEntityManager()){
            return em.find(Book.class, id);
        }
    }
    // gaseste un obiect dupa numele specificat
    public List<Book> findByName(String name) {
        try(EntityManager em = Database.getEntityManagerFactory().createEntityManager()){
            return em.createQuery("SELECT a FROM Book a WHERE a.name LIKE :name", Book.class)
                    .setParameter("name", name)
                    .getResultList();
        }
    }
}
