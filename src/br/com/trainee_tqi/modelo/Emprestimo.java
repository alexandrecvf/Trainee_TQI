package br.com.trainee_tqi.modelo;

/**
 * <h1>Classe Modelo Empréstimo</h1>
 * Modelo de empréstimo da aplicação. Possui todos os atributos de um empréstimo e ainda seus getters e setters.
 * 
 * @author Alexandre Vilarinho
 */
public class Emprestimo {
	/** Id do empréstimo*/
    Long id;
    /** Id do cliente que solicitou empréstimo*/
    Long id_cliente;
    /** Quantia solicitada pelo cliente*/
    float quantia_solicitada;
    /** Prazo máximo (em meses) para o pagamento do empréstimo*/
    int prazo;
    
    /** Recebe o id do empréstimo
     * @return id Id do empréstimo
     * */
	public Long getId() {
		return id;
	}
	/** Define o id do empréstimo
	 * @param id Id do empréstimo
	 * */
	public void setId(Long id) {
		this.id = id;
	}
	/** Recebe o id do cliente que solicitou o empréstimo
     * @return id_cliente Id do cliente
     * */
	public Long getId_cliente() {
		return id_cliente;
	}
	/** Define o id do cliente que solicitou o empréstimo
	 * @param id_cliente id do cliente
	 * */
	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}
	/** Recebe a quantia que foi solicitada pelo cliente
     * @return quantia_solicitada Quantia solicitada
     * */
	public float getQuantia_solicitada() {
		return quantia_solicitada;
	}
	/** Define a quantia que foi solicitada pelo cliente
	 * @param quantia_solicitada Quantia solicitada
	 * */
	public void setQuantia_solicitada(float quantia_solicitada) {
		this.quantia_solicitada = quantia_solicitada;
	}
	/** Recebe o prazo máximo que o empréstimo será pago
     * @return prazo prazo do empréstimo
     * */
	public int getPrazo() {
		return prazo;
	}
	/** Define o prazo máximo que o empréstimo será pago
	 * @param prazo prazo do empréstimo
	 * */
	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}
    
    

}
