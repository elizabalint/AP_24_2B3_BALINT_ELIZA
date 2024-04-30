package org.example;


import org.example.models.Author;
import org.example.models.Book;
import org.example.models.Genre;
import org.example.models.PublishingHouse;
import org.example.repositories.AuthorRepository;
import org.example.repositories.BookRepository;
import org.example.repositories.GenreRepository;
import org.example.repositories.PublishingHouseRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

public class Main {
    // variabila pentru logger
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            // crearea unui file pentru a stoca infotmariile despre exceptions si execution time
            FileHandler fileHandler = new FileHandler("logfile.log");
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            // inceperea calcularii timpului din mom actual
            long currentTime = System.currentTimeMillis();
            // crearea a 10 elem pentru fiecare tabela
            for (int i = 1; i <= 10; i++) {
                PublishingHouse ph = new PublishingHouse();
                ph.setName("publishing house " + i);
                new PublishingHouseRepository().create(ph);

                Author author = new Author();
                author.setName("author" + i);
                new AuthorRepository().create(author);

                Genre genre = new Genre();
                genre.setName("genre" + i);
                new GenreRepository().create(genre);

                Book book = new Book();
                book.setTitle("book test" + i);
                book.setReleaseYear(i + 1000);
                book.setAuthor(author);
                List<Genre> genres = new ArrayList<>();
                genres.add(genre);
                book.setGenres(genres);

                book.setHouses(ph);
                new BookRepository().create(book);
            }
            // terminarea timpului si calcularea lui
            long time = System.currentTimeMillis() - currentTime;
            System.out.println("Took " + time + " milliseconds");
            // adaugarea in file a timpului in care s-au executat statements
            fileHandler.publish(new LogRecord(Level.INFO, "Execution time of JPQL statement: " + time + " ms"));
            System.out.println(new BookRepository().findByID(7).getAuthor().getName());
            List<Author> authors = new AuthorRepository().findByName("author2");
            for (Author author : authors) {
                System.out.println("author name: " + author.getName());
            }
            List<Genre> genres = new GenreRepository().findByName("genre6");
            for (Genre genre : genres) {
                System.out.println("genres: " + genre.getName());
            }
            List<PublishingHouse> publishingHouses = new PublishingHouseRepository().findByName("publishing house 6");
            for (PublishingHouse publishingHouse : publishingHouses) {
                System.out.println("Publishing house: " + publishingHouse.getName());
            }

        } catch (Exception e) {
            // scrierea in fisier a exceptiei
            logger.log(Level.SEVERE, "An exception occurred", e);
            System.out.println("Exception: " +e.getMessage());
        }
    }
}