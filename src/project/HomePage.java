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
import java.awt.Canvas;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


public class HomePage extends JFrame implements ActionListener {

    JTextField Tf;
    JLabel label,label1;
    JButton b1, b2, b3;
    JFrame f;
    Font jf;
    Canvas c;
    private Font font;

    HomePage() {

        // font = new Font("Trebuchet MS", Font.BOLD, 16);
        label = new JLabel("Main Menu");
        label.setBackground(new java.awt.Color(255, 255, 255));
        label.setFont(new java.awt.Font("Trebuchet MS", 1, 50)); // NOI18N
        label.setBounds(180, 100, 600, 60);

        add(label);

        b1 = new JButton("ADMIN");
        b1.setBackground(new java.awt.Color(255, 255, 255));
        b1.setFont(new java.awt.Font("Trebuchet MS", 1, 24));
        b1.setBounds(220, 250, 120, 30);
        b1.addActionListener(this);

        add(b1);

        b2 = new JButton("info");
        b2.setBackground(new java.awt.Color(255, 255, 255));
        b2.setFont(new java.awt.Font("Trebuchet MS", 1, 24));
        b2.setBounds(220, 350, 120, 30);
        b2.addActionListener(this);

        add(b2);

        b3 = new JButton("Exit");
        b3.setBackground(new java.awt.Color(255, 255, 255));
        b3.setFont(new java.awt.Font("Trebuchet MS", 1, 16));
        b3.setBounds(240, 450, 80, 30);
        b3.addActionListener(this);

        add(b3);
        
        label1 = new JLabel("NetWings");
        label1.setBackground(new java.awt.Color(255, 255, 255));
        label1.setFont(new java.awt.Font("Trebuchet MS", 1, 50)); // NOI18N
        label1.setBounds(180, 700, 600, 60);
        
        add(label1);
        
        
        

        this.setTitle("Home Page");
        this.setLocationRelativeTo(null);

        getContentPane().setBackground(new java.awt.Color(0, 255, 204));
        setSize(600, 800);
        setLayout(null);
        setVisible(true);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
 
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {

            try {

                setVisible(false);
                new LoginPage();

            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else if (e.getSource() == b2) {

            try {
                setVisible(false);
                new info();

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
