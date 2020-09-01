package br.com.trainee_tqi.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**<h1>Classe PropostaGUI</h1><br>
 * Classe responsável por gerar a tela de propostas que o usuário recebeu.
 * 
 * @author Alexandre Vilarinho
 * */

public class PropostaGUI {
	/** Frame da tela de Propostas*/
	private JFrame frmConsultarPropostas;
	
	/** Campo de texto relativo ao valor final da proposta*/
	private JTextField txtValorFinal;
	/** Campo de texto relativo a quantidade de parcelas*/
	private JTextField txtQtdParcelas;
	/** Campo de texto relativo ao valor de cada parcela*/
	private JTextField txtValorParcelas;
	/** Campo de texto relativo ao status da proposta*/
	private JTextField txtStatus;
	
	/** Painel da janela*/
	private JPanel painel;
	/** Label das Propostas*/
	private JLabel lblPropostas;
	/** Label indicativo para o valor final*/
	private JLabel lblValorFinal;
	/** Label indicativo para a quantidade de parcelas*/
	private JLabel lblQuantidadeDeParcelas;
	/** Label indicativo para o valor das parcelas*/
	private JLabel lblValorParcelas;
	/** Label indicativo para o status da proposta*/
	private JLabel lblStatus;
	
	/** btnAceitar é o botão responsável que leva o usuário a aceitar a proposta*/
	private JButton btnAceitar;
	/** btnRecusar é o botão responsável que leva o usuário a recusar a proposta*/
	private JButton btnRecusar;
	/** Botão que permite que o usuário volte para a área do cliente*/
	private JButton btnVoltar;

	/**
	 * Roda a aplicação
	 * @param args args
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
	 * Construtor padrão, cria a aplicação juntamente com a função initialize.
	 */
	public PropostaGUI() {
		initialize();
	}

	/**
	 * <h1>Função initialize()</h1>
	 * Inicializa os componentes da aplicação.
	 */
	private void initialize() {
		frmConsultarPropostas = new JFrame();
		frmConsultarPropostas.setTitle("Consultar Propostas");
		frmConsultarPropostas.setBounds(100, 100, 550, 365);
		frmConsultarPropostas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblPropostas = new JLabel("Propostas");
		lblPropostas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPropostas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frmConsultarPropostas.getContentPane().add(lblPropostas, BorderLayout.NORTH);
		
		painel = new JPanel();
		frmConsultarPropostas.getContentPane().add(painel, BorderLayout.CENTER);
		painel.setLayout(null);
		
		txtValorFinal = new JTextField();
		txtValorFinal.setBounds(245, 43, 125, 20);
		txtValorFinal.setEditable(false);
		txtValorFinal.setText("4500,00");
		painel.add(txtValorFinal);
		txtValorFinal.setColumns(10);
		
		lblValorFinal = new JLabel("Valor Final:");
		lblValorFinal.setBounds(175, 46, 73, 14);
		painel.add(lblValorFinal);
		
		lblQuantidadeDeParcelas = new JLabel("Quantidade de Parcelas:");
		lblQuantidadeDeParcelas.setBounds(96, 87, 153, 14);
		painel.add(lblQuantidadeDeParcelas);
		
		txtQtdParcelas = new JTextField();
		txtQtdParcelas.setBounds(245, 84, 125, 20);
		txtQtdParcelas.setEditable(false);
		txtQtdParcelas.setText("3");
		painel.add(txtQtdParcelas);
		txtQtdParcelas.setColumns(10);
		
		lblValorParcelas = new JLabel("Valor das Parcelas:");
		lblValorParcelas.setBounds(124, 128, 124, 14);
		painel.add(lblValorParcelas);
		
		txtValorParcelas = new JTextField();
		txtValorParcelas.setBounds(245, 125, 125, 20);
		txtValorParcelas.setEditable(false);
		txtValorParcelas.setText("1500,00");
		painel.add(txtValorParcelas);
		txtValorParcelas.setColumns(10);
		
		lblStatus = new JLabel("Status:");
		lblStatus.setBounds(193, 170, 46, 14);
		painel.add(lblStatus);
		
		txtStatus = new JTextField();
		txtStatus.setBounds(245, 167, 125, 20);
		txtStatus.setEditable(false);
		txtStatus.setText("Aguardando");
		painel.add(txtStatus);
		txtStatus.setColumns(10);
		
		btnAceitar = new JButton("Aceitar");
		btnAceitar.addActionListener(new ActionListener() {
			/** Ao clicar no botão Aceitar, o status da proposta será alterado no banco de dados
			 * e a mesma não voltará a aparecer para o cliente.*/
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAceitar.setBounds(123, 245, 89, 23);
		painel.add(btnAceitar);
		
		btnRecusar = new JButton("Recusar");
		btnRecusar.addActionListener(new ActionListener() {
			/** Ao clicar no botão Recusar, o status da proposta será alterado no banco de dados
			 * e a mesma não voltará a aparecer para o cliente.*/
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRecusar.setBounds(222, 245, 89, 23);
		painel.add(btnRecusar);
		
		btnVoltar = new JButton("Voltar");
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
