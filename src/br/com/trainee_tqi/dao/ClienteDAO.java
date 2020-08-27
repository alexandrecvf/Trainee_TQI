package br.com.trainee_tqi.dao;

import br.com.trainee_tqi.factory.ConnectionFactory;
import br.com.trainee_tqi.modelo.Cliente;
import java.sql.*;
import java.sql.PreparedStatement;

public class ClienteDAO { 
    private Connection connection;
    Long id;
    String nome;
    String cpf;
    String rg;
    String telefone;
    String email;
    String endereco;
    String cep;
    float renda_mensal;
    
    public ClienteDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    } 
    public void adiciona(Cliente cliente){ 
        String sql = "INSERT INTO cliente(nome,cpf,rg,telefone,email,endereco,cep,renda_mensal) VALUES(?,?,?,?,?,?,?,?)";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getRg());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getEmail());
            stmt.setString(6, cliente.getEndereco());
            stmt.setString(7, cliente.getCep());
            stmt.setFloat(8, cliente.getRenda_mensal());
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    } 
    
}