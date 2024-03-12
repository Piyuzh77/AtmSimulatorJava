package com.bankingSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JLabel selectammountLabel;
    JButton hundredButton, fiveHundredButton, thousandButton, twoThousandButton, fiveThousandButton, tenThousandButton, backButton;
    JTextField ammountField;
    String pin;

    FastCash(String pin) {
        this.pin = pin;
        
        ImageIcon atmIcon = new ImageIcon(ClassLoader.getSystemResource("com/bankingSystem/icons/atm.jpg"));
        Image scaledImage = atmIcon.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel(scaledIcon);
        backgroundLabel.setBounds(0, 0, 960, 1080);
        add(backgroundLabel);

        selectammountLabel = new JLabel("SELECT WITHDRAWAL ammount");
        selectammountLabel.setForeground(Color.WHITE);
        selectammountLabel.setFont(new Font("System", Font.BOLD, 16));

        hundredButton = new JButton("Rs 100");
        fiveHundredButton = new JButton("Rs 500");
        thousandButton = new JButton("Rs 1000");
        twoThousandButton = new JButton("Rs 2000");
        fiveThousandButton = new JButton("Rs 5000");
        tenThousandButton = new JButton("Rs 10000");
        backButton = new JButton("BACK");

        setLayout(null);

        selectammountLabel.setBounds(235, 400, 700, 35);
        backgroundLabel.add(selectammountLabel);

        hundredButton.setBounds(170, 499, 150, 35);
        backgroundLabel.add(hundredButton);

        fiveHundredButton.setBounds(390, 499, 150, 35);
        backgroundLabel.add(fiveHundredButton);

        thousandButton.setBounds(170, 543, 150, 35);
        backgroundLabel.add(thousandButton);

        twoThousandButton.setBounds(390, 543, 150, 35);
        backgroundLabel.add(twoThousandButton);

        fiveThousandButton.setBounds(170, 588, 150, 35);
        backgroundLabel.add(fiveThousandButton);

        tenThousandButton.setBounds(390, 588, 150, 35);
        backgroundLabel.add(tenThousandButton);

        backButton.setBounds(390, 633, 150, 35);
        backgroundLabel.add(backButton);

        hundredButton.addActionListener(this);
        fiveHundredButton.addActionListener(this);
        thousandButton.addActionListener(this);
        twoThousandButton.addActionListener(this);
        fiveThousandButton.addActionListener(this);
        tenThousandButton.addActionListener(this);
        backButton.addActionListener(this);

        setSize(960, 1080);
        setLocation(500, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String ammount = ((JButton)ae.getSource()).getText().substring(3);
            Conn connection = new Conn();
            ResultSet rs = connection.st.executeQuery("select * from bank where pin = '"+pin+"'");
            int balance = 0;
            
            while (rs.next()) {
                if (rs.getString("mode").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("ammount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("ammount"));
                }
            }
            
            if (ae.getSource() != backButton && balance < Integer.parseInt(ammount)) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }

            if (ae.getSource() == backButton) {
                this.setVisible(false);
                new Transactions(pin).setVisible(true);
            } else {
                Date date = new Date();
                connection.st.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawal', '"+ammount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+ammount+" Debited Successfully");
                    
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FastCash("").setVisible(true);
    }
}
