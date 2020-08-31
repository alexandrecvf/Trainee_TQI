package br.com.trainee_tqi.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Font;
import java.text.ParseException;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;
import br.com.trainee_tqi.dao.ClienteDAO;
import br.com.trainee_tqi.modelo.Cliente;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**<h1>Classe ClienteGUI</h1><br>
 * Classe respons�vel por gerar a tela de cadastramento de um cliente.
 * 
 * @author Alexandre Vilarinho
 * */
public class ClienteGUI extends JFrame{

	/** Serial Version */
	private static final long serialVersionUID = 1L;
	/** Frame da tela Cadastro Cliente*/
	private JFrame frmCadastroCliente;
	/** Campo de texto relativo ao nome do usu�rio*/
	private JTextField textField_nome;
	/** Campo de texto relativo ao RG do usu�rio*/
	private JTextField textField_rg;
	/** Campo de texto relativo ao e-mail do usu�rio*/
	private JTextField textField_email;
	/** Campo de texto relativo ao endere�o do usu�rio*/
	private JTextField textField_endereco;
	/** Campo de texto relativo � renda mensal do usu�rio*/
	private JTextField textField_renda;
	/** Campo de texto relativo � senha do usu�rio*/
	private JPasswordField passwordField;
	
	/** M�scara de texto para o telefone, respos�vel para que o telefone fique no formato (XX)XXXXX-XXXX*/
	private MaskFormatter ftmTelefone;
	/** M�scara de texto para o CPF, respons�vel para que o CPF fique no formato XXX.XXX.XXX-XX*/
	private MaskFormatter ftmCpf;
	/** M�scara de texto para o CEP, respons�vel para que o CEP fique no formato XXXXX-XXX*/
	private MaskFormatter ftmCep;
	
	/** Painel 1 da janela*/
	private JPanel painel;
	/** Painel 2 da janela*/
	private JPanel painel2;
	
	/** Label do Cadastro Cliente*/
	private JLabel lblCadastroCliente;
	/** Label indicativo para o nome*/
	private JLabel lblNome;
	/** Label indicativo para o cpf*/
	private JLabel lblCpf;
	/** Label indicativo para o RG*/
	private JLabel lblRg;
	/** Label indicativo para o e-mail*/
	private JLabel lblEmail;
	/** Label indicativo para o telefone*/
	private JLabel lblTelefone;
	/** Label indicativo para a senha*/
	private JLabel lblSenha;
	/** Label indicativo para o endereco*/
	private JLabel lblEndereco;
	/** Label indicativo para o CEP*/
	private JLabel lblCep;
	/** Label indicativo para a renda mensal*/
	private JLabel lblRenda;
	
	// O JFormattedTextField permite a utiliaza��o de m�scaras, auxiliando a padroniza��o do CPF, telefone e CEP
	/** formattedTextField_cpf respons�vel por pegar o CPF do usu�rio com uma m�scara*/
	private JFormattedTextField formattedTextField_cpf;
	/** formattedTextField_cpf respons�vel por pegar o telefone do usu�rio com uma m�scara*/
	private JFormattedTextField formattedTextField_telefone;
	/** formattedTextField_cpf respons�vel por pegar o CEP do usu�rio com uma m�scara*/
	private JFormattedTextField formattedTextField_cep;

	/**
	 * Fun��o main, respons�vel por fazer a aplica��o rodar.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteGUI window = new ClienteGUI();
					window.frmCadastroCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Construtor padr�o, cria a aplica��o juntamente com a fun��o initialize.
	 * @throws ParseException 
	 */
	public ClienteGUI() throws ParseException {
		initialize();
	}

	/**
	 * <h1>Fun��o initialize()</h1>
	 * Inicializa os componentes da aplica��o.
	 * @throws ParseException 
	 */
	private void initialize() throws ParseException {
		// Criando as m�scaras para os campos telefone, cpf e cep
		ftmTelefone = new MaskFormatter("(##)#####-####");
		ftmCpf = new MaskFormatter("###.###.###-##");
		ftmCep = new MaskFormatter("#####-###");
		
		frmCadastroCliente = new JFrame();
		frmCadastroCliente.setTitle("Cadastro Cliente");
		frmCadastroCliente.setBounds(100, 100, 550, 365);
		frmCadastroCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblCadastroCliente = new JLabel("Cadastro Cliente");
		lblCadastroCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frmCadastroCliente.getContentPane().add(lblCadastroCliente, BorderLayout.NORTH);
		
		painel = new JPanel();
		frmCadastroCliente.getContentPane().add(painel, BorderLayout.CENTER);
		painel.setLayout(new BorderLayout(0, 0));
		
		painel2 = new JPanel();
		painel.add(painel2, BorderLayout.CENTER);
		painel2.setLayout(null);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 25, 46, 14);
		painel2.add(lblNome);
		
		textField_nome = new JTextField();
		textField_nome.setBounds(59, 22, 465, 20);
		painel2.add(textField_nome);
		textField_nome.setColumns(10);
		
		lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 63, 31, 14);
		painel2.add(lblCpf);
		
		formattedTextField_cpf = new JFormattedTextField(ftmCpf);
		formattedTextField_cpf.setBounds(59, 60, 225, 20);
		ftmCpf.setValidCharacters("0123456789");
		painel2.add(formattedTextField_cpf);
		
		lblRg = new JLabel("RG:");
		lblRg.setBounds(301, 63, 36, 14);
		painel2.add(lblRg);
		
		textField_rg = new JTextField();
		textField_rg.setBounds(347, 60, 177, 20);
		painel2.add(textField_rg);
		textField_rg.setColumns(10);
		
		lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 101, 39, 14);
		painel2.add(lblEmail);
		
		textField_email = new JTextField();
		textField_email.setBounds(59, 98, 225, 20);
		painel2.add(textField_email);
		textField_email.setColumns(10);
		
		lblTelefone = new JLabel("Telef.:");
		lblTelefone.setBounds(10, 141, 46, 14);
		painel2.add(lblTelefone);
		
		formattedTextField_telefone = new JFormattedTextField(ftmTelefone);
		formattedTextField_telefone.setBounds(59, 138, 225, 20);
		ftmTelefone.setValidCharacters("0123456789");
		painel2.add(formattedTextField_telefone);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(301, 101, 46, 14);
		painel2.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(347, 98, 177, 20);
		painel2.add(passwordField);
		
		lblEndereco = new JLabel("End.:");
		lblEndereco.setBounds(10, 183, 46, 14);
		painel2.add(lblEndereco);
		
		textField_endereco = new JTextField();
		textField_endereco.setBounds(59, 180, 225, 20);
		painel2.add(textField_endereco);
		textField_endereco.setColumns(10);
		
		lblCep = new JLabel("CEP:");
		lblCep.setBounds(301, 183, 46, 14);
		painel2.add(lblCep);
		
		formattedTextField_cep = new JFormattedTextField(ftmCep);
		formattedTextField_cep.setBounds(347, 180, 177, 20);
		ftmCep.setValidCharacters("0123456789");
		painel2.add(formattedTextField_cep);
		
		lblRenda = new JLabel("Renda:");
		lblRenda.setBounds(301, 141, 46, 14);
		painel2.add(lblRenda);
		
		textField_renda = new JTextField();
		textField_renda.setBounds(347, 138, 177, 20);
		painel2.add(textField_renda);
		textField_renda.setColumns(10);
		
		// Bot�o salvar, que ap�s verificar os campos, manda para o cliente dao
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			/** A��o do bot�o salvar, respons�vel por pegar todos os atributos que foram passados pelo usu�rio
			 * e definir utilizando as fun��es "setters" do modelo cliente. Tamb�m verifica se existe algum campo vazio.
			 * Caso todos os campos estejam com informa��es, os dados que foram digitados s�o enviados para o DAO, onde 
			 * posteriormente ser�o salvos no BD. Ap�s enviar os dados, os campos s�o limpos.
			 * */
			public void actionPerformed(ActionEvent e) {
				// Instanciando a classe Cliente do pacote modelo e criando seu objeto clientes
		        Cliente clientes = new Cliente();
		        clientes.setNome(textField_nome.getText());
		        clientes.setCpf(formattedTextField_cpf.getText());
		        clientes.setRg(textField_rg.getText());
		        clientes.setTelefone(formattedTextField_telefone.getText());
		        clientes.setEmail(textField_email.getText());
		        clientes.setSenha((passwordField.getText()).trim()); // O trim tira os espa�os no in�cio e final da senha
		        clientes.setEndereco(textField_endereco.getText());
		        clientes.setCep(formattedTextField_cep.getText());
		        clientes.setRenda_mensal(Float.parseFloat(textField_renda.getText()));

		        // Verifica se tem algum campo do formulario em branco
		        if ((textField_nome.getText().isEmpty()) || (formattedTextField_cpf.getText().isEmpty()) || (textField_rg.getText().isEmpty()) || (formattedTextField_telefone.getText().isEmpty())
		                || (textField_email.getText().isEmpty()) || (passwordField.getText().isEmpty()) || (textField_endereco.getText().isEmpty()) || (formattedTextField_cep.getText().isEmpty())
		                || (textField_renda.getText().isEmpty())) {
		           JOptionPane.showMessageDialog(null, "Os campos nao podem retornar vazios");
		        }
		        else {
		            // Instanciando a classe ClienteDAO do pacote dao e criando seu objeto dao
		            ClienteDAO dao = new ClienteDAO();
		            dao.adicionar(clientes);
		            JOptionPane.showMessageDialog(null, "Cliente "+textField_nome.getText()+" inserido com sucesso! "); // Retorna uma mensagem avisando
		        }

		        // Apaga os dados preenchidos de todos os campos do formulario
		        textField_nome.setText("");
		        formattedTextField_cpf.setText("");
		        textField_rg.setText("");
		        formattedTextField_telefone.setText("");
		        textField_email.setText("");
		        passwordField.setText("");
		        textField_endereco.setText("");
		        formattedTextField_cep.setText("");
		        textField_renda.setText("");
			}
		});
		btnSalvar.setBounds(127, 241, 89, 23);
		painel2.add(btnSalvar);
		
		// Bot�o que permite que o usu�rio feche o sistema
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			/** A��o de quando o bot�o "Sair" � clicado, o sistema � fechado*/
			public void actionPerformed(ActionEvent arg0) {
				// Fecha o programa
				System.exit(0);
			}
		});
		btnSair.setBounds(326, 241, 89, 23);
		painel2.add(btnSair);
		
		// Bot�o para voltar para a tela inicial do sistema
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			/** A��o de quando o bot�o "Voltar" � clicado, o sistema volta para a tela inicial da aplica��o*/
			public void actionPerformed(ActionEvent e) {
				HomeGUI.main(null);
				frmCadastroCliente.dispose();
			}
		});
		btnVoltar.setBounds(226, 241, 89, 23);
		painel2.add(btnVoltar);
	}
}
