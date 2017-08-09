package version1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class Edit extends JFrame {
	private JTextField textField_FN;
	private JTextField textField_LN;
	private JTextField textField_Email;
	private JTextField textField_CheckEmail;
	private static final String URL = "127.0.0.1";
	private static final String USER = "AlumniAdmin";
	private static final String PASSWORD = "WelTec123";
	private boolean constraintsBool = true;
	
	public Edit(String firstName, String lastName, String id, String email ) {
		setMinimumSize(new Dimension(450, 300));
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		setTitle("WelTec Alumni");
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("First Name");
		label.setBounds(10, 14, 77, 14);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Last Name");
		label_1.setBounds(10, 39, 77, 14);
		getContentPane().add(label_1);
		
		JLabel lblStudentId_1 = new JLabel("Student ID");
		lblStudentId_1.setBounds(10, 64, 77, 14);
		getContentPane().add(lblStudentId_1);
		
		textField_FN = new JTextField();
		textField_FN.setColumns(10);
		textField_FN.setBounds(97, 11, 176, 20);
		getContentPane().add(textField_FN);
		
		textField_LN = new JTextField();
		textField_LN.setColumns(10);
		textField_LN.setBounds(97, 36, 176, 20);
		getContentPane().add(textField_LN);
		
		JLabel label_3 = new JLabel("Email");
		label_3.setBounds(10, 89, 46, 14);
		getContentPane().add(label_3);
		
		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(97, 86, 176, 20);
		getContentPane().add(textField_Email);
		
		JLabel label_4 = new JLabel("Confirm Email");
		label_4.setBounds(10, 114, 77, 14);
		getContentPane().add(label_4);
		
		textField_CheckEmail = new JTextField();
		textField_CheckEmail.setColumns(10);
		textField_CheckEmail.setBounds(97, 111, 176, 20);
		getContentPane().add(textField_CheckEmail);
		
		textField_FN.setText(firstName); 
		textField_LN.setText(lastName);
		textField_Email.setText(email);
		textField_CheckEmail.setText(email);
		
		JLabel label_5 = new JLabel("Studied");
		label_5.setBounds(10, 139, 46, 14);
		getContentPane().add(label_5);
		
		JButton button_1 = new JButton("Clear");
		button_1.setBounds(184, 167, 89, 23);
		getContentPane().add(button_1);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_FN.setText(""); 
				textField_LN.setText("");
				textField_Email.setText("");
				textField_CheckEmail.setText("");
			}
		});
		
		JLabel lblDegree = new JLabel("Degree");
		lblDegree.setBounds(97, 142, 46, 14);
		getContentPane().add(lblDegree);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(97, 64, 77, 14);
		getContentPane().add(lblStudentId);
		
		JLabel labelFN = new JLabel("");
		labelFN.setFont(new Font("Tahoma", Font.PLAIN, 8));
		labelFN.setForeground(Color.RED);
		labelFN.setBounds(281, 14, 143, 14);
		getContentPane().add(labelFN);
		
		JLabel labelLN = new JLabel("");
		labelLN.setFont(new Font("Tahoma", Font.PLAIN, 8));
		labelLN.setForeground(Color.RED);
		labelLN.setBounds(283, 39, 141, 14);
		getContentPane().add(labelLN);
		
		JLabel label_E = new JLabel("");
		label_E.setFont(new Font("Tahoma", Font.PLAIN, 8));
		label_E.setForeground(Color.RED);
		label_E.setBounds(283, 89, 141, 14);
		getContentPane().add(label_E);
		
		JLabel label_CE = new JLabel("");
		label_CE.setFont(new Font("Tahoma", Font.PLAIN, 8));
		label_CE.setForeground(Color.RED);
		label_CE.setBounds(283, 114, 141, 14);
		getContentPane().add(label_CE);
		
		JLabel label_Update = new JLabel("");
		label_Update.setFont(new Font("Tahoma", Font.PLAIN, 8));
		label_Update.setForeground(Color.RED);
		label_Update.setBounds(10, 201, 263, 14);
		getContentPane().add(label_Update);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnUpdate.setEnabled(false);
				
				// checks first name is between 1-40 chars and is not null
				if (textField_FN.getText().length() >= 40) {
					textField_FN.setText(firstName);
					labelFN.setText("First Name must be no longer than 40 characters");
					constraintsBool = false;
				} else if ((textField_FN.getText().length() == 0)) {
					textField_FN.setText(firstName);
					labelFN.setText("First Name field must not be empty");
					constraintsBool = false;
				}

				// checks last name is between 1-40 chars and is not null
				if (textField_LN.getText().length() >= 40) {
					textField_LN.setText(lastName);
					labelLN.setText("Last Name must be no longer than 40 characters");
					constraintsBool = false;
				} else if ((textField_LN.getText().length() == 0)) {
					textField_LN.setText(lastName);
					labelLN.setText("Last Name field must not be empty");
					constraintsBool = false;
				}

				// Checks emails match, meet constraints and is non null
				if (textField_Email.getText().length() >= 40) {
					textField_Email.setText(email);
					label_E.setText("Email must be no longer than 40 characters");
					constraintsBool = false;
				} else if ((textField_Email.getText().length() == 0)) {
					textField_Email.setText(email);
					label_E.setText("Email field must not be empty");
					constraintsBool = false;
				} else if (!(textField_Email.getText().equals(textField_CheckEmail.getText()))) {
					textField_CheckEmail.setText(email);
					label_CE.setText("Emails do not match");
					constraintsBool = false;
				}
				
				//Checks if all constraints are met and updates if correct
				if (constraintsBool == false) {
					label_Update.setText("Please check your details are correct before updating");
					constraintsBool = true;
					btnUpdate.setEnabled(true);
				} else {
					String query = "UPDATE alumnischema.students SET firstName = " + textField_FN.getText() + ", LastName = " + textField_LN.getText() + ", Email = " + textField_Email.getText() + " WHERE StudentID = id";
					Connection connection = null;
					try {
						connection = DriverManager.getConnection(URL, USER, PASSWORD);
						Statement statement = connection.createStatement();
						statement.executeQuery(query);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
							
					View viewScreen = new View(false);
					viewScreen.setVisible(true);
					dispose();
				}
			}
		});
		
		btnUpdate.setBounds(85, 167, 89, 23);
		getContentPane().add(btnUpdate);
		
	}

}
