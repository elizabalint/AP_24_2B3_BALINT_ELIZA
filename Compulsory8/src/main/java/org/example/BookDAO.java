package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDAO {
    // creare carte in tabela books
    public void create(Integer release_year, String name, String author, String genre) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into books (release_year, name, artist, genre) values (?)")) {
            // setare parametri
            pstmt.setInt(1, release_year);
            pstmt.setString(2, name);
            Integer authorId = new AuthorDAO().findByName(author);
            Integer genreId = new GenreDAO().findByName(genre);
            pstmt.setInt(3, authorId);
            pstmt.setInt(4, genreId);

            pstmt.executeUpdate();
        }
    }
}
