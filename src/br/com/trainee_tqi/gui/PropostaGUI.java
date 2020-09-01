package br.com.trainee_tqi.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PropostaGUI {

	private JFrame frmConsultarPropostas;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PropostaGUI window = new PropostaGUI();
					window.frmConsultarPropostas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PropostaGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsultarPropostas = new JFrame();
		frmConsultarPropostas.setTitle("Consultar Propostas");
		frmConsultarPropostas.setBounds(100, 100, 550, 365);
		frmConsultarPropostas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblPropostas = new JLabel("Propostas");
		lblPropostas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPropostas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frmConsultarPropostas.getContentPane().add(lblPropostas, BorderLayout.NORTH);
		
		JPanel painel = new JPanel();
		frmConsultarPropostas.getContentPane().add(painel, BorderLayout.CENTER);
		painel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(245, 43, 125, 20);
		painel.add(textField);
		textField.setColumns(10);
		
		JLabel lblValorFinal = new JLabel("Valor Final:");
		lblValorFinal.setBounds(175, 46, 73, 14);
		painel.add(lblValorFinal);
		
		JLabel lblQuantidadeDeParcelas = new JLabel("Quantidade de Parcelas:");
		lblQuantidadeDeParcelas.setBounds(96, 87, 153, 14);
		painel.add(lblQuantidadeDeParcelas);
		
		textField_1 = new JTextField();
		textField_1.setBounds(245, 84, 125, 20);
		painel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblValorParcelas = new JLabel("Valor das Parcelas:");
		lblValorParcelas.setBounds(124, 128, 124, 14);
		painel.add(lblValorParcelas);
		
		textField_2 = new JTextField();
		textField_2.setBounds(245, 125, 125, 20);
		painel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(193, 170, 46, 14);
		painel.add(lblStatus);
		
		textField_3 = new JTextField();
		textField_3.setBounds(245, 167, 125, 20);
		painel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnAceitar = new JButton("Aceitar");
		btnAceitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAceitar.setBounds(123, 245, 89, 23);
		painel.add(btnAceitar);
		
		JButton btnRecusar = new JButton("Recusar");
		btnRecusar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRecusar.setBounds(222, 245, 89, 23);
		painel.add(btnRecusar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			/** Ação de quando o botão "Voltar" é clicado, o sistema volta para a tela área do cliente*/
			public void actionPerformed(ActionEvent arg0) {
				AreaClienteGUI.main(null);
				frmConsultarPropostas.dispose();
			}
		});
		btnVoltar.setBounds(321, 245, 89, 23);
		painel.add(btnVoltar);
	}
}
