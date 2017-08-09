package version1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("serial")
public class View extends JFrame {
	private JTextField nameField;
	private JTextField idField;
	private JTextField summary;
	private boolean admin;
	private static final String URL = "127.0.0.1";
	private static final String USER = "AlumniAdmin";
	private static final String PASSWORD = "WelTec123";
	public View(boolean role) {
		this.admin = role;
		
		setMinimumSize(new Dimension(450, 535));
		setTitle("WelTec Alumni");
		getContentPane().setLayout(null);
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setBounds(10, 11, 81, 14);
		getContentPane().add(lblStudentName);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(10, 36, 81, 14);
		getContentPane().add(lblStudentId);
		
		nameField = new JTextField();
		nameField.setBounds(101, 8, 240, 20);
		getContentPane().add(nameField);
		nameField.setColumns(10);
		
		idField = new JTextField();
		idField.setBounds(101, 33, 240, 20);
		getContentPane().add(idField);
		idField.setColumns(10);
		
		summary = new JTextField();
		summary.setBounds(10, 89, 417, 337);
		getContentPane().add(summary);
		summary.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = nameField.getText();
				String[] splited = name.split("\\s+");
				if(splited.length == 2)
				{
					String fName = splited[0];
					String lName = splited[1];
					String id = idField.getText();
					if(fieldChecker(fName) && fieldChecker(lName) && fieldChecker(id))
					{
						String query = "SELECT * FROM students WHERE studentid = " + id + " AND firstname = " + fName + " AND lastname = " + lName;
						Connection connection = null;
						try {
							connection = DriverManager.getConnection(URL, USER, PASSWORD);
							Statement statement = connection.createStatement();
							ResultSet rs = statement.executeQuery(query);
							if(rs.next())
							{
								PersonInfo info = new PersonInfo();
								info.setIdStudent(rs.getInt("idStudents"));
								info.setFirstName(rs.getString("firstname"));
							}
						} catch (SQLException e1) {
							//TODO Auto-generated catch block
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
					}
					else
					{
						nameField.setText("");
						idField.setText("");
						JOptionPane.showMessageDialog(new JFrame(), "Invalid input!", "Dialog", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnSearch.setBounds(338, 55, 89, 23);
		getContentPane().add(btnSearch);
		
		JButton btnEditMyDetails = new JButton("Edit My Details");
		btnEditMyDetails.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			}
		});
		btnEditMyDetails.setBounds(10, 465, 111, 23);
		getContentPane().add(btnEditMyDetails);
		
		JButton btnEditStudentDetails = new JButton("Edit Student Details");
		btnEditStudentDetails.setVisible(false);
		btnEditStudentDetails.setBounds(286, 465, 141, 23);
		getContentPane().add(btnEditStudentDetails);
		
		if(admin)
		{
			btnEditMyDetails.setVisible(false);
			btnEditStudentDetails.setVisible(true);
		}
	}
	
	private boolean fieldChecker(String text)
	{
		if(text.matches("[a-zA-Z0-9]*"))
		{
			return true;
		}
		return false;
	}

}
