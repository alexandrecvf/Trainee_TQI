package br.com.trainee_tqi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.trainee_tqi.factory.ConnectionFactory;
import br.com.trainee_tqi.modelo.Emprestimo;

/**
 * <h1>Classe EmprestimoDAO</h1> <br>
 * Responsável pela inserção de um emprestimo no banco de dados
 * 
 * @author Alexandre Vilarinho
 * */
public class EmprestimoDAO {
	/** Variável do tipo Connection, responsável pela conexão com o BD*/
	private Connection connection;
	/** Id do empréstimo*/
    Long id;
    /** Id do cliente que solicitou empréstimo*/
    Long id_cliente;
    /** Quantia solicitada pelo cliente*/
    float quantia_solicitada;
    /** Prazo máximo (em meses) para o pagamento do empréstimo*/
    int prazo;
    /** Comando SQL que vai inserir o pedido de empréstimo no BD*/
    String sql;
    /** Sentença que ajuda a inserção de dados no BD*/
    PreparedStatement stmt;
	
	/**
     * Construtor para conectar ao BD, utilizando a classe ConnectionFactory
     * */
    public EmprestimoDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    }
    
    /**
     * Função adicionar, responsável por pegar os valores inseridos pelo usuário
     * e inserir no banco de dados, por meio do comando INSERT INTO de SQL
     * @param emprestimo Objeto do tipo emprestimo
     * */
    public void adicionar(Emprestimo emprestimo){ 
        sql = "INSERT INTO emprestimo(id_cliente,quantia_solicitada,prazo) VALUES(?,?,?)";
        try { 
            stmt = connection.prepareStatement(sql);
            stmt.setFloat(1, emprestimo.getId_cliente());
            stmt.setFloat(2, emprestimo.getQuantia_solicitada());
            stmt.setInt(3, emprestimo.getPrazo());
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
    }
}
