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

@SuppressWarnings("serial")
public class LoginGUI extends JFrame{

	private JFrame frame;
	private JTextField txtUsuario;
	private JPasswordField campoSenha;
	private Connection connection;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI window = new LoginGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 355);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(lblLogin, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(102, 85, 46, 14);
		panel.add(lblEmail);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(162, 82, 200, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(102, 129, 46, 14);
		panel.add(lblSenha);
		
		campoSenha = new JPasswordField();
		campoSenha.setBounds(162, 126, 200, 20);
		panel.add(campoSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String strUsuario = txtUsuario.getText().trim();
				String strSenha = new String(campoSenha.getText()).trim();
				
				if(checaLogin(strUsuario, strSenha)){

				    /*Chama a tela Área do Cliente*/
					JOptionPane.showMessageDialog(null, "Login Realizado");


				}else{
				    JOptionPane.showMessageDialog(null, "Dados incorretos!");
				}
			}
		});
		btnEntrar.setBounds(197, 207, 89, 23);
		panel.add(btnEntrar);
		
		JButton btnCadastrarse = new JButton("Cadastrar-se");
		btnCadastrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ClienteGUI cliente = new ClienteGUI();
					cliente.main(null);
					frame.dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnCadastrarse.setBounds(187, 237, 110, 23);
		panel.add(btnCadastrarse);
	}
	
	public boolean checaLogin(String email, String senha){

		this.connection = new ConnectionFactory().getConnection(); 
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
	        //Logger.getLogger(UserDAO.class.getEmail()).log(Level.SEVERE, null, ex);
	        }
	    }
		return check;
}
}
