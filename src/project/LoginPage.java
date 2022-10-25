/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class LoginPage extends JFrame implements ActionListener {

    JTextField userTf;
    JPasswordField userPassTf;
    JLabel label, label1, username, userpass;
    JButton b1, b2, b3;
    JFrame j;

    LoginPage() {
        
        label = new JLabel("Login");
        label.setBackground(new java.awt.Color(255, 255, 255));
        label.setFont(new java.awt.Font("Trebuchet MS", 1, 50)); // NOI18N
        label.setBounds(230, 80, 600, 60);
        
        add(label);

        username = new JLabel("User Name");
        username.setBounds(100, 180, 150, 30);
        username.setBackground(new java.awt.Color(255, 255, 255));
        username.setFont(new java.awt.Font("Trebuchet MS", 1, 18));
        userTf = new JTextField();
        userTf.setBackground(new java.awt.Color(255, 255, 255));
        userTf.setFont(new java.awt.Font("Trebuchet MS", 1, 18));
        userTf.setBounds(100, 220, 200, 30);

        userpass = new JLabel("User Password");
        userpass.setBounds(100, 270, 150, 30);
        userpass.setBackground(new java.awt.Color(255, 255, 255));
        userpass.setFont(new java.awt.Font("Trebuchet MS", 1, 18));
        userPassTf = new JPasswordField();
        userPassTf.setBackground(new java.awt.Color(255, 255, 255));
        userPassTf.setFont(new java.awt.Font("Trebuchet MS", 1, 18));
        userPassTf.setBounds(100, 310, 200, 30);

        b1 = new JButton("Login");
        b1.setBackground(new java.awt.Color(255, 255, 255));
        b1.setFont(new java.awt.Font("Trebuchet MS", 1, 18));
        b1.setBounds(100, 380, 100, 25);
        b1.addActionListener(this);

        add(b1);

        b2 = new JButton("Back");
        b2.setBackground(new java.awt.Color(255, 255, 255));
        b2.setFont(new java.awt.Font("Trebuchet MS", 1, 25));
        b2.setBounds(220, 450, 100, 30);
        b2.addActionListener(this);

        add(b2);

        b3 = new JButton("Exit");
        b3.setBackground(new java.awt.Color(255, 255, 255));
        b3.setFont(new java.awt.Font("Trebuchet MS", 1, 25));
        b3.setBounds(220, 500, 100, 30);
        b3.addActionListener(this);
        
        add(b3);
        
        
                
        label1 = new JLabel("NetWings");
        label1.setBackground(new java.awt.Color(255, 255, 255));
        label1.setFont(new java.awt.Font("Trebuchet MS", 1, 50)); // NOI18N
        label1.setBounds(180, 700, 600, 60);
        
        add(label1);

        add(userTf);
        add(username);
        add(userPassTf);
        add(userpass);

        setSize(600, 800);
        this.setTitle("Login Page");
        getContentPane().setBackground(new java.awt.Color(213,245,238));
 

        this.setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {

            try {
                String userName = userTf.getText();
                String userPass = userPassTf.getText();

                if (userName.equals("admin") && userPass.equals("123")) {

                    setVisible(false);
                    new Table();       //table start
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new Table().setVisible(true);
                        }
                    });
                } else {
                    JOptionPane.showMessageDialog(LoginPage.this, "Sorry, Username or Password Error", "Login Error!", JOptionPane.ERROR_MESSAGE);
                    userTf.setText("");
                    userPassTf.setText("");
                }

            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else if (e.getSource() == b2) {
            try {

                setVisible(false);
                new HomePage();

            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else if (e.getSource() == b3) {
            int exit = JOptionPane.showConfirmDialog(null, "ARE YOU SURE YOU WANT TO EXIT?");
            if (exit == 0) {
                System.exit(0);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }

        }

    }

}
