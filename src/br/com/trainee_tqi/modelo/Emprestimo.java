package br.com.trainee_tqi.modelo;

/**
 * <h1>Classe Modelo Empr�stimo</h1>
 * Modelo de empr�stimo da aplica��o. Possui todos os atributos de um empr�stimo e ainda seus getters e setters.
 * 
 * @author Alexandre Vilarinho
 */
public class Emprestimo {
	/** Id do empr�stimo*/
    Long id;
    /** Id do cliente que solicitou empr�stimo*/
    Long id_cliente;
    /** Quantia solicitada pelo cliente*/
    float quantia_solicitada;
    /** Prazo m�ximo (em meses) para o pagamento do empr�stimo*/
    int prazo;
    
    /** Recebe o id do empr�stimo
     * @return id Id do empr�stimo
     * */
	public Long getId() {
		return id;
	}
	/** Define o id do empr�stimo
	 * @param id Id do empr�stimo
	 * */
	public void setId(Long id) {
		this.id = id;
	}
	/** Recebe o id do cliente que solicitou o empr�stimo
     * @return id_cliente Id do cliente
     * */
	public Long getId_cliente() {
		return id_cliente;
	}
	/** Define o id do cliente que solicitou o empr�stimo
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
	/** Recebe o prazo m�ximo que o empr�stimo ser� pago
     * @return prazo prazo do empr�stimo
     * */
	public int getPrazo() {
		return prazo;
	}
	/** Define o prazo m�ximo que o empr�stimo ser� pago
	 * @param prazo prazo do empr�stimo
	 * */
	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}
    
    

}
