package FrontEnd;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import DataBase.JdbcUserDao;
import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;

public class Register extends JFrame {

	private JPanel contentPane;
    private JTextField textField_mail;
    private JTextField textField_password;
    private JTextField textField_password1;
    private JCheckBox checkBox_isManager;

	/**
	 * Create the frame.
	 */
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 320);
        setMinimumSize(new Dimension(450, 320));
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

        checkBox_isManager = new JCheckBox("Manager");
        checkBox_isManager.setBounds(189, 195, 150, 20);
        contentPane.add(checkBox_isManager);


		JButton btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
                Matcher m = p.matcher(textField_mail.getText().toUpperCase());
                if (m.matches()) {
                    if (textField_password.getText().equals(textField_password1.getText())) {
                        new JdbcUserDao().createUser(textField_mail.getText(),
                                textField_password.getText(),
                                checkBox_isManager.isSelected());
                        dispose();
                        goToLogin();
                    } else
                        JOptionPane.showMessageDialog((Component) e.getSource(), "Les deux mot de passe doivent etre les meme");
                } else
                    JOptionPane.showMessageDialog((Component) e.getSource(), "Le mail doit etre valide");
            }
        });
        btnSubmit.setBounds(189, 240, 86, 23);
        contentPane.add(btnSubmit);
		
		JLabel lblRegister = new JLabel("Register");
        lblRegister.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
        lblRegister.setBounds(189, 0, 200, 50);
        contentPane.add(lblRegister);
		
		JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(85, 60, 90, 14);
        contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(85, 105, 94, 14);
        contentPane.add(lblPassword);
		
		JLabel lblCheckPassword = new JLabel("Check Password");
        lblCheckPassword.setBounds(85, 150, 104, 14);
        contentPane.add(lblCheckPassword);
	}

    private void goToLogin() {
        Login frame = new Login();
        frame.setVisible(true);
    }
}
