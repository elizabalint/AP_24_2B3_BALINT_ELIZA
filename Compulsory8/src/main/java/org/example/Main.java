package org.example;

import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String args[]) {
        try {
            // sterg tabelele
            Database.deleteAll("books");
            Database.deleteAll("authors");

            // crearea a 2 autori in baza de date
            var authors = new AuthorDAO();
            authors.create("William Shakespeare");
            authors.create("Douglas Adams");

            Database.getConnection().commit();
            // afiseaza id autorului cu numele "William Shakespeare" din baza de date
            System.out.println( "Id pentru William Shakespeare: "+ authors.findByName("William Shakespeare"));

            // inchiderea conexiunii
            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);

        }
    }

}