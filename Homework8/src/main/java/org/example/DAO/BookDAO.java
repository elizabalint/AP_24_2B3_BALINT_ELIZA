package org.example.DAO;

import org.example.connection.Database;
import org.example.models.Author;
import org.example.models.Book;
import org.example.models.Genre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    // creare carte in tabela books
    public void create(Integer release_year, String name, String author, String genre) throws SQLException {
        Connection con = Database.getConn();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into books (release_year, title, author_id, genre_id) values (?,?,?,?)")) {
            pstmt.setInt(1, release_year);
            pstmt.setString(2, name);
            Integer authorId = AuthorDAO.findByName(author);
            // daca autor nu exista
            if (authorId == null) {
                System.out.println("Author not found: " + author);
                return;
            }
            Integer genreId = new GenreDAO().findByName(genre);
            // daca genre nu exista
            if (genreId == null) {
                System.out.println("Genre not found: " + genre);
                return;
            }
            pstmt.setInt(3, authorId);
            pstmt.setInt(4, genreId);
            pstmt.executeUpdate();
        }
        con.setAutoCommit(false);
    }
    // selectarea tuturor carstilor din baza de date
    public static List<Book> findAll() throws SQLException {
        // initializarea unei liste de carti goala
        List<Book> books= new ArrayList<>();
        try (Connection connection = Database.getConn();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM books")){
             // seteaza informatii despre carte
             while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setRelease_year(rs.getInt("release_year"));
                book.setTitle(rs.getString("title"));
                // seteaza autor
                String authorName = AuthorDAO.findById(rs.getInt("author_id"));
                Author author = new Author();
                author.setId(rs.getInt("author_id"));
                author.setName(authorName);
                book.setAuthor(author);
                // seteaza genul
                String genreName = GenreDAO.findById(rs.getInt("genre_id"));
                Genre genre = new Genre();
                genre.setId(rs.getInt("genre_id"));
                genre.setName(genreName);
                book.setGenre(genre);
                books.add(book);
            }
        }
        return books;
    }
}


