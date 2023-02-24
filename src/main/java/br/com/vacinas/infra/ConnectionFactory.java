package br.com.vacinas.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private ConnectionFactory(){}

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost/VacinasDB", "postgres", "root");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
