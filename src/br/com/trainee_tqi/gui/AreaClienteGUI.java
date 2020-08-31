package br.com.trainee_tqi.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * <h2>Classe AreaClienteGUI</h2> <br>
 * A partir dessa tela, o cliente poder� solicitar um empr�stimo ou acompanhar as propostas recebidas.
 * 
 * @author Alexandre Vilarinho
 * */
public class AreaClienteGUI {

	private JFrame frame;

	/**
	 * Fun��o main, respons�vel por rodar a aplica��o.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AreaClienteGUI window = new AreaClienteGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Construtor padr�o, respons�vel por criar os componentes da janela.
	 * Dentro do construtor, a fun��o initialize � chamada.
	 */
	public AreaClienteGUI() {
		initialize();
	}

	/**
	 * Inicializa o conte�do do frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
