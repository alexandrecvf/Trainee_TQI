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
 * Classe responsável por gerar a tela de solicitação de empréstimo.
 * 
 * @author Alexandre Vilarinho
 * */
public class EmprestimoGUI {
	/** Frame da tela Solicitar Empréstimo*/
	private JFrame frmSolicitarEmprstimo;
	/** Campo de texto relativo ao identificador do cliente*/
	private JTextField txtIdCliente;
	/** Campo de texto relativo à quantia de dinheiro que será solicitada*/
	private JTextField txtQuantia;
	/** Campo de texto relativo ao prazo máximo para pagamento do empréstimo*/
	private JTextField txtPrazo;
	/** Label do Solicitar Empréstimo*/
	private JLabel lblSolicitarEmprstimo;
	/** Painel da janela*/
	private JPanel painel;
	/** Label indicativo para o id do cliente*/
	private JLabel lblIdDoCliente;
	/** Label indicativo para a quantia a ser solicitada*/
	private JLabel lblQuantia;
	/** Label indicativo para o prazo máximo de pagamento*/
	private JLabel lblPrazoMximoem;
	/** Botão para solicitar o empréstimo*/
	private JButton btnSolicitar;
	/** Botão para sair da aplicaçãp*/
	private JButton btnSair;
	/** Botão para voltar para a área do cliente*/
	private JButton btnVoltar;

	/**
	 * Função main, responsável por fazer a aplicação rodar.
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
	 * Construtor padrão, cria a aplicação juntamente com a função initialize. 
	 */
	public EmprestimoGUI() {
		initialize();
	}

	/**
	 * <h1>Função initialize()</h1>
	 * Inicializa os componentes da aplicação.
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
			/** Ação do botão solicitar, responsável por pegar todos os atributos que foram passados pelo usuário
			 * e definir utilizando as funções "setters" do modelo emprestimo. Também verifica se existe algum campo vazio.
			 * Caso todos os campos estejam com informações, os dados que foram digitados são enviados para o DAO, onde 
			 * posteriormente serão salvos no BD. Após enviar os dados, os campos são limpos.
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
		            JOptionPane.showMessageDialog(null, "Empréstimo solicitado com sucesso! "); // Retorna uma mensagem avisando
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
			/** Ação de quando o botão "Sair" é clicado, o sistema é fechado*/
			public void actionPerformed(ActionEvent e) {
				// Fecha o programa
				System.exit(0);
			}
		});
		btnSair.setBounds(123, 224, 89, 23);
		painel.add(btnSair);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			/** Ação de quando o botão "Voltar" é clicado, o sistema volta para a tela área do cliente*/
			public void actionPerformed(ActionEvent e) {
				AreaClienteGUI.main(null);
				frmSolicitarEmprstimo.dispose();
			}
		});
		btnVoltar.setBounds(321, 224, 89, 23);
		painel.add(btnVoltar);
	}
}
