package br.com.trainee_tqi.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * <h1>Classe AreaClienteGUI</h1> <br>
 * A partir dessa tela, o cliente poder� solicitar um empr�stimo ou acompanhar as propostas recebidas.
 * 
 * @author Alexandre Vilarinho
 * */
public class AreaClienteGUI {

	private JFrame frmreaDoCliente;
	private JLabel lblreaDoCliente;
	private JPanel panel;
	private JButton btnSolicitarEmprestimo;
	private JButton btnAcompanharPropostas;

	/**
	 * Fun��o main, respons�vel por rodar a aplica��o.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AreaClienteGUI window = new AreaClienteGUI();
					window.frmreaDoCliente.setVisible(true);
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
		frmreaDoCliente = new JFrame();
		frmreaDoCliente.setTitle("\u00C1rea do Cliente");
		frmreaDoCliente.setBounds(100, 100, 550, 365);
		frmreaDoCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblreaDoCliente = new JLabel("\u00C1rea do Cliente");
		lblreaDoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblreaDoCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frmreaDoCliente.getContentPane().add(lblreaDoCliente, BorderLayout.NORTH);
		
		panel = new JPanel();
		frmreaDoCliente.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnSolicitarEmprestimo = new JButton("Solicitar Empr\u00E9stimo");
		btnSolicitarEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmprestimoGUI.main(null);
				frmreaDoCliente.dispose();
			}
		});
		btnSolicitarEmprestimo.setBounds(53, 125, 200, 50);
		panel.add(btnSolicitarEmprestimo);
		
		btnAcompanharPropostas = new JButton("Acompanhar Propostas");
		btnAcompanharPropostas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PropostaGUI.main(null);
				frmreaDoCliente.dispose();
			}
		});
		btnAcompanharPropostas.setBounds(285, 125, 200, 50);
		panel.add(btnAcompanharPropostas);
	}

}
