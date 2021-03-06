package version1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.sql.*;

@SuppressWarnings("serial")
public class LogIn extends JFrame {
	private JTextField textUsername;
	private JTextField textPassword;
	private static String URL = "jdbc:mysql://localhost:3306/alumnischema";
	private static String USER = "AlumniAdmin";
	private static String PASSWORD = "WelTec123";
	
	public LogIn() {
		setMinimumSize(new Dimension(315, 155));
		setTitle("WelTec Alumni");
		getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 11, 109, 26);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 48, 74, 14);
		getContentPane().add(lblPassword);
		
		textUsername = new JTextField();
		textUsername.setBounds(94, 14, 194, 20);
		getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setBounds(94, 48, 194, 20);
		getContentPane().add(textPassword);
		
		JLabel label_login = new JLabel("");
		label_login.setForeground(Color.RED);
		label_login.setFont(new Font("Tahoma", Font.PLAIN, 8));
		label_login.setBounds(29, 108, 242, 14);
		getContentPane().add(label_login);
		
		JButton btnLogin = new JButton("Log In");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {			
				String user = textUsername.getText();
				String password = textPassword.getText();
				//String queryTest = "SELECT admin FROM alumnischema.students WHERE username = 'dylan.tiller' AND password = 'testing123';";
				String query = "SELECT admin FROM alumnischema.students WHERE username = '" + user + "' AND password = '" + password + "';";
				Connection connection = null;
				try {
					connection = DriverManager.getConnection(URL, USER, PASSWORD);
					Statement statement = connection.createStatement();
					ResultSet result = statement.executeQuery(query);
					if(result.next())
					{					
						View viewScreen = new View();
						viewScreen.setVisible(true);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Username and/or Password are incorrect!", "Login Error", JOptionPane.ERROR_MESSAGE);
					}
					statement.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (connection != null) {
						try {
							connection.close();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnLogin.setBounds(10, 79, 89, 23);
		getContentPane().add(btnLogin);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignUp signupScreen = new SignUp();
				signupScreen.setVisible(true);
				dispose();
			}
		});
		btnSignUp.setBounds(199, 79, 89, 23);
		getContentPane().add(btnSignUp);
		

	}

	public static void main(String args[])
	{
		LogIn loginScreen = new LogIn();
		loginScreen.setVisible(true);
	}
}
