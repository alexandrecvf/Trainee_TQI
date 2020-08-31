package br.com.trainee_tqi.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**<h2>ConnectionFactory</h2> <br>
 * Como � subentendido pelo nome, � simplesmente uma f�brica de conex�es,
 * ou seja, sua �nica fun��o � fazer a conex�o com o banco de dados, permitindo a manipula��o de dados.
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
