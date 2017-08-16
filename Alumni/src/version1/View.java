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
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class View extends JFrame {
	private JTextField nameField;
	private JTextField idField;
	JTextArea summary;
	private static String URL = "jdbc:mysql://localhost:3306/alumnischema";
	private static final String USER = "AlumniAdmin";
	private static final String PASSWORD = "WelTec123";
	public View(boolean role) {
		
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
						String query = "SELECT * FROM alumnischema.students WHERE studentid = '" + id + "' AND firstname = '" + fName + "' AND lastname = '" + lName + "';";
						Connection connection = null;
						Connection connection2 = null;
						try {
							connection = DriverManager.getConnection(URL, USER, PASSWORD);
							Statement statement = connection.createStatement();
							ResultSet rs = statement.executeQuery(query);
							if(rs.next())
							{
								PersonInfo info = new PersonInfo();
								info.setIdStudent(rs.getInt("idStudents"));
								info.setFirstName(rs.getString("firstname"));
								info.setLastName(rs.getString("lastname"));
								info.setId(rs.getInt("StudentID"));
								info.setEmail(rs.getString("email"));
								
								summary.setText(displayText(info));
								
								String query2 = "SELECT * FROM alumnischema.studies, alumnischema.stustu WHERE stustu.idStudents = " + info.getIdStudent() + " AND studies.idStudies = stustu.idStudies;";
								connection2 = DriverManager.getConnection(URL, USER, PASSWORD);
								Statement statement2 = connection2.createStatement();
								ResultSet rs2 = statement2.executeQuery(query2);
								while(rs2.next())
								{
									CourseStudied study = new CourseStudied();
									study.setName(rs2.getString("Name"));
									study.setMajor(rs2.getString("Major"));
									study.setDescription(rs2.getString("Description"));
									
									String text = summary.getText();
									text += addText(study);
									summary.setText(text);
								}
							}
							else
							{
								summary.setText("");
								JOptionPane.showMessageDialog(null, "Name and Student ID combination is incorrect!", "Search Error", JOptionPane.ERROR_MESSAGE);
							}
						} catch (SQLException e1) {
							summary.setText("");
							JOptionPane.showMessageDialog(null, "Name and Student ID combination is incorrect!", "Search Error", JOptionPane.ERROR_MESSAGE);
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
				}
				else
				{
					nameField.setText("");
					idField.setText("");
					JOptionPane.showMessageDialog(new JFrame(), "Invalid input!", "Check Input", JOptionPane.ERROR_MESSAGE);
				}
			}

			private String addText(CourseStudied study) {
				String display = "\n\nCourse Name: " + study.getName() + "\nMajor: " + study.getMajor() + "\nDescription: " + study.getDescription();
				return display;
			}

			private String displayText(PersonInfo info) {
				String display = "First Name: " + info.getFirstName() + "\nLast Name: " + info.getLastName() +
						"\nStudent ID: " + info.getId() + "\nEmail: " + info.getEmail();
				return display;
			}
		});
		btnSearch.setBounds(338, 55, 89, 23);
		getContentPane().add(btnSearch);
		
		JButton btnEditStudentDetails = new JButton("Edit Student Details");
		btnEditStudentDetails.setVisible(true);
		btnEditStudentDetails.setBounds(286, 465, 141, 23);
		getContentPane().add(btnEditStudentDetails);
		
		summary  = new JTextArea();
		summary.setBounds(10, 94, 417, 360);
		getContentPane().add(summary);
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
