package br.com.trainee_tqi.factory;

/**
 *
 * @author Alexandre de Cássio Vilarinho Filho
 */
import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {

    public static void main(String[] args) throws SQLException {
        Connection connection = new ConnectionFactory().getConnection();
        System.out.println("Conexão aberta!");
        connection.close();
    }
}
