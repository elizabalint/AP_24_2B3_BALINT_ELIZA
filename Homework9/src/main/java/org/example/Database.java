package org.example;

import jakarta.persistence.EntityManagerFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class Database {
    private static EntityManagerFactory emf;
    public static EntityManagerFactory getEntityManagerFactory() {
        if(emf == null) {
            emf = jakarta.persistence.Persistence.createEntityManagerFactory("ExamplePU");
        }
        return emf;
    }
    private Database() {}
}
