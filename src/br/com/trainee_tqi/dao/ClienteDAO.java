package br.com.trainee_tqi.dao;

import br.com.trainee_tqi.factory.ConnectionFactory;
import br.com.trainee_tqi.modelo.Cliente;
import java.sql.*;

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
    /** Comando SQL que vai inserir no banco de dados um novo cliente*/
    String sql;
    PreparedStatement stmt;
    
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
        sql = "INSERT INTO cliente(nome,cpf,rg,telefone,email,senha,endereco,cep,renda_mensal) VALUES(?,?,?,?,?,?,?,?,?)";
        try { 
            stmt = connection.prepareStatement(sql);
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
    
    /**
	 * Função checarLogin é quem de fato faz a verificação dos dados passados pelo usuário e compara com o banco de dados.
	 * Primeiramente é feita a conexão com o banco de dados, depois, é preparado o termo de pesquisa, utilizando o comando SELECT
	 * do SQL. Será selecionado no BD o e-mail e a senha confiram com o passado pelo usuário. Caso encontre algo no banco de dados
	 * que confira, a função retorna true.
	 * 
	 * @param email	Recebe o e-mail digitado pelo usuário
	 * @param senha Recebe a senha digitada pelo usuário
	 * 
	 * @return true ou false, indicando se encontrou ou não um registro semelhante no banco de dados
	 * */
    public boolean checarLogin(String email, String senha){
	    sql = "SELECT * FROM cliente WHERE email = ? and senha = ?";
	    stmt = null;
	    ResultSet rs = null;
	    boolean check = false;

	    if(!email.isEmpty() && !senha.isEmpty()) {
	        try {
	            stmt = connection.prepareStatement(sql);
	            stmt.setString(1, email);
	            stmt.setString(2, senha);
	            rs = stmt.executeQuery();

	            if (rs.next()){
	              check = true;
	            }

	        } catch (SQLException ex) {
	        	throw new RuntimeException(ex);
	        }
	    }
	    try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
    }
}