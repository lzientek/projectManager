package FrontEnd;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.UIManager;

import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaLookAndFeel;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * madee by gael
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
					
					login frame = new login();
					frame.setVisible(true);
				
					frame.setMinimumSize(new Dimension(450, 350));
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(221, 58, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(221, 109, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(167, 227, 89, 23);
		contentPane.add(btnRegister);
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //todo :code pour aller vers register
            }
        });

        JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(167, 151, 89, 23);
		contentPane.add(btnLogin);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setBounds(176, 11, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(114, 61, 63, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(114, 112, 75, 17);
		contentPane.add(lblPassword);
		
		JLabel lblNotRegistered = new JLabel("Not registered ? Follow the link");
		lblNotRegistered.setBounds(135, 187, 189, 20);
		contentPane.add(lblNotRegistered);
		
		
	}
}
