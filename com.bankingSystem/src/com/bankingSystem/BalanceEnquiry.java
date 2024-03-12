package com.bankingSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JLabel balanceLabel;
    JButton backButton;
    String pin;

    BalanceEnquiry(String pin) {
        this.pin = pin;

        ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("com/bankingSystem/icons/atm.jpg"));
        Image backgroundImage = backgroundIcon.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon scaledBackgroundIcon = new ImageIcon(backgroundImage);
        JLabel backgroundLabel = new JLabel(scaledBackgroundIcon);
        backgroundLabel.setBounds(0, 0, 960, 1080);
        add(backgroundLabel);

        balanceLabel = new JLabel();
        balanceLabel.setForeground(Color.WHITE);
        balanceLabel.setFont(new Font("System", Font.BOLD, 16));

        backButton = new JButton("BACK");

        setLayout(null);

        balanceLabel.setBounds(190, 350, 400, 35);
        backgroundLabel.add(balanceLabel);

        backButton.setBounds(390, 633, 150, 35);
        backgroundLabel.add(backButton);
        
        int balance = calculateBalance();

        balanceLabel.setText("Your Current Account Balance is Rs " + balance);

        backButton.addActionListener(this);

        setSize(960, 900);
        setUndecorated(true);
        setLocation(500, 0);
        setVisible(true);
    }

    private int calculateBalance() {
        int balance = 0;
        try {
            Conn connection = new Conn();
            ResultSet resultSet = connection.st.executeQuery("select * from bank where pin = '" + pin + "'");
            while (resultSet.next()) {
                if (resultSet.getString("mode").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("ammount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("ammount"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return balance;
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}
