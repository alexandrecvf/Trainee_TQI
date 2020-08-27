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

public class ClienteGUI {

	private JFrame frame;
	private JTextField textField_nome;
	private JTextField textField_rg;
	private JTextField textField_email;
	private JTextField textField_endereco;
	private JTextField textField_renda;
	private JPasswordField passwordField;
	private MaskFormatter ftmTelefone;
	private MaskFormatter ftmCpf;
	private MaskFormatter ftmCep;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteGUI window = new ClienteGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws ParseException 
	 */
	public ClienteGUI() throws ParseException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ParseException 
	 */
	private void initialize() throws ParseException {
		// Criando as máscaras para os campos telefone, cpf e cep
		ftmTelefone = new MaskFormatter("(##)#####-####");
		ftmCpf = new MaskFormatter("###.###.###-##");
		ftmCep = new MaskFormatter("#####-###");
		
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 370);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblCadastroCliente = new JLabel("Cadastro Cliente");
		lblCadastroCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(lblCadastroCliente, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 25, 46, 14);
		panel_1.add(lblNome);
		
		textField_nome = new JTextField();
		textField_nome.setBounds(59, 22, 465, 20);
		panel_1.add(textField_nome);
		textField_nome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 63, 31, 14);
		panel_1.add(lblCpf);
		
		JFormattedTextField formattedTextField_cpf = new JFormattedTextField(ftmCpf);
		formattedTextField_cpf.setBounds(59, 60, 225, 20);
		ftmCpf.setValidCharacters("0123456789");
		panel_1.add(formattedTextField_cpf);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(301, 63, 36, 14);
		panel_1.add(lblRg);
		
		textField_rg = new JTextField();
		textField_rg.setBounds(347, 60, 177, 20);
		panel_1.add(textField_rg);
		textField_rg.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 101, 39, 14);
		panel_1.add(lblEmail);
		
		textField_email = new JTextField();
		textField_email.setBounds(59, 98, 225, 20);
		panel_1.add(textField_email);
		textField_email.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telef.:");
		lblTelefone.setBounds(10, 141, 46, 14);
		panel_1.add(lblTelefone);
		
		JFormattedTextField formattedTextField_telefone = new JFormattedTextField(ftmTelefone);
		formattedTextField_telefone.setBounds(59, 138, 225, 20);
		ftmTelefone.setValidCharacters("0123456789");
		panel_1.add(formattedTextField_telefone);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(301, 101, 46, 14);
		panel_1.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(347, 98, 177, 20);
		panel_1.add(passwordField);
		
		JLabel lblEnd = new JLabel("End.:");
		lblEnd.setBounds(10, 183, 46, 14);
		panel_1.add(lblEnd);
		
		textField_endereco = new JTextField();
		textField_endereco.setBounds(59, 180, 225, 20);
		panel_1.add(textField_endereco);
		textField_endereco.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(301, 183, 46, 14);
		panel_1.add(lblCep);
		
		JFormattedTextField formattedTextField_cep = new JFormattedTextField(ftmCep);
		formattedTextField_cep.setBounds(347, 180, 177, 20);
		ftmCep.setValidCharacters("0123456789");
		panel_1.add(formattedTextField_cep);
		
		JLabel lblRenda = new JLabel("Renda:");
		lblRenda.setBounds(301, 141, 46, 14);
		panel_1.add(lblRenda);
		
		textField_renda = new JTextField();
		textField_renda.setBounds(347, 138, 177, 20);
		panel_1.add(textField_renda);
		textField_renda.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// instanciando a classe Cliente do pacote modelo e criando seu objeto clientes
		        Cliente clientes = new Cliente();
		        clientes.setNome(textField_nome.getText());
		        clientes.setCpf(formattedTextField_cpf.getText());
		        clientes.setRg(textField_rg.getText());
		        clientes.setTelefone(formattedTextField_telefone.getText());
		        clientes.setEmail(textField_email.getText());
		        clientes.setSenha(passwordField.getText());
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
		            dao.adiciona(clientes);
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
		panel_1.add(btnSalvar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSair.setBounds(326, 241, 89, 23);
		panel_1.add(btnSair);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(226, 241, 89, 23);
		panel_1.add(btnVoltar);
	}
}
