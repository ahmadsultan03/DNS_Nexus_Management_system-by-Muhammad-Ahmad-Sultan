
package DNS_Nexus_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, cancel;
    JTextField username, password;

    Login() {
             super("DNS Nexus:DNS Management System - Version 1.00");
        getContentPane().setBackground(Color.DARK_GRAY);
        setLayout(null);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 40, 100, 25);
        lblusername.setForeground(Color.WHITE);
        add(lblusername);

        username = new JTextField();
        username.setBounds(150, 40, 150, 25);
        add(username);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 90, 100, 25);
        lblpassword.setForeground(Color.WHITE);
        add(lblpassword);

        password = new JPasswordField();
        password.setBounds(150, 90, 150, 25);
        add(password);

        login = new JButton("Login");
        login.setBounds(40, 160, 120, 35);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.YELLOW);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(180, 160, 120, 35);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.RED);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 25, 200, 200);
        add(image);

        setSize(600, 270);
        setLocation(500, 250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String username_ = this.username.getText();
            String password_ = this.password.getText();

            String query = "select * from login where username='" + username_ + "' and password='" + password_ + "'";

            try {
                DNS_Nexus_Management_System con = new DNS_Nexus_Management_System();
                ResultSet rs = con.st.executeQuery(query);

                if (rs.next()) {
                    setVisible(false);
                    new DNS_Nexus_Management_System().setVisible(true); // Change this line
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
