package br.com.trainee_tqi.dao;

import br.com.trainee_tqi.factory.ConnectionFactory;
import br.com.trainee_tqi.modelo.Cliente;
import java.sql.*;
import java.sql.PreparedStatement;

/**
 * <h1>Classe ClienteDAO</h1> <br>
 * Respons�vel pela inser��o de um cadastro do cliente no banco de dados
 * 
 * @author Alexandre Vilarinho
 * */
public class ClienteDAO {
	/** Vari�vel do tipo Connection, respons�vel pela conex�o com o BD*/
    private Connection connection;
    /** Long id, respons�vel pela identifica��o do usu�rio*/
    Long id;
    /** String nome � a vari�vel que vai guardar o nome do cliente*/
    String nome;
    /** String CPF � respons�vel por guardar o CPF do cliente*/
    String cpf;
    /** String RG � respons�vel por guardar o RG do cliente*/
    String rg;
    /** String telefone respons�vel por guardar o telefone do cliente, � do tipo Sring pois existe uma m�scara respons�vel por padronizar os telefones*/
    String telefone;
    /** String email � respons�vel por guardar o e-mail do cliente*/
    String email;
    /** String senha � respons�vel por guardar o senha do cliente*/
    String senha;
    /** String endereco � respons�vel por guardar o endere�o do cliente*/
    String endereco;
    /** String CEP � respons�vel por guardar o CEP do cliente, tamb�m � uma string pois existe uma m�scara para CEPs*/
    String cep;
    /** Float renda_mensal respons�vel por guardar a renda mensal do cliente*/
    float renda_mensal;
    
    /**
     * Construtor para conectar ao BD, utilizando a classe ConnectionFactory
     * */
    public ClienteDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    }
    
    /**
     * Fun��o adicionar, respons�vel por pegar os valores inseridos pelo usu�rio
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