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
 * Classe responsável por gerar a tela de cadastramento de um cliente.
 * 
 * @author Alexandre Vilarinho
 * */
public class ClienteGUI extends JFrame{

	/** Serial Version */
	private static final long serialVersionUID = 1L;
	/** Frame da tela Cadastro Cliente*/
	private JFrame frmCadastroCliente;
	/** Campo de texto relativo ao nome do usuário*/
	private JTextField textField_nome;
	/** Campo de texto relativo ao RG do usuário*/
	private JTextField textField_rg;
	/** Campo de texto relativo ao e-mail do usuário*/
	private JTextField textField_email;
	/** Campo de texto relativo ao endereço do usuário*/
	private JTextField textField_endereco;
	/** Campo de texto relativo à renda mensal do usuário*/
	private JTextField textField_renda;
	/** Campo de texto relativo à senha do usuário*/
	private JPasswordField passwordField;
	
	/** Máscara de texto para o telefone, resposável para que o telefone fique no formato (XX)XXXXX-XXXX*/
	private MaskFormatter ftmTelefone;
	/** Máscara de texto para o CPF, responsável para que o CPF fique no formato XXX.XXX.XXX-XX*/
	private MaskFormatter ftmCpf;
	/** Máscara de texto para o CEP, responsável para que o CEP fique no formato XXXXX-XXX*/
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
	
	// O JFormattedTextField permite a utiliazação de máscaras, auxiliando a padronização do CPF, telefone e CEP
	/** formattedTextField_cpf responsável por pegar o CPF do usuário com uma máscara*/
	private JFormattedTextField formattedTextField_cpf;
	/** formattedTextField_cpf responsável por pegar o telefone do usuário com uma máscara*/
	private JFormattedTextField formattedTextField_telefone;
	/** formattedTextField_cpf responsável por pegar o CEP do usuário com uma máscara*/
	private JFormattedTextField formattedTextField_cep;

	/**
	 * Função main, responsável por fazer a aplicação rodar.
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
	 * Construtor padrão, cria a aplicação juntamente com a função initialize.
	 * @throws ParseException 
	 */
	public ClienteGUI() throws ParseException {
		initialize();
	}

	/**
	 * <h1>Função initialize()</h1>
	 * Inicializa os componentes da aplicação.
	 * @throws ParseException 
	 */
	private void initialize() throws ParseException {
		// Criando as máscaras para os campos telefone, cpf e cep
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
		
		// Botão salvar, que após verificar os campos, manda para o cliente dao
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			/** Ação do botão salvar, responsável por pegar todos os atributos que foram passados pelo usuário
			 * e definir utilizando as funções "setters" do modelo cliente. Também verifica se existe algum campo vazio.
			 * Caso todos os campos estejam com informações, os dados que foram digitados são enviados para o DAO, onde 
			 * posteriormente serão salvos no BD. Após enviar os dados, os campos são limpos.
			 * */
			public void actionPerformed(ActionEvent e) {
				// Instanciando a classe Cliente do pacote modelo e criando seu objeto clientes
		        Cliente clientes = new Cliente();
		        clientes.setNome(textField_nome.getText());
		        clientes.setCpf(formattedTextField_cpf.getText());
		        clientes.setRg(textField_rg.getText());
		        clientes.setTelefone(formattedTextField_telefone.getText());
		        clientes.setEmail(textField_email.getText());
		        clientes.setSenha((passwordField.getText()).trim()); // O trim tira os espaços no início e final da senha
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
		
		// Botão que permite que o usuário feche o sistema
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			/** Ação de quando o botão "Sair" é clicado, o sistema é fechado*/
			public void actionPerformed(ActionEvent arg0) {
				// Fecha o programa
				System.exit(0);
			}
		});
		btnSair.setBounds(326, 241, 89, 23);
		painel2.add(btnSair);
		
		// Botão para voltar para a tela inicial do sistema
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			/** Ação de quando o botão "Voltar" é clicado, o sistema volta para a tela inicial da aplicação*/
			public void actionPerformed(ActionEvent e) {
				HomeGUI.main(null);
				frmCadastroCliente.dispose();
			}
		});
		btnVoltar.setBounds(226, 241, 89, 23);
		painel2.add(btnVoltar);
	}
}
