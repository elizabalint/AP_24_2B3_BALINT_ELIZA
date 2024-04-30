package org.example.repositories;

import jakarta.persistence.EntityManager;
import org.example.Database;
import org.example.models.Author;

import java.util.List;

public class AuthorRepository implements AbstractRepository<Author> {
    // cauta obiecte dupa id-ul specificat
    public Author findByID(int id) {
        try(EntityManager em = Database.getEntityManagerFactory().createEntityManager()){
            return em.find(Author.class, id);
        }
    }
    // cauta obiecte dupa numele specificat
    public List<Author> findByName(String name) {
        try(EntityManager em = Database.getEntityManagerFactory().createEntityManager()){
            return em.createQuery("SELECT a FROM Author a WHERE a.name LIKE :name", Author.class)
                    .setParameter("name", name)
                    .getResultList();
        }
    }
}
