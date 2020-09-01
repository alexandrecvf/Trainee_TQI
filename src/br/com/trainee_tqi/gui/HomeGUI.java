package br.com.trainee_tqi.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * <h1>HomeGUI</h1><br>
 * P�gina principal da aplica��o, a partir dela, o usu�rio consegue navegar pelas outras janelas.
 * 
 * @author Alexandre Vilarinho
 * */
public class HomeGUI {
	/** Frame respons�vel pela janela*/
	private JFrame frmPginaInicial;
	/** Label respons�vel por escrever "Empr�stimos S/A" na janela*/
	private JLabel lblEmprestimosSa;
	/** Painel onde os bot�es s�o colocados*/
	private JPanel painel;
	/** Bot�o respons�vel por redirecionar o usu�rio para a tela de cadastro*/
	private JButton btnCadastrese;
	/** Bot�o respons�vel por redirecionar o usu�rio para a tela de login*/
	private JButton btnLogin;

	/**
	 * Classe principal, respons�vel por rodar a p�gina inicial, gerada automaticamento pelo WindowBuilder
	 * @param args args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeGUI window = new HomeGUI();
					window.frmPginaInicial.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Construtor padr�o
	 */
	public HomeGUI() {
		initialize();
	}

	/**
	 * A fun��o initialize � respons�vel por inicializar o conte�do do frame.
	 */
	private void initialize() {
		frmPginaInicial = new JFrame();
		frmPginaInicial.setTitle("P\u00E1gina Inicial");
		frmPginaInicial.setBounds(100, 100, 510, 350);
		frmPginaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblEmprestimosSa = new JLabel("Empr\u00E9stimos S/A");
		lblEmprestimosSa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmprestimosSa.setHorizontalAlignment(SwingConstants.CENTER);
		frmPginaInicial.getContentPane().add(lblEmprestimosSa, BorderLayout.NORTH);
		
		painel = new JPanel();
		frmPginaInicial.getContentPane().add(painel, BorderLayout.CENTER);
		painel.setLayout(null);
		
		btnCadastrese = new JButton("Cadastre-se");
		btnCadastrese.addActionListener(new ActionListener() {
			/**
			 * Ao clicar no bot�o Cadastre-se, o cliente � redirecionado para a tela de cadastro do usu�rio.
			 * 
			 * @param arg0	� a a��o de clicar no bot�o.
			 * */
			public void actionPerformed(ActionEvent arg0) {
				ClienteGUI.main(null);
				frmPginaInicial.dispose();
			}
		});
		btnCadastrese.setBounds(131, 131, 110, 23);
		painel.add(btnCadastrese);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			/**
			 * Ao clicar no bot�o Login, o cliente � redirecionado para a tela de login do usu�rio.
			 * 
			 * @param e	� a a��o de clicar no bot�o.
			 * */
			public void actionPerformed(ActionEvent e) {
				LoginGUI.main(null);
				frmPginaInicial.dispose();
			}
		});
		btnLogin.setBounds(265, 131, 110, 23);
		painel.add(btnLogin);
	}
}
