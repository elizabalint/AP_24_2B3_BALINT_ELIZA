package org.example;

import org.example.DAO.AuthorDAO;
import org.example.DAO.BookDAO;
import org.example.DAO.GenreDAO;
import org.example.connection.Database;
import org.example.connection.DatabaseUtils;
import org.example.models.Author;
import org.example.models.Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String args[]) {
        Connection connection = null;
        try {
            connection = Database.getConn();
            connection.setAutoCommit(false);
            DatabaseUtils.initDatabase(connection);
            // sterg tabelele
            Database.deleteAll("books");
            Database.deleteAll("authors");
            Database.deleteAll("genres");
            // crearea a 2 autori in baza de date
            var authors = new AuthorDAO();
            authors.create("William Shakespeare");
            authors.create("Douglas Adams");
            connection.commit();

            // afiseaza id autorului cu numele "William Shakespeare" din baza de date
            System.out.println(authors.findByName("William Shakespeare"));
            // crearea a 2 genuri in baza de date
            var genres = new GenreDAO();
            genres.create("Tragedy");
            genres.create("Science fiction, Comedy, Adventure");
            connection.commit();
            // crearea a 2 carti in baza de date
            var books = new BookDAO();
            books.create(1597,"Romeo and Juliet","William Shakespeare","Tragedy");
            books.create(1979,"The Hitchhiker's Guide to the Galaxy",
                    "Douglas Adams", "Science fiction, Comedy, Adventure");
            connection.commit();
            // afisarea tuturor cartilor din baza de date
            System.out.println("Books from database:");
            for(Book bookss : Collections.unmodifiableList(BookDAO.findAll()))
                System.out.println(bookss.getId() + "\t" + bookss.getRelease_year() + "\t" + bookss.getTitle() + "\t" + bookss.getAuthor().getName() + "\t" + bookss.getGenre().getName());
            System.out.println('\n');

            // carti din dataset
            System.out.println("Books from dataset:");
            String line = "";
            String delimiter = ",";
            try {
                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\eliza\\Desktop\\Facultate\\An3\\Sem 2\\PA\\Laborator\\Homework8\\books.csv"));
                br.readLine();
                while ((line = br.readLine()) != null) {
                    String[] bookData = line.split(delimiter);
                    Integer id = Integer.valueOf(bookData[0]);
                    String title = bookData[1];
                    String authorName = bookData[2];
                    Author author = new Author();
                    author.setName(authorName);
                    String publicationDate = bookData[10];
                    String[] parts = publicationDate.split("/");
                    int release_year = Integer.parseInt(parts[2]);
                    Book book = new Book(id, release_year, title, author);
                    book.setAuthor(author);
                    System.out.println(book.getId() + "\t" + book.getRelease_year() + "\t" + book.getTitle() + "\t" + book.getAuthor().getName());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}