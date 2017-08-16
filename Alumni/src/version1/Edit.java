package version1;

import java.awt.Font;
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
public class Edit extends JFrame {
	private JTextField textField_FN;
	private JTextField textField_LN;
	private JTextField textField_Email;
	private JTextField textField_CheckEmail;
	private static String URL = "jdbc:mysql://localhost:3306/alumnischema";
	private static final String USER = "AlumniAdmin";
	private static final String PASSWORD = "WelTec123";
	private boolean constraintsBool = true;
	
	public Edit(PersonInfo info, CourseStudied study) {
		setMinimumSize(new Dimension(315, 225));
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
		label_4.setBounds(10, 114, 298, 14);
		getContentPane().add(label_4);
		
		textField_CheckEmail = new JTextField();
		textField_CheckEmail.setColumns(10);
		textField_CheckEmail.setBounds(97, 111, 176, 20);
		getContentPane().add(textField_CheckEmail);
		
		textField_FN.setText(info.getFirstName()); 
		textField_LN.setText(info.getLastName());
		textField_Email.setText(info.getEmail());
		textField_CheckEmail.setText(info.getEmail());
		
		JButton button_1 = new JButton("Clear");
		button_1.setBounds(184, 142, 89, 23);
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
		
		JLabel lblStudentId = new JLabel(String.valueOf(info.getId()));
		lblStudentId.setBounds(97, 64, 77, 14);
		getContentPane().add(lblStudentId);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnUpdate.setEnabled(false);
				boolean warning = false;
				
				if(warning == false)
				{
					// checks first name is between 1-40 chars and is not null
					if (textField_FN.getText().length() >= 40) {
						textField_FN.setText(info.getFirstName());
						JOptionPane.showMessageDialog(new JFrame(), "First Name must be no longer than 40 characters!", "Check Input", JOptionPane.ERROR_MESSAGE);
						constraintsBool = false;
						warning = true;
					} else if ((textField_FN.getText().length() == 0)) {
						textField_FN.setText(info.getFirstName());
						JOptionPane.showMessageDialog(new JFrame(), "First Name must not be empty!", "Check Input", JOptionPane.ERROR_MESSAGE);
						constraintsBool = false;
						warning = true;
					}
				}
				
				if(warning == false)
				{
					// checks last name is between 1-40 chars and is not null
					if (textField_LN.getText().length() >= 40) {
						textField_LN.setText(info.getLastName());
						JOptionPane.showMessageDialog(new JFrame(), "Last Name must be no longer than 40 characters!", "Check Input", JOptionPane.ERROR_MESSAGE);
						constraintsBool = false;
						warning = true;
					} else if ((textField_LN.getText().length() == 0)) {
						textField_LN.setText(info.getLastName());
						JOptionPane.showMessageDialog(new JFrame(), "Last Name must not be empty!", "Check Input", JOptionPane.ERROR_MESSAGE);
						constraintsBool = false;
						warning = true;
					}
				}
				
				if(warning == false)
				{
					// Checks emails match, meet constraints and is non null
					if (textField_Email.getText().length() >= 40) {
						textField_Email.setText(info.getEmail());
						JOptionPane.showMessageDialog(new JFrame(), "Email must be no longer than 40 characters!", "Check Input", JOptionPane.ERROR_MESSAGE);
						constraintsBool = false;
						warning = true;
					} else if ((textField_Email.getText().length() == 0)) {
						textField_Email.setText(info.getEmail());
						JOptionPane.showMessageDialog(new JFrame(), "Email must not be empty!", "Check Input", JOptionPane.ERROR_MESSAGE);
						constraintsBool = false;
						warning = true;
					} else if (!(textField_Email.getText().equals(textField_CheckEmail.getText()))) {
						textField_CheckEmail.setText(info.getEmail());
						JOptionPane.showMessageDialog(new JFrame(), "Emails do not match!", "Check Input", JOptionPane.ERROR_MESSAGE);
						constraintsBool = false;
						warning = true;
					}
				}
				
				
				//Checks if all constraints are met and updates if correct
				if (constraintsBool == false) {
					JOptionPane.showMessageDialog(new JFrame(), "Please check your details are correct before updating", "Check Input", JOptionPane.ERROR_MESSAGE);
					textField_FN.setText(info.getFirstName()); 
					textField_LN.setText(info.getLastName());
					textField_Email.setText(info.getEmail());
					textField_CheckEmail.setText(info.getEmail());
					constraintsBool = true;
					btnUpdate.setEnabled(true);
				} else {
					String query = "UPDATE alumnischema.students SET firstName = '" + textField_FN.getText() + 
							"' , LastName = '" + textField_LN.getText() + 
							"', Email = '" + textField_Email.getText() + 
							"' WHERE idStudents = " + info.getIdStudent() + ";";
					Connection connection = null;
					try {
						connection = DriverManager.getConnection(URL, USER, PASSWORD);
						PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(query);
						pstmt.executeUpdate();
						pstmt.close();
						JOptionPane.showMessageDialog(new JFrame(), "Update Complete!", "Updated Database", JOptionPane.ERROR_MESSAGE);
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
							
					View viewScreen = new View();
					viewScreen.setVisible(true);
					dispose();
				}
			}
		});	
		btnUpdate.setBounds(85, 142, 89, 23);
		getContentPane().add(btnUpdate);
	}
}
