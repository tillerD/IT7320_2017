package version1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class SignUp extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private boolean admin;
	public SignUp() {
		setTitle("WelTec Alumni");
		getContentPane().setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(10, 11, 77, 14);
		getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(10, 36, 77, 14);
		getContentPane().add(lblLastName);
		
		JLabel lblStudnetId = new JLabel("Studnet ID");
		lblStudnetId.setBounds(10, 61, 77, 14);
		getContentPane().add(lblStudnetId);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 86, 46, 14);
		getContentPane().add(lblEmail);
		
		JLabel lblConfirmEmail = new JLabel("Confirm Email");
		lblConfirmEmail.setBounds(10, 111, 77, 14);
		getContentPane().add(lblConfirmEmail);
		
		JLabel lblStudies = new JLabel("Studied");
		lblStudies.setBounds(10, 136, 46, 14);
		getContentPane().add(lblStudies);
		
		textField = new JTextField();
		textField.setBounds(97, 8, 176, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(97, 33, 176, 20);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(97, 58, 176, 20);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(97, 83, 176, 20);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(97, 108, 176, 20);
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(97, 133, 176, 20);
		getContentPane().add(textField_5);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				View viewScreen = new View(admin);
				viewScreen.setVisible(true);
				dispose();
			}
		});
		btnSignUp.setBounds(85, 164, 89, 23);
		getContentPane().add(btnSignUp);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(184, 164, 89, 23);
		getContentPane().add(btnClear);
	}

}
