package version1;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SignUp extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	public SignUp() {
		setTitle("WelTec Alumni");
		getContentPane().setLayout(null);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(10, 11, 77, 14);
		getContentPane().add(lblFirstName);

		JLabel lblErrorFN = new JLabel("Field Required");
		lblErrorFN.setForeground(Color.RED);
		lblErrorFN.setBounds(283, 11, 151, 14);
		getContentPane().add(lblErrorFN);
		lblErrorFN.setVisible(false);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(10, 36, 77, 14);
		getContentPane().add(lblLastName);

		JLabel lblErrorLN = new JLabel("Field Required");
		lblErrorLN.setForeground(Color.RED);
		lblErrorLN.setBounds(283, 36, 151, 14);
		getContentPane().add(lblErrorLN);
		lblErrorLN.setVisible(false);

		JLabel lblStudnetId = new JLabel("Studnet ID");
		lblStudnetId.setBounds(10, 61, 77, 14);
		getContentPane().add(lblStudnetId);

		JLabel lblErrorSID = new JLabel("Field Required");
		lblErrorSID.setForeground(Color.RED);
		lblErrorSID.setBounds(283, 61, 151, 14);
		getContentPane().add(lblErrorSID);
		lblErrorSID.setVisible(false);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 86, 46, 14);
		getContentPane().add(lblEmail);

		JLabel lblErrorEmail = new JLabel("Field Required");
		lblErrorEmail.setForeground(Color.RED);
		lblErrorEmail.setBounds(283, 86, 151, 14);
		getContentPane().add(lblErrorEmail);
		lblErrorEmail.setVisible(false);

		JLabel lblConfirmEmail = new JLabel("Confirm Email");
		lblConfirmEmail.setBounds(10, 111, 77, 14);
		getContentPane().add(lblConfirmEmail);

		JLabel lblErrorConfirmEmail = new JLabel("Field Required");
		lblErrorConfirmEmail.setForeground(Color.RED);
		lblErrorConfirmEmail.setBounds(283, 111, 151, 14);
		getContentPane().add(lblErrorConfirmEmail);
		lblErrorConfirmEmail.setVisible(false);

		JLabel lblStudies = new JLabel("Studied");
		lblStudies.setBounds(10, 136, 46, 14);
		getContentPane().add(lblStudies);

		JLabel lblErrorStudied = new JLabel("Field Required");
		lblErrorStudied.setForeground(Color.RED);
		lblErrorStudied.setBounds(283, 136, 151, 14);
		getContentPane().add(lblErrorStudied);
		lblErrorStudied.setVisible(false);

		textField = new JTextField();
		textField.setColumns(45);
		textField.setBounds(97, 8, 176, 20);
		getContentPane().add(textField);


		textField_1 = new JTextField();
		textField_1.setColumns(45);
		textField_1.setBounds(97, 33, 176, 20);
		getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(45);
		textField_2.setBounds(97, 58, 176, 20);
		getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(45);
		textField_3.setBounds(97, 83, 176, 20);
		getContentPane().add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(45);
		textField_4.setBounds(97, 108, 176, 20);
		getContentPane().add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(45);
		textField_5.setBounds(97, 133, 176, 20);
		getContentPane().add(textField_5);


		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unlikely-arg-type")
			@Override
			//Check fields aren't empty and meet the requirements for each filed
			public void mouseClicked(MouseEvent e) {

				if(textField.getText().equals("") && textField_1.getText().equals("") && textField_2.getText().equals("") && textField_3.getText().equals("") && textField_4.getText().equals("") && textField.getText().equals("")){
					lblErrorFN.setVisible(true);
					lblErrorFN.setText("Field Required");
					lblErrorLN.setVisible(true);
					lblErrorLN.setText("Field Required");
					lblErrorSID.setVisible(true);
					lblErrorSID.setText("Field Required");
					lblErrorEmail.setVisible(true);
					lblErrorEmail.setText("Field Required");
					lblErrorConfirmEmail.setVisible(true);
					lblErrorConfirmEmail.setText("Field Required");
					lblErrorStudied.setVisible(true);
					lblErrorStudied.setText("Field Required");
				}
				else if(textField.getText().matches("[0-9]*") && textField_1.getText().matches("[0-9]*")){
					lblErrorFN.setVisible(true);
					lblErrorFN.setText("Not a Name");
					lblErrorLN.setVisible(true);
					lblErrorLN.setText("Not a Name");
					
				}
				else if(textField_2.getText().matches("[a-z A-Z]*")) {
					lblErrorSID.setVisible(true);
					lblErrorSID.setText("ID contains only numbers");
				}
				else if(textField_2.getText().length() < 7 || textField_2.getText().length() > 7 ) {
					lblErrorSID.setVisible(true);
					lblErrorSID.setText("Incorrect amount of # ");
				}
				else if((textField_3.getText().trim().contains("@" + "."))){
					lblErrorEmail.setText("Not a proper email address");
					lblErrorEmail.setVisible(true);
				}
				else if(!textField_3.getText().equals(textField_4.getText())) {
					lblErrorEmail.setText("Emails do not match");
					lblErrorEmail.setVisible(true);
				}

				else {
					System.out.println("Batman");
					/*View viewScreen = new View();
					viewScreen.setVisible(true);
					dispose();*/
				}
			}
		});
		btnSignUp.setBounds(85, 164, 89, 23);
		getContentPane().add(btnSignUp);


		JButton btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unlikely-arg-type")
			@Override
			public void mouseClicked(MouseEvent e) {
				lblErrorFN.setVisible(false);
				lblErrorLN.setVisible(false);
				lblErrorSID.setVisible(false);
				lblErrorEmail.setVisible(false);
				lblErrorConfirmEmail.setVisible(false);
				lblErrorStudied.setVisible(false);
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
			}
		});
		btnClear.setBounds(184, 164, 89, 23);
		getContentPane().add(btnClear);

	}

	public static void main(String args[])
	{
		SignUp signUpScreen = new SignUp();
		signUpScreen.setVisible(true);
	}
}
