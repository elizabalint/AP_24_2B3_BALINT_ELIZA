package org.example;
import java.sql.*;

public class Database {
    // URL pt conexiunea la baza de date
    private static final String URL =
            "jdbc:postgresql://localhost:5432/book";
    // numele utilizatorului
    private static final String USER = "postgres";
    // parola utilizatorului
    private static final String PASSWORD = "postgres";
    // variabila pt realizarea conexiunii
    private static Connection connection = null;
    // constructor default
    private Database() {}
    // metoda pentru obtinerea conexiunii
    public static Connection getConnection() {
        if (connection == null) {
            createConnection();
        }
        return connection;
    }
    // metoda pentru crearea conexiunii
    private static void createConnection() {
        try {
            // obtinem conexiunea folosind DriverManager
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            // initializam baza de date
            DatabaseUtils.initDatabase(connection);
            // setam autoComit false pt a controla tranzactiile manual
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    // metoda pentru inchiderea conexiunii
    public static void closeConnection() {
        if(connection != null) {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    }
    // metoda pentru a sterge toate inregistrarile dintr-o anumita tabela
    public static void deleteAll(String tableName) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement()) {
            // stergem dintr-o tabela specificata
            String query = "DELETE FROM " + tableName;
            stmt.executeUpdate(query);
            con.commit();

            // resetam secventa asociata coloanei id din tabelul corespunzator
            resetSequenceForTable(tableName, con);
        }
    }

    private static void resetSequenceForTable(String tableName, Connection con) throws SQLException {
        if ("authors".equals(tableName)) {
            try (Statement stmt = con.createStatement()) {
                // comanda SQL pentru resetarea secventei asociate coloanei id din tabela authors
                stmt.execute("ALTER SEQUENCE authors_id_seq RESTART WITH 1");
            }
        }else if ("genres".equals(tableName)) {
            try (Statement stmt = con.createStatement()) {
                // comanda SQL pentru resetarea secventei asociate coloanei id din tabela genres
                stmt.execute("ALTER SEQUENCE genres_id_seq RESTART WITH 1");
            }
        }
        else if ("books".equals(tableName)) {
            try (Statement stmt = con.createStatement()) {
                // comanda SQL pentru resetarea secventei asociate coloanei id din tabela books
                stmt.execute("ALTER SEQUENCE books_id_seq RESTART WITH 1");
            }
    }}


}
