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
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class HomeGUI {

	private JFrame frmPginaInicial;

	/**
	 * Launch the application.
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
	 * Create the application.
	 */
	public HomeGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPginaInicial = new JFrame();
		frmPginaInicial.setTitle("P\u00E1gina Inicial");
		frmPginaInicial.setBounds(100, 100, 510, 350);
		frmPginaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblEmprstimosSa = new JLabel("Empr\u00E9stimos S/A");
		lblEmprstimosSa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmprstimosSa.setHorizontalAlignment(SwingConstants.CENTER);
		frmPginaInicial.getContentPane().add(lblEmprstimosSa, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		frmPginaInicial.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnCadastrese = new JButton("Cadastre-se");
		btnCadastrese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					ClienteGUI cliente = new ClienteGUI();
					cliente.main(null);
					frmPginaInicial.dispose();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnCadastrese.setBounds(131, 131, 110, 23);
		panel.add(btnCadastrese);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					LoginGUI login = new LoginGUI();
					login.main(null);
					frmPginaInicial.dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnLogin.setBounds(265, 131, 110, 23);
		panel.add(btnLogin);
	}
}
