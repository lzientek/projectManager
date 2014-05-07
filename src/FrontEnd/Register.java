package FrontEnd;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.UIManager;

import DataBase.JdbcUserDao;
import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;

public class Register extends JFrame {

	private JPanel contentPane;
    private JTextField textField_mail;
    private JTextField textField_password;
    private JTextField textField_password1;

	/**
	 * Made by gael.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					try{
						UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
							
							
					}catch(Exception e)
					{
						
					}
					
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
        setMinimumSize(new Dimension(450, 300));
        contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

        textField_mail = new JTextField();
        textField_mail.setBounds(189, 60, 150, 20);
        contentPane.add(textField_mail);
        textField_mail.setColumns(20);

        textField_password = new JPasswordField();
        textField_password.setBounds(189, 105, 150, 20);
        contentPane.add(textField_password);
        textField_password.setColumns(20);

        textField_password1 = new JPasswordField();
        textField_password1.setBounds(189, 150, 150, 20);
        contentPane.add(textField_password1);
        textField_password1.setColumns(20);




		JButton btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //todo : check le mail (regex)
                if (textField_password.getText().equals(textField_password1.getText())) {
                    new JdbcUserDao().createUser(textField_mail.getText(),
                            textField_password.getText(),
                            true);
                }
            }
        });
        btnSubmit.setBounds(189, 196, 86, 23);
		contentPane.add(btnSubmit);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setBounds(189, 11, 68, 14);
		contentPane.add(lblRegister);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(85, 67, 90, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(85, 116, 94, 14);
		contentPane.add(lblPassword);
		
		JLabel lblCheckPassword = new JLabel("Check Password");
		lblCheckPassword.setBounds(85, 156, 104, 14);
		contentPane.add(lblCheckPassword);
	}
}
