package version1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class Edit extends JFrame {
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private boolean admin;
	public Edit() {
		setMinimumSize(new Dimension(320, 240));
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
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(97, 36, 176, 20);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(97, 11, 176, 20);
		getContentPane().add(textField_2);
		
		JLabel label_3 = new JLabel("Email");
		label_3.setBounds(10, 89, 46, 14);
		getContentPane().add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(97, 86, 176, 20);
		getContentPane().add(textField_3);
		
		JLabel label_4 = new JLabel("Confirm Email");
		label_4.setBounds(10, 114, 77, 14);
		getContentPane().add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(97, 111, 176, 20);
		getContentPane().add(textField_4);
		
		JLabel label_5 = new JLabel("Studied");
		label_5.setBounds(10, 139, 46, 14);
		getContentPane().add(label_5);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				View viewScreen = new View(admin);
				viewScreen.setVisible(true);
				dispose();
			}
		});
		btnUpdate.setBounds(85, 167, 89, 23);
		getContentPane().add(btnUpdate);
		
		JButton button_1 = new JButton("Clear");
		button_1.setBounds(184, 167, 89, 23);
		getContentPane().add(button_1);
		
		JLabel lblDegree = new JLabel("Degree");
		lblDegree.setBounds(97, 142, 46, 14);
		getContentPane().add(lblDegree);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(97, 64, 77, 14);
		getContentPane().add(lblStudentId);
	}
	
}
