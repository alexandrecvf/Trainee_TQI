package br.com.trainee_tqi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.trainee_tqi.factory.ConnectionFactory;
import br.com.trainee_tqi.modelo.Emprestimo;

/**
 * <h1>Classe EmprestimoDAO</h1> <br>
 * Respons�vel pela inser��o de um emprestimo no banco de dados
 * 
 * @author Alexandre Vilarinho
 * */
public class EmprestimoDAO {
	/** Vari�vel do tipo Connection, respons�vel pela conex�o com o BD*/
	private Connection connection;
	/** Id do empr�stimo*/
    Long id;
    /** Id do cliente que solicitou empr�stimo*/
    Long id_cliente;
    /** Quantia solicitada pelo cliente*/
    float quantia_solicitada;
    /** Prazo m�ximo (em meses) para o pagamento do empr�stimo*/
    int prazo;
    /** Comando SQL que vai inserir o pedido de empr�stimo no BD*/
    String sql;
    /** Senten�a que ajuda a inser��o de dados no BD*/
    PreparedStatement stmt;
	
	/**
     * Construtor para conectar ao BD, utilizando a classe ConnectionFactory
     * */
    public EmprestimoDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    }
    
    /**
     * Fun��o adicionar, respons�vel por pegar os valores inseridos pelo usu�rio
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
