package br.com.trainee_tqi.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import br.com.trainee_tqi.dao.ClienteDAO;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * <h1>Classe LoginGUI</h1><br>
 * Respons�vel por realizar o login do usu�rio. Utilizando as credenciais que foram passadas nessa tela e as
 * comparando com as informa��es salvas no banco de dados.
 * 
 * @author Alexandre Vilarinho
 * */
public class LoginGUI extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** Jframe respons�vel pela janela da tela de login*/
	private JFrame frmLogin;
	/** txtUsuario � o campo que ir� receber o email do cliente*/
	private JTextField txtUsuario;
	/** campoSenha � o campo que receber� a senha do cadastro do cliente*/
	private JPasswordField campoSenha;
	/** Label que tamb�m � o t�tulo da janela*/
	private JLabel lblLogin;
	/** painel � onde os componentes da janela ser�o colocados*/
	private JPanel painel;
	/** lblEmail � o label respons�vel por indicar o campo de e-mail*/
	private JLabel lblEmail;
	/** lblSenha � o label respons�vel por indicar o campo de senha*/
	private JLabel lblSenha;
	/** btnEntrar � o bot�o respons�vel que leva o usu�rio para verifica��o de e-mail e senha e em seguida, redireciona para a �rea do cliente*/
	private JButton btnEntrar;
	/** btnCadastrarse � o respons�vel de redirecionar os usu�rios para a tela de cadastro*/
	private JButton btnCadastrarse;

	/**
	 * Fun��o main, respons�vel por rodar a aplica��o
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI window = new LoginGUI();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Construtor respons�vel por chamar a fun��o initialize.
	 */
	public LoginGUI() {
		initialize();
	}

	/**
	 * Inicialize o conte�do do frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 500, 355);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frmLogin.getContentPane().add(lblLogin, BorderLayout.NORTH);
		
		painel = new JPanel();
		frmLogin.getContentPane().add(painel, BorderLayout.CENTER);
		painel.setLayout(null);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(102, 85, 46, 14);
		painel.add(lblEmail);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(162, 82, 200, 20);
		painel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(102, 129, 46, 14);
		painel.add(lblSenha);
		
		campoSenha = new JPasswordField();
		campoSenha.setBounds(162, 126, 200, 20);
		painel.add(campoSenha);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			/**
			 * Fun��o de a��o do bot�o entrar, ou seja, quando o bot�o "Entrar" � clicado, essa fun��o � acionada.
			 * Nesse m�todo, os valores digitados nos campos e-mail e senha s�o comparados com os valores inseridos previamento no BD.
			 * Caso exista um e-mail e senha correspondente no banco de dados, o usu�rio � redirecionado para a �rea do Cliente, caso contr�rio,
			 * Uma janela de aviso aparece avisando que os dados informados est�o incorretos.
			 * */
			public void actionPerformed(ActionEvent arg0) {
				ClienteDAO cliente = new ClienteDAO();
				String strUsuario = txtUsuario.getText().trim();
				@SuppressWarnings("deprecation")
				String strSenha = new String(campoSenha.getText()).trim();
				
				if(cliente.checarLogin(strUsuario, strSenha)){
					JOptionPane.showMessageDialog(null, "Login Realizado!");
					
					AreaClienteGUI.main(null);
					frmLogin.dispose();
				}else{
				    JOptionPane.showMessageDialog(null, "Dados incorretos!");
				}
			}
		});
		btnEntrar.setBounds(88, 237, 89, 23);
		painel.add(btnEntrar);
		
		btnCadastrarse = new JButton("Cadastre-se");
		btnCadastrarse.addActionListener(new ActionListener() {
			/** 
			 * Fun��o de a��o do bot�o "Cadastre-se", ou seja, quando o referido bot�o � clicado, a seguinte fun��o � acionada.
			 * Como esse bot�o ser� utilizado para os usu�rios que ainda n�o possuem um cadastro no sistema, o usu�rio � redirecionado
			 * para a tela de cadastro.
			 * */
			public void actionPerformed(ActionEvent e) {
				try {
					ClienteGUI.main(null);
					frmLogin.dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnCadastrarse.setBounds(187, 237, 110, 23);
		painel.add(btnCadastrarse);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			/** A��o de quando o bot�o "Voltar" � clicado, o sistema volta para a tela inicial*/
			public void actionPerformed(ActionEvent arg0) {
				HomeGUI.main(null);
				frmLogin.dispose();
			}
		});
		btnVoltar.setBounds(307, 237, 89, 23);
		painel.add(btnVoltar);
	}
}
