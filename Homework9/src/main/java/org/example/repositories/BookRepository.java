package org.example.repositories;

import jakarta.persistence.EntityManager;
import org.example.Database;
import org.example.models.Book;

import java.util.List;

public class BookRepository implements AbstractRepository<Book> {
    // cauta ob dupa id-ul specificat
    public Book findByID(int id) {
        try(EntityManager em = Database.getEntityManagerFactory().createEntityManager()){
            return em.find(Book.class, id);
        }
    }
    // cauta obiecte dupa numele specificat
    public List<Book> findByName(String name) {
        try(EntityManager em = Database.getEntityManagerFactory().createEntityManager()){
            return em.createQuery("SELECT a FROM Book a WHERE a.name LIKE :name", Book.class)
                    .setParameter("name", name)
                    .getResultList();
        }
    }
}
