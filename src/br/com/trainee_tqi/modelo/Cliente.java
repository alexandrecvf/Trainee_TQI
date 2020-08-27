package br.com.trainee_tqi.modelo;

/**
 *
 * @author Alexandre de Cassio Vilarinho Filho
 */
public class Cliente {

    Long id;
    String nome;
    String cpf;
    String rg;
    String telefone;
    String email;
    String endereco;
    String cep;
    float renda_mensal;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public float getRenda_mensal() {
		return renda_mensal;
	}
	public void setRenda_mensal(float renda_mensal) {
		this.renda_mensal = renda_mensal;
	}
    
    

}
