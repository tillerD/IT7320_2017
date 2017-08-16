package version1;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;

import java.awt.Dimension;

@SuppressWarnings("serial")
public class SignUp extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField username;
	private JTextField password;
	private JTextField cpassword;
	private static String URL = "jdbc:mysql://localhost:3306/alumnischema";
	private static final String USER = "AlumniAdmin";
	private static final String PASSWORD = "WelTec123";
	
	public SignUp() {
		setMinimumSize(new Dimension(350, 350));
		setTitle("WelTec Alumni");
		getContentPane().setLayout(null);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(10, 11, 77, 14);
		getContentPane().add(lblFirstName);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(10, 36, 77, 14);
		getContentPane().add(lblLastName);

		JLabel lblStudnetId = new JLabel("Studnet ID");
		lblStudnetId.setBounds(10, 61, 164, 14);
		getContentPane().add(lblStudnetId);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 86, 46, 14);
		getContentPane().add(lblEmail);

		JLabel lblConfirmEmail = new JLabel("Confirm Email");
		lblConfirmEmail.setBounds(10, 111, 186, 14);
		getContentPane().add(lblConfirmEmail);

		JLabel lblStudies = new JLabel("Studied");
		lblStudies.setBounds(10, 136, 46, 14);
		getContentPane().add(lblStudies);

		textField = new JTextField();
		textField.setColumns(45);
		textField.setBounds(149, 11, 176, 20);
		getContentPane().add(textField);


		textField_1 = new JTextField();
		textField_1.setColumns(45);
		textField_1.setBounds(149, 36, 176, 20);
		getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(45);
		textField_2.setBounds(149, 61, 176, 20);
		getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(45);
		textField_3.setBounds(149, 86, 176, 20);
		getContentPane().add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(45);
		textField_4.setBounds(149, 111, 176, 20);
		getContentPane().add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(45);
		textField_5.setBounds(149, 136, 176, 20);
		getContentPane().add(textField_5);


		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addMouseListener(new MouseAdapter() {
			@Override
			//Check fields aren't empty and meet the requirements for each filed
			public void mouseClicked(MouseEvent e) {

				if(textField.getText().equals("") && textField_1.getText().equals("") && textField_2.getText().equals("") && textField_3.getText().equals("") && textField_4.getText().equals("") && textField.getText().equals("")){
					JOptionPane.showMessageDialog(new JFrame(), "All Fields Required!", "Check Fields", JOptionPane.ERROR_MESSAGE);
				}
				else if(textField.getText().matches("[0-9]*") && textField_1.getText().matches("[0-9]*")){
					JOptionPane.showMessageDialog(new JFrame(), "First and Last Name must not contain numbers!", "Check Fields", JOptionPane.ERROR_MESSAGE);
					
				}
				else if(textField_2.getText().matches("[a-z A-Z]*")) {
					JOptionPane.showMessageDialog(new JFrame(), "Student ID must only contsain letters!", "Check Fields", JOptionPane.ERROR_MESSAGE);
				}
				else if(textField_2.getText().length() < 7 || textField_2.getText().length() > 7 ) {
					JOptionPane.showMessageDialog(new JFrame(), "Length of Student ID must be 7 numbers!", "Check Fields", JOptionPane.ERROR_MESSAGE);
				}
				else if((textField_3.getText().trim().contains("@" + "."))){
					JOptionPane.showMessageDialog(new JFrame(), "Invalid Email!", "Check Fields", JOptionPane.ERROR_MESSAGE);
				}
				else if(!textField_3.getText().equals(textField_4.getText())) {
					JOptionPane.showMessageDialog(new JFrame(), "Emails do not match!", "Check Fields", JOptionPane.ERROR_MESSAGE);
				}
				else if(username.getText().length() >= 40)
				{
					JOptionPane.showMessageDialog(new JFrame(), "Username must not be longer than 40 characters!", "Check Fields", JOptionPane.ERROR_MESSAGE);
				}
				else if(password.getText().length() >= 40)
				{
					JOptionPane.showMessageDialog(new JFrame(), "Password must not be longer than 40 characters!", "Check Fields", JOptionPane.ERROR_MESSAGE);
				}
				else if(!cpassword.getText().equals(password.getText()))
				{
					JOptionPane.showMessageDialog(new JFrame(), "Passwords do not match!", "Check Fields", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					String query = "INSERT INTO alumnischema.students " + 
							"(idStudents, Username, Password, firstName, LastName, StudentID, Email,  Admin)" + 
							" VALUES (3, '" + username.getText() + "', '" + password.getText() + "', '" + textField.getText() + "', '" + textField_1.getText() + "', " + Integer.parseInt(textField_2.getText()) + ", '" + textField_3.getText() + "', " + "0);";
					Connection connection = null;
					try {
						connection = DriverManager.getConnection(URL, USER, PASSWORD);
						PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(query);
						pstmt.executeUpdate();
						pstmt.close();
						JOptionPane.showMessageDialog(new JFrame(), "SignUp Complete!", "SignUp", JOptionPane.ERROR_MESSAGE);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} finally {
						if (connection != null) {
							try {
								connection.close();
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						}
					}
					
					LogIn loginScreen = new LogIn();
					loginScreen.setVisible(true);
					dispose();
				}
			}
		});
		btnSignUp.setBounds(137, 278, 89, 23);
		getContentPane().add(btnSignUp);


		JButton btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
			}
		});
		btnClear.setBounds(236, 278, 89, 23);
		getContentPane().add(btnClear);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 164, 118, 14);
		getContentPane().add(lblUsername);
		
		username = new JTextField();
		username.setColumns(45);
		username.setBounds(149, 164, 176, 20);
		getContentPane().add(username);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 192, 129, 14);
		getContentPane().add(lblPassword);
		
		password = new JTextField();
		password.setColumns(45);
		password.setBounds(149, 192, 176, 20);
		getContentPane().add(password);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(10, 220, 118, 14);
		getContentPane().add(lblConfirmPassword);
		
		cpassword = new JTextField();
		cpassword.setColumns(45);
		cpassword.setBounds(149, 220, 176, 20);
		getContentPane().add(cpassword);

	}
}
