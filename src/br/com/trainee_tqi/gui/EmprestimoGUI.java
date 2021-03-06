package br.com.trainee_tqi.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import br.com.trainee_tqi.dao.EmprestimoDAO;
import br.com.trainee_tqi.modelo.Emprestimo;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**<h1>Classe EmprestimoGUI</h1><br>
 * Classe respons�vel por gerar a tela de solicita��o de empr�stimo.
 * 
 * @author Alexandre Vilarinho
 * */
public class EmprestimoGUI {
	/** Frame da tela Solicitar Empr�stimo*/
	private JFrame frmSolicitarEmprstimo;
	/** Campo de texto relativo ao identificador do cliente*/
	private JTextField txtIdCliente;
	/** Campo de texto relativo � quantia de dinheiro que ser� solicitada*/
	private JTextField txtQuantia;
	/** Campo de texto relativo ao prazo m�ximo para pagamento do empr�stimo*/
	private JTextField txtPrazo;
	/** Label do Solicitar Empr�stimo*/
	private JLabel lblSolicitarEmprstimo;
	/** Painel da janela*/
	private JPanel painel;
	/** Label indicativo para o id do cliente*/
	private JLabel lblIdDoCliente;
	/** Label indicativo para a quantia a ser solicitada*/
	private JLabel lblQuantia;
	/** Label indicativo para o prazo m�ximo de pagamento*/
	private JLabel lblPrazoMximoem;
	/** Bot�o para solicitar o empr�stimo*/
	private JButton btnSolicitar;
	/** Bot�o para sair da aplica��p*/
	private JButton btnSair;
	/** Bot�o para voltar para a �rea do cliente*/
	private JButton btnVoltar;

	/**
	 * Fun��o main, respons�vel por fazer a aplica��o rodar.
	 * @param args args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmprestimoGUI window = new EmprestimoGUI();
					window.frmSolicitarEmprstimo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Construtor padr�o, cria a aplica��o juntamente com a fun��o initialize. 
	 */
	public EmprestimoGUI() {
		initialize();
	}

	/**
	 * <h1>Fun��o initialize()</h1>
	 * Inicializa os componentes da aplica��o.
	 */
	private void initialize() {
		frmSolicitarEmprstimo = new JFrame();
		frmSolicitarEmprstimo.setTitle("Solicitar Empr\u00E9stimo");
		frmSolicitarEmprstimo.setBounds(100, 100, 550, 365);
		frmSolicitarEmprstimo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblSolicitarEmprstimo = new JLabel("Solicitar Empr\u00E9stimo");
		lblSolicitarEmprstimo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolicitarEmprstimo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frmSolicitarEmprstimo.getContentPane().add(lblSolicitarEmprstimo, BorderLayout.NORTH);
		
		painel = new JPanel();
		frmSolicitarEmprstimo.getContentPane().add(painel, BorderLayout.CENTER);
		painel.setLayout(null);
		
		lblIdDoCliente = new JLabel("ID do cliente:");
		lblIdDoCliente.setBounds(176, 56, 73, 14);
		painel.add(lblIdDoCliente);
		
		txtIdCliente = new JTextField();
		txtIdCliente.setBounds(259, 53, 130, 20);
		painel.add(txtIdCliente);
		txtIdCliente.setColumns(10);
		
		lblQuantia = new JLabel("Quantia:");
		lblQuantia.setBounds(200, 98, 49, 14);
		painel.add(lblQuantia);
		
		txtQuantia = new JTextField();
		txtQuantia.setBounds(259, 95, 130, 20);
		painel.add(txtQuantia);
		txtQuantia.setColumns(10);
		
		lblPrazoMximoem = new JLabel("Prazo m\u00E1ximo (em meses):");
		lblPrazoMximoem.setBounds(91, 136, 158, 14);
		painel.add(lblPrazoMximoem);
		
		txtPrazo = new JTextField();
		txtPrazo.setBounds(259, 133, 130, 20);
		painel.add(txtPrazo);
		txtPrazo.setColumns(10);
		
		btnSolicitar = new JButton("Solicitar");
		btnSolicitar.addActionListener(new ActionListener() {
			/** A��o do bot�o solicitar, respons�vel por pegar todos os atributos que foram passados pelo usu�rio
			 * e definir utilizando as fun��es "setters" do modelo emprestimo. Tamb�m verifica se existe algum campo vazio.
			 * Caso todos os campos estejam com informa��es, os dados que foram digitados s�o enviados para o DAO, onde 
			 * posteriormente ser�o salvos no BD. Ap�s enviar os dados, os campos s�o limpos.
			 * */
			public void actionPerformed(ActionEvent arg0) {
				// Instanciando a classe Cliente do pacote modelo e criando seu objeto clientes
		        Emprestimo emprestimos = new Emprestimo();
		        emprestimos.setId_cliente(Long.parseLong(txtIdCliente.getText()));
		        emprestimos.setQuantia_solicitada(Float.parseFloat(txtQuantia.getText()));
		        emprestimos.setPrazo(Integer.parseInt(txtPrazo.getText()));

		        // Verifica se tem algum campo do formulario em branco
		        if ((txtIdCliente.getText().isEmpty()) || (txtQuantia.getText().isEmpty()) || (txtPrazo.getText().isEmpty())) {
		           JOptionPane.showMessageDialog(null, "Os campos nao podem retornar vazios");
		        }
		        else {
		            // Instanciando a classe EmprestimoDAO do pacote dao e criando seu objeto dao
		            EmprestimoDAO dao = new EmprestimoDAO();
		            dao.adicionar(emprestimos);
		            JOptionPane.showMessageDialog(null, "Empr�stimo solicitado com sucesso! "); // Retorna uma mensagem avisando
		        }

		        // Apaga os dados preenchidos de todos os campos do formulario
		        txtIdCliente.setText("");
		        txtQuantia.setText("");
		        txtPrazo.setText("");
			}
		});
		btnSolicitar.setBounds(222, 224, 89, 23);
		painel.add(btnSolicitar);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			/** A��o de quando o bot�o "Sair" � clicado, o sistema � fechado*/
			public void actionPerformed(ActionEvent e) {
				// Fecha o programa
				System.exit(0);
			}
		});
		btnSair.setBounds(123, 224, 89, 23);
		painel.add(btnSair);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			/** A��o de quando o bot�o "Voltar" � clicado, o sistema volta para a tela �rea do cliente*/
			public void actionPerformed(ActionEvent e) {
				AreaClienteGUI.main(null);
				frmSolicitarEmprstimo.dispose();
			}
		});
		btnVoltar.setBounds(321, 224, 89, 23);
		painel.add(btnVoltar);
	}
}
