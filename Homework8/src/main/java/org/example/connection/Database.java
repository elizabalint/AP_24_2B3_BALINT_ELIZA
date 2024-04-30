package org.example.connection;
import com.mchange.v2.c3p0.ComboPooledDataSource;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    // URL pt conexiunea la baza de date
    private static final String URL =
            "jdbc:postgresql://localhost:5432/book";
    // numele utilizatorului
    private static final String USER = "postgres";
    // parola utilizatorului
    private static final String PASSWORD = "postgres";
    // realizarea conexiunii folosind C3PO
    private static ComboPooledDataSource cpds;
    static {
        cpds = new ComboPooledDataSource();
        cpds.setJdbcUrl(URL);
        cpds.setUser(USER);
        cpds.setPassword(PASSWORD);
        cpds.setAcquireIncrement(100);
        cpds.setMaxPoolSize(100);

    }
    public static Connection getConn() throws SQLException {
        return cpds.getConnection();
    }

    // metoda pentru a sterge toate inregistrarile dintr-o anumita tabela
    public static void deleteAll(String tableName) throws SQLException {
        Connection con = Database.getConn();
        try (Statement stmt = con.createStatement()) {
            // stergem dintr-o tabela specificata
            String query = "DELETE FROM " + tableName;
            stmt.executeUpdate(query);
            // Resetam secventa asociata coloanei id din tabelul corespunzator
            resetSequenceForTable(tableName, con);
        }

    }

    private static void resetSequenceForTable(String tableName, Connection con) throws SQLException {
        if ("authors".equals(tableName)) {
            try (Statement stmt = con.createStatement()) {
                // comanda SQL pentru resetarea secventei asociate coloanei id din tabela authors
                stmt.execute("ALTER SEQUENCE authors_id_seq RESTART WITH 1");
            }
        } else if ("genres".equals(tableName)) {
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
    }


    }


}
