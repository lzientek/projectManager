package FrontEnd;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;


    /**
     * Create the frame.
     */
    public Login() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(450, 350));
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textField = new JTextField();
        textField.setBounds(189, 58, 200, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JPasswordField();
        textField_1.setBounds(189, 109, 200, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JButton btnRegister = new JButton("Register");
        btnRegister.setBounds(167, 227, 89, 23);
        contentPane.add(btnRegister);
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Register frame = new Register();
                frame.setVisible(true);
                dispose();
            }
        });

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(167, 151, 89, 23);
        contentPane.add(btnLogin);

        JLabel lblRegister = new JLabel("Login");
        lblRegister.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
        lblRegister.setBounds(189, 0, 200, 50);
        contentPane.add(lblRegister);

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
