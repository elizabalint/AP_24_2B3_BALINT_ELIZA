package org.example.models;

import java.util.Objects;
import jakarta.persistence.*;
@Entity
@Table(name = "books")
@NamedQueries({
        @NamedQuery(name = "Book.findAll",
                query = "select e from Book e order by e.title"),
        @NamedQuery(name = "Book.findByAuthor",
                query = "select e from Book e where e.author = ?1")
        })
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    private int id;
    private int release_year;
    private String title;
    @JoinColumn(name = "author_id")
    private Author author;
    @JoinColumn(name = "genre_id")

    private Genre genre;

    public Book() {
    }

    public Book(int id, int release_year, String title, Author author, Genre genre) {
        this.id = id;
        this.release_year = release_year;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public Book(int id, int release_year, String title, Author author) {
        this.id = id;
        this.release_year = release_year;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return getId() == book.getId() && getRelease_year() == book.getRelease_year() && Objects.equals(getTitle(), book.getTitle()) && Objects.equals(getAuthor(), book.getAuthor()) && Objects.equals(getGenre(), book.getGenre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRelease_year(), getTitle(), getAuthor(), getGenre());
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", release_year=" + release_year +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
