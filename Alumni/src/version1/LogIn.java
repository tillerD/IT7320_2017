package version1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("serial")
public class LogIn extends JFrame {
	private JTextField textUsername;
	private JTextField textPassword;
	private boolean admin;
	private static final String URL = "127.0.0.1";
	public LogIn() {
		setMinimumSize(new Dimension(315, 160));
		setTitle("WelTec Alumni");
		getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 11, 109, 26);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 48, 46, 14);
		getContentPane().add(lblPassword);
		
		textUsername = new JTextField();
		textUsername.setBounds(77, 14, 194, 20);
		getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setBounds(77, 45, 194, 20);
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
				
				String query = "SELECT admin FROM alumnischema.students WHERE username = " + user + " password = " + password;
				Connection connection = null;
				try {
					connection = DriverManager.getConnection(URL, user, password);
					Statement statement = connection.createStatement();
					ResultSet result = statement.executeQuery(query);
					if(result.next())
					{
						if(result.getInt("admin") == 1)
							admin = true;
						else
							admin = false;
					
						View viewScreen = new View(admin);
						viewScreen.setVisible(true);
						dispose();
					}
					else
					{
						label_login.setText("Username or password is incorrect");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

			}
		});
		btnLogin.setBounds(83, 76, 89, 23);
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
		btnSignUp.setBounds(182, 76, 89, 23);
		getContentPane().add(btnSignUp);
		

	}

	public static void main(String args[])
	{
		LogIn loginScreen = new LogIn();
		loginScreen.setVisible(true);
	}
}
