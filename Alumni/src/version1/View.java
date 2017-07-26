package version1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class View extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public View() {
		setTitle("WelTec Alumni");
		getContentPane().setLayout(null);
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setBounds(10, 11, 81, 14);
		getContentPane().add(lblStudentName);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(10, 36, 81, 14);
		getContentPane().add(lblStudentId);
		
		textField = new JTextField();
		textField.setBounds(101, 8, 240, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(101, 33, 240, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 89, 417, 337);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(338, 55, 89, 23);
		getContentPane().add(btnSearch);
		
		JButton btnEditMyDetails = new JButton("Edit My Details");
		btnEditMyDetails.setBounds(10, 465, 111, 23);
		getContentPane().add(btnEditMyDetails);
		
		JButton btnEditStudentDetails = new JButton("Edit Student Details");
		btnEditStudentDetails.setBounds(286, 465, 141, 23);
		getContentPane().add(btnEditStudentDetails);
	}

}
