package br.com.trainee_tqi.dao;

import br.com.trainee_tqi.factory.ConnectionFactory;
import br.com.trainee_tqi.modelo.Cliente;
import java.sql.*;
import java.sql.PreparedStatement;

/**
 * <h1>Classe ClienteDAO</h1> <br>
 * Responsável pela inserção de um cadastro do cliente no banco de dados
 * 
 * @author Alexandre Vilarinho
 * */
public class ClienteDAO {
	/** Variável do tipo Connection, responsável pela conexão com o BD*/
    private Connection connection;
    /** Long id, responsável pela identificação do usuário*/
    Long id;
    /** String nome é a variável que vai guardar o nome do cliente*/
    String nome;
    /** String CPF é responsável por guardar o CPF do cliente*/
    String cpf;
    /** String RG é responsável por guardar o RG do cliente*/
    String rg;
    /** String telefone responsável por guardar o telefone do cliente, é do tipo Sring pois existe uma máscara responsável por padronizar os telefones*/
    String telefone;
    /** String email é responsável por guardar o e-mail do cliente*/
    String email;
    /** String senha é responsável por guardar o senha do cliente*/
    String senha;
    /** String endereco é responsável por guardar o endereço do cliente*/
    String endereco;
    /** String CEP é responsável por guardar o CEP do cliente, também é uma string pois existe uma máscara para CEPs*/
    String cep;
    /** Float renda_mensal responsável por guardar a renda mensal do cliente*/
    float renda_mensal;
    
    /**
     * Construtor para conectar ao BD, utilizando a classe ConnectionFactory
     * */
    public ClienteDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    }
    
    /**
     * Função adicionar, responsável por pegar os valores inseridos pelo usuário
     * e inserir no banco de dados, por meio do comando INSERT INTO de SQL 
     * */
    public void adicionar(Cliente cliente){ 
        String sql = "INSERT INTO cliente(nome,cpf,rg,telefone,email,senha,endereco,cep,renda_mensal) VALUES(?,?,?,?,?,?,?,?,?)";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getRg());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getEmail());
            stmt.setString(6, cliente.getSenha());
            stmt.setString(7, cliente.getEndereco());
            stmt.setString(8, cliente.getCep());
            stmt.setFloat(9, cliente.getRenda_mensal());
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
    }
}