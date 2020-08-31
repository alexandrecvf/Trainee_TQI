package br.com.trainee_tqi.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import br.com.trainee_tqi.factory.ConnectionFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;

/**
 * <h2>Classe LoginGUI</h2><br>
 * Responsável por realizar o login do usuário. Utilizando as credenciais que foram passadas nessa tela e as
 * comparando com as informações salvas no banco de dados.
 * 
 * @author Alexandre Vilarinho
 * */
public class LoginGUI extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** Jframe responsável pela janela da tela de login*/
	private JFrame frmLogin;
	/** txtUsuario é o campo que irá receber o email do cliente*/
	private JTextField txtUsuario;
	/** campoSenha é o campo que receberá a senha do cadastro do cliente*/
	private JPasswordField campoSenha;
	/** Variável do tipo connection, responsável pela conexão com o banco de dados*/
	private Connection connection;
	/** Label que também é o título da janela*/
	private JLabel lblLogin;
	/** painel é onde os componentes da janela serão colocados*/
	private JPanel painel;
	/** lblEmail é o label responsável por indicar o campo de e-mail*/
	private JLabel lblEmail;
	/** lblSenha é o label responsável por indicar o campo de senha*/
	private JLabel lblSenha;
	/** btnEntrar é o botão responsável que leva o usuário para verificação de e-mail e senha e em seguida, redireciona para a área do cliente*/
	private JButton btnEntrar;
	/** btnCadastrarse é o responsável de redirecionar os usuários para a tela de cadastro*/
	private JButton btnCadastrarse;

	/**
	 * Função main, responsável por rodar a aplicação
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
	 * Construtor responsável por chamar a função initialize.
	 */
	public LoginGUI() {
		initialize();
	}

	/**
	 * Inicialize o conteúdo do frame.
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
			 * Função de ação do botão entrar, ou seja, quando o botão "Entrar" é clicado, essa função é acionada.
			 * Nesse método, os valores digitados nos campos e-mail e senha são comparados com os valores inseridos previamento no BD.
			 * Caso exista um e-mail e senha correspondente no banco de dados, o usuário é redirecionado para a Área do Cliente, caso contrário,
			 * Uma janela de aviso aparece avisando que os dados informados estão incorretos.
			 * */
			public void actionPerformed(ActionEvent arg0) {
				String strUsuario = txtUsuario.getText().trim();
				String strSenha = new String(campoSenha.getText()).trim();
				
				if(checarLogin(strUsuario, strSenha)){

				    /*Chama a tela Área do Cliente*/
					JOptionPane.showMessageDialog(null, "Login Realizado!");


				}else{
				    JOptionPane.showMessageDialog(null, "Dados incorretos!");
				}
			}
		});
		btnEntrar.setBounds(197, 207, 89, 23);
		painel.add(btnEntrar);
		
		btnCadastrarse = new JButton("Cadastre-se");
		btnCadastrarse.addActionListener(new ActionListener() {
			/** 
			 * Função de ação do botão "Cadastre-se", ou seja, quando o referido botão é clicado, a seguinte função é acionada.
			 * Como esse botão será utilizado para os usuários que ainda não possuem um cadastro no sistema, o usuário é redirecionado
			 * para a tela de cadastro.
			 * */
			public void actionPerformed(ActionEvent e) {
				try {
					ClienteGUI cliente = new ClienteGUI();
					cliente.main(null);
					frmLogin.dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnCadastrarse.setBounds(187, 237, 110, 23);
		painel.add(btnCadastrarse);
	}
	/**
	 * Função checarLogin é quem de fato faz a verificação dos dados passados pelo usuário e compara com o banco de dados.
	 * Primeiramente é feita a conexão com o banco de dados, depois, é preparado o termo de pesquisa, utilizando o comando SELECT
	 * do SQL. Será selecionado no BD o e-mail e a senha confiram com o passado pelo usuário. Caso encontre algo no banco de dados
	 * que confira, a função retorna true.
	 * 
	 * @param email	Recebe o e-mail digitado pelo usuário
	 * @param senha Recebe a senha digitada pelo usuário
	 * 
	 * @return true ou false, indicando se encontrou ou não um registro semelhante no banco de dados
	 * */
	public boolean checarLogin(String email, String senha){
		connection = new ConnectionFactory().getConnection(); 
	    java.sql.PreparedStatement stmt = null;
	    ResultSet rs = null;
	    boolean check = false;

	    if(!email.isEmpty() && !senha.isEmpty()) {
	        try {
	            stmt = connection.prepareStatement("SELECT * FROM cliente WHERE email = ? and senha = ?");
	            stmt.setString(1, email);
	            stmt.setString(2, senha);
	            rs = stmt.executeQuery();

	            if (rs.next()){
	              check = true;
	            }

	        } catch (SQLException ex) {
	        }
	    }
		return check;
}
}
