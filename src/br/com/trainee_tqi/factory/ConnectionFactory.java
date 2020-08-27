package br.com.trainee_tqi.factory;

/**
 *
 * @author Alexandre de Cássio Vilarinho Filho
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/trainee_tqi", "root", "");
        } catch (SQLException excecao) {
            throw new RuntimeException(excecao);
        }
    }
}
