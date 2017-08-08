package version1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class LogIn extends JFrame {
	private JTextField textUsername;
	private JTextField textPassword;
	private boolean admin;	
	public LogIn() {
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
		
		JButton btnLogin = new JButton("Log In");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String text = textUsername.getText();
				
				View viewScreen = new View(admin);
				viewScreen.setVisible(true);
				dispose();
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
	
	public void main(String args[])
	{
		LogIn loginScreen = new LogIn();
		loginScreen.setVisible(true);
	}
}
