/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class info extends javax.swing.JFrame implements ActionListener {

    JTextField userTf;
    JPasswordField userPassTf;
    JLabel label, username, userpass;
    JButton b1, b2, b3, bk;

    info() {

        b1 = new JButton("SpeedTest");   
        b1.setBackground(new java.awt.Color(255, 255, 255));
        b1.setFont(new java.awt.Font("Trebuchet MS", 1, 30));
        b1.setBounds(150, 150, 300, 40);
        b1.addActionListener(this);
        
        b2 = new JButton("WebSite");
        b2.setBackground(new java.awt.Color(255, 255, 255));
        b2.setFont(new java.awt.Font("Trebuchet MS", 1, 30));
        b2.setBounds(150, 250, 300, 40);
        b2.addActionListener(this);
        
        b3 = new JButton("Contact Us");
        b3.setBackground(new java.awt.Color(255, 255, 255));
        b3.setFont(new java.awt.Font("Trebuchet MS", 1, 30));
        b3.setBounds(150, 350, 300, 40);
        b3.addActionListener(this);
        
        add(b1);
        add(b2);
        add(b3);
        
        bk = new JButton("Back");
        bk.setBackground(new java.awt.Color(255, 255, 255));
        bk.setFont(new java.awt.Font("Trebuchet MS", 1, 25));
        bk.setBounds(250, 450, 100, 30);
        bk.addActionListener(this);
                
        add(bk);

        label = new JLabel("NetWings");
        label.setBackground(new java.awt.Color(255, 255, 255));
        label.setFont(new java.awt.Font("Trebuchet MS", 1, 50)); // NOI18N
        label.setBounds(180, 700, 600, 60);

        add(label);

        setSize(600, 800);
        getContentPane().setBackground(new java.awt.Color(153,153,153));
        this.setTitle("info Page");
        this.setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String url1 = "https://www.speedtest.net/";
        String url2 = "https://www.google.com/";
        String url3 = "https://t.me/aceares";
        
        if(ae.getSource() == b1){
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url1));

        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(info.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else if(ae.getSource() == b2){
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url2));

        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(info.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else if(ae.getSource() == b3){
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url3));

        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(info.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
          else if(ae.getSource() == bk){
        try {
                setVisible(false);
                new HomePage();

            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

}
