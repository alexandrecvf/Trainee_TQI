package br.com.trainee_tqi.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * <h2>Classe AreaClienteGUI</h2> <br>
 * A partir dessa tela, o cliente poderá solicitar um empréstimo ou acompanhar as propostas recebidas.
 * 
 * @author Alexandre Vilarinho
 * */
public class AreaClienteGUI {

	private JFrame frame;

	/**
	 * Função main, responsável por rodar a aplicação.
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
	 * Construtor padrão, responsável por criar os componentes da janela.
	 * Dentro do construtor, a função initialize é chamada.
	 */
	public AreaClienteGUI() {
		initialize();
	}

	/**
	 * Inicializa o conteúdo do frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
