package br.com.trainee_tqi.modelo;

/**
 * <h2>Classe Modelo Cliente</h2>
 * Modelo de cliente da aplicação. Possui todos os atributos do cliente e ainda seus getters e setters.
 * 
 * @author Alexandre Vilarinho
 */
public class Cliente {
	
	/** Id do cliente*/
    Long id;
    /** Nome do cliente*/
    String nome;
    /** CPF do cliente*/
    String cpf;
    /** RG do cliente*/
    String rg;
    /** Telefone do cliente*/
    String telefone;
    /** E-mail do cliente*/
    String email;
    /** Senha do cliente*/
    String senha;
    /** Endereço do cliente*/
    String endereco;
    /** CEP do cliente*/
    String cep;
    /** Renda mensal do cliente*/
    float renda_mensal;
    
    /** Recebe o id*/
	public Long getId() {
		return id;
	}
	/**Define o id do cliente.
	 * 
	 * @param id	Id do cliente
	 * */
	public void setId(Long id) {
		this.id = id;
	}
	/** Recebe o nome do cliente.*/
	public String getNome() {
		return nome;
	}
	/**Define o nome do cliente.
	 * 
	 * @param nome	Nome do cliente.
	 * */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/** Recebe o CPF do cliente*/
	public String getCpf() {
		return cpf;
	}
	/**Define o CPF do cliente
	 * 
	 * @param cpf	CPF do cliente.
	 * 
	 * */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	/** Recebe o RG do cliente*/
	public String getRg() {
		return rg;
	}
	/**Define o RG do cliente.
	 * 
	 * @param rg	RG do cliente.
	 * */
	public void setRg(String rg) {
		this.rg = rg;
	}
	/** Recebe o telefone do cliente.*/
	public String getTelefone() {
		return telefone;
	}
	/**Define o telefone do cliente.
	 * 
	 * @param telefone	Telefone do cliente.
	 * */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	/** Recebe o e-mail do cliente.*/
	public String getEmail() {
		return email;
	}
	/**
	 * Define o e-mail do cliente.
	 * 
	 * @param email	E-mail do cliente.
	 * */
	public void setEmail(String email) {
		this.email = email;
	}
	/** Recebe o endereço do cliente*/
	public String getEndereco() {
		return endereco;
	}
	/**Define o endereço do cliente.
	 * 
	 * @param endereco	Endereço do cliente.
	 * */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	/** Recebe o CEP do cliente.*/
	public String getCep() {
		return cep;
	}
	/** Define o CEP do cliente
	 * 
	 * @param cep	CEP do cliente
	 * */
	public void setCep(String cep) {
		this.cep = cep;
	}
	/** Recebe a renda mensal do cliente.*/
	public float getRenda_mensal() {
		return renda_mensal;
	}
	/** Define a renda mensal do cliente
	 * 	
	 * @param renda_mensal	Renda mensal do cliente.
	 * */
	public void setRenda_mensal(float renda_mensal) {
		this.renda_mensal = renda_mensal;
	}
	/** Recebe a senha do cliente*/
	public String getSenha() {
		return senha;
	}
	/** Define a senha do cliente
	 * 
	 * @param senha	Senha do cliente.
	 * */
	public void setSenha(String senha) {
		this.senha = senha;
	}
    
    

}
