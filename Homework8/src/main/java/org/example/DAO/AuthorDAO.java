package org.example.DAO;
import org.example.connection.Database;

import java.sql.*;

public class AuthorDAO {
    // creare autor in tabela authors
    public void create(String name) throws SQLException {
        Connection con = Database.getConn();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into authors (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
        con.setAutoCommit(false);
    }
    // gasire autor dupa nume
    public static Integer findByName(String name) throws SQLException {
        Connection con = Database.getConn();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from authors where name='" + name + "'")) {
            con.setAutoCommit(false);
            return rs.next() ? rs.getInt(1) : null;
        }
    }
    // gasire autor dupa id
    public static String findById(int id) throws SQLException {
        Connection con = Database.getConn();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from authors where id='" + id + "'")) {
            con.setAutoCommit(false);
            return rs.next() ? rs.getString(1) : null;
        }
    }

}
