package org.example.DAO;

import org.example.connection.Database;

import java.sql.*;

public class GenreDAO {
    // creare gen in tabela genre
    public void create(String name) throws SQLException {
        Connection con = Database.getConn();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into genres (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
        con.setAutoCommit(false);
    }
    // gasire gen dupa "nume"
    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConn();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from genres where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }
    // gasire gen dupa id
    public static String findById(int id) throws SQLException {
        Connection con = Database.getConn();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from genres where id='" + id + "'")) {
            con.setAutoCommit(false);
            return rs.next() ? rs.getString(1) : null;
        }
    }
}
