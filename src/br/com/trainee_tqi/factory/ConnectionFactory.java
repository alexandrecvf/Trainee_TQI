package br.com.trainee_tqi.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**<h1>ConnectionFactory</h1> <br>
 * Como é subentendido pelo nome, é simplesmente uma fábrica de conexões,
 * ou seja, sua única função é fazer a conexão com o banco de dados, permitindo a manipulação de dados.
 * 
 * @author Alexandre Vilarinho
 */
public class ConnectionFactory {

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/trainee_tqi", "root", "");
        } catch (SQLException excecao) {
            throw new RuntimeException(excecao);
        }
    }
}
