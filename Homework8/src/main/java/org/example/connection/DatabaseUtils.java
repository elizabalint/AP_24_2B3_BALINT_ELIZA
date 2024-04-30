package org.example.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtils {
    // creare tabele in baza de date
    public static void initDatabase(Connection conn) throws SQLException {
        conn.setAutoCommit(false);

        Statement stmt = conn.createStatement();
        stmt.execute(
                "CREATE TABLE IF NOT EXISTS authors (" +
                        "id SERIAL PRIMARY KEY, " +
                        "name VARCHAR(50) NOT NULL " +
                        ")"
        );
        stmt.execute(
                "CREATE TABLE IF NOT EXISTS genres (" +
                        "id SERIAL PRIMARY KEY, " +
                        "name VARCHAR(50) NOT NULL " +
                        ")"
        );
        stmt.execute(
                "CREATE TABLE IF NOT EXISTS books (" +
                        "id SERIAL PRIMARY KEY, " +
                        "release_year INT NOT NULL, " +
                        "title VARCHAR(50) NOT NULL, " +
                        "author_id INT NOT NULL, " +
                        "genre_id INT NOT NULL, " +
                        "FOREIGN KEY (author_id) REFERENCES authors(id), " +
                        "FOREIGN KEY (genre_id) REFERENCES genres(id) " +
                        ")"
        );



    }
}
