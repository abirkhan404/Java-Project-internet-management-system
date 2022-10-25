/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Table extends JFrame implements ActionListener {

    private Container c;
    private Font font;
    private JLabel label, label1, id, name, ip, net, price;
    private JTextField idtf, nametf, iptf, nettf, pricetf;
    private JButton add, update, delete, refresh, bk;
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane scroll;
    JFrame f;

    private String[] col = {"ID", "Name", "Number", "Ethernet", "Price"};
    private String[] row = new String[5];

    Table() {
        initComponets();
    }

    private void initComponets() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 800);
        this.setLocationRelativeTo(null);
        this.setTitle("Table");

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.PINK);

        font = new Font("Trebuchet MS", Font.BOLD, 16);

        //                  Button  &     TextField
        label = new JLabel("Internet Bandwidth Management System");
        label.setBounds(200, 20, 800, 50);
        label.setFont(font);
        c.add(label);

        label1 = new JLabel("NetWings");
        label1.setBackground(new java.awt.Color(255, 255, 255));
        label1.setFont(new java.awt.Font("Trebuchet MS", 1, 50)); // NOI18N
        label1.setBounds(200, 700, 600, 60);

        add(label1);

        id = new JLabel("ID");
        id.setBounds(20, 80, 100, 30);
        id.setFont(font);
        c.add(id);

        idtf = new JTextField();
        idtf.setBounds(180, 80, 150, 30);
        idtf.setFont(font);
        c.add(idtf);

        name = new JLabel("Name");
        name.setBounds(20, 120, 100, 30);
        name.setFont(font);
        c.add(name);

        nametf = new JTextField();
        nametf.setBounds(180, 120, 150, 30);
        nametf.setFont(font);
        c.add(nametf);

        ip = new JLabel("IP Address");
        ip.setBounds(20, 160, 100, 30);
        ip.setFont(font);
        c.add(ip);

        iptf = new JTextField();
        iptf.setBounds(180, 160, 150, 30);
        iptf.setFont(font);
        c.add(iptf);

        net = new JLabel("Ethernet");
        net.setBounds(20, 200, 100, 30);
        net.setFont(font);
        c.add(net);

        nettf = new JTextField();
        nettf.setBounds(180, 200, 150, 30);
        nettf.setFont(font);
        c.add(nettf);

        price = new JLabel("Price");
        price.setBounds(20, 240, 100, 30);
        price.setFont(font);
        c.add(price);

        pricetf = new JTextField();
        pricetf.setBounds(180, 240, 150, 30);
        pricetf.setFont(font);
        c.add(pricetf);

        add = new JButton("ADD");
        add.setBounds(100, 300, 120, 30);
        add.setFont(font);
        c.add(add);

        update = new JButton("Update");
        update.setBounds(250, 300, 120, 30);
        update.setFont(font);
        c.add(update);

        delete = new JButton("Delete");
        delete.setBounds(400, 300, 120, 30);
        delete.setFont(font);
        c.add(delete);

        refresh = new JButton("Refresh");
        refresh.setBounds(400, 80, 120, 30);
        refresh.setFont(font);
        c.add(refresh);

        bk = new JButton("Back");
        bk.setBackground(new java.awt.Color(255, 255, 255));
        bk.setFont(new java.awt.Font("Trebuchet MS", 1, 25));
        bk.setBounds(260, 660, 100, 30);
        bk.addActionListener(this);

        add(bk);

        //             Table   
        table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(col);
        table.setModel(model);
        table.setFont(font);
        table.setSelectionBackground(Color.yellow);
        table.setBackground(Color.WHITE);
        table.setRowHeight(30);

        scroll = new JScrollPane(table);
        scroll.setBounds(10, 360, 665, 260);
        c.add(scroll);

        //               Action   call 
        add.addActionListener(this);
        update.addActionListener(this);
        delete.addActionListener(this);
        refresh.addActionListener(this);

        table.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {

                int rowNumber = table.getSelectedRow();

                String me_id = model.getValueAt(rowNumber, 0).toString();
                String me_name = model.getValueAt(rowNumber, 1).toString();
                String me_ip = model.getValueAt(rowNumber, 2).toString();
                String me_net = model.getValueAt(rowNumber, 3).toString();
                String me_price = model.getValueAt(rowNumber, 4).toString();

                idtf.setText(me_id);
                nametf.setText(me_name);
                iptf.setText(me_ip);
                nettf.setText(me_net);
                pricetf.setText(me_price);

            }
        });

    }

    void clearall() {
        idtf.setText("");
        nametf.setText("");
        iptf.setText("");
        nettf.setText("");
        pricetf.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent a) {

        //add
        if (a.getSource() == add) {

            row[0] = idtf.getText();
            row[1] = nametf.getText();
            row[2] = iptf.getText();
            row[3] = nettf.getText();
            row[4] = pricetf.getText();

            model.addRow(row);
            JOptionPane.showMessageDialog(null, "user successfully added");
            clearall();

        } //delete
        else if (a.getSource() == delete) {

            int rowNumber = table.getSelectedRow();

            if (rowNumber >= 0) {
                int show = JOptionPane.showConfirmDialog(null, "are you sure you want to remove \n" + nametf.getText());
                if (show == JOptionPane.YES_OPTION) {
                    model.removeRow(rowNumber);
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
                clearall();
            } else {
                JOptionPane.showMessageDialog(null, "no Row has been seleted or no Row has been exits");
            }
        } //update
        else if (a.getSource() == update) {

            int rowNumber = table.getSelectedRow();

            if (rowNumber >= 0) {
                int show = JOptionPane.showConfirmDialog(null, "are you sure you want to update \n" + nametf.getText());
                if (show == JOptionPane.YES_OPTION) {
                    String m_id = idtf.getText();
                    String m_name = nametf.getText();
                    String m_ip = iptf.getText();
                    String m_net = nettf.getText();
                    String m_price = pricetf.getText();

                    model.setValueAt(m_id, rowNumber, 0);
                    model.setValueAt(m_name, rowNumber, 1);
                    model.setValueAt(m_ip, rowNumber, 2);
                    model.setValueAt(m_net, rowNumber, 3);
                    model.setValueAt(m_price, rowNumber, 4);

                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
                clearall();

            }

        } else if (a.getSource() == refresh) {
        } else if (a.getSource() == bk) {
            try {
                setVisible(false);
                new LoginPage();

            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

        try {
            File file = new File("data.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    bw.write((String) model.getValueAt(i, j) + " ");

                }
            }
            bw.close();
            fw.close();

        } catch (IOException x) {
            System.out.println(x);

        }

    }

}
