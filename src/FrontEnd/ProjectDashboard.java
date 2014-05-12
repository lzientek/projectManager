package FrontEnd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class ProjectDashboard extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectDashboard frame = new ProjectDashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProjectDashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProjectDashboard = new JLabel("Project Dashboard");
		lblProjectDashboard.setBounds(177, 0, 96, 14);
		contentPane.add(lblProjectDashboard);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 41, 46, 14);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(88, 38, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblStartDate = new JLabel("Start date:");
		lblStartDate.setBounds(10, 88, 90, 14);
		contentPane.add(lblStartDate);
		
		textField_1 = new JTextField();
		textField_1.setBounds(88, 85, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEndDate = new JLabel("End date:");
		lblEndDate.setBounds(222, 88, 70, 14);
		contentPane.add(lblEndDate);
		
		textField_2 = new JTextField();
		textField_2.setBounds(302, 85, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(10, 136, 60, 14);
		contentPane.add(lblAuthor);
		
		textField_3 = new JTextField();
		textField_3.setBounds(88, 133, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(10, 183, 70, 14);
		contentPane.add(lblDescription);
		
		textField_4 = new JTextField();
		textField_4.setBounds(88, 180, 310, 42);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(10, 236, 60, 14);
		contentPane.add(lblStatus);
		
		JRadioButton rdbtnCompleted = new JRadioButton("Completed");
		rdbtnCompleted.setBounds(88, 232, 109, 23);
		contentPane.add(rdbtnCompleted);
	}
}
