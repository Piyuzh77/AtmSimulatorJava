package com.bankingSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Transactions extends JFrame implements ActionListener {

    JLabel transactionLabel;
    JButton depositButton, withdrawButton, fastCashButton, miniStatementButton, pinChangeButton, balanceEnquiryButton, exitButton;
    String pin;

    Transactions(String pin) {
        this.pin = pin;

        ImageIcon atmIcon = new ImageIcon(ClassLoader.getSystemResource("com/bankingSystem/icons/atm.jpg"));
        Image scaledImage = atmIcon.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel(scaledIcon);
        backgroundLabel.setBounds(0, 0, 960, 1080);
        add(backgroundLabel);

        transactionLabel = new JLabel("Please Select Your Transaction");
        transactionLabel.setForeground(Color.WHITE);
        transactionLabel.setFont(new Font("System", Font.BOLD, 16));

        depositButton = new JButton("DEPOSIT");
        withdrawButton = new JButton("CASH WITHDRAWAL");
        fastCashButton = new JButton("FAST CASH");
        miniStatementButton = new JButton("MINI STATEMENT");
        pinChangeButton = new JButton("PIN CHANGE");
        balanceEnquiryButton = new JButton("BALANCE ENQUIRY");
        exitButton = new JButton("EXIT");

        setLayout(null);

        transactionLabel.setBounds(235, 400, 700, 35);
        backgroundLabel.add(transactionLabel);

        depositButton.setBounds(170, 499, 150, 35);
        backgroundLabel.add(depositButton);

        withdrawButton.setBounds(390, 499, 150, 35);
        backgroundLabel.add(withdrawButton);

        fastCashButton.setBounds(170, 543, 150, 35);
        backgroundLabel.add(fastCashButton);

        miniStatementButton.setBounds(390, 543, 150, 35);
        backgroundLabel.add(miniStatementButton);

        pinChangeButton.setBounds(170, 588, 150, 35);
        backgroundLabel.add(pinChangeButton);

        balanceEnquiryButton.setBounds(390, 588, 150, 35);
        backgroundLabel.add(balanceEnquiryButton);

        exitButton.setBounds(390, 633, 150, 35);
        backgroundLabel.add(exitButton);

        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);
        fastCashButton.addActionListener(this);
        miniStatementButton.addActionListener(this);
        pinChangeButton.addActionListener(this);
        balanceEnquiryButton.addActionListener(this);
        exitButton.addActionListener(this);

        setSize(960, 1080);
        setLocation(500, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == depositButton) {
            setVisible(false);
            new Deposit(pin).setVisible(true);
        } else if (ae.getSource() == withdrawButton) {
            setVisible(false);
            new Withdrawal(pin).setVisible(true);
        } else if (ae.getSource() == fastCashButton) {
            setVisible(false);
            new FastCash(pin).setVisible(true);
        } else if (ae.getSource() == miniStatementButton) {
            new MiniStatement(pin).setVisible(true);
        } else if (ae.getSource() == pinChangeButton) {
            setVisible(false);
            new Pin(pin).setVisible(true);
        } else if (ae.getSource() == balanceEnquiryButton) {
            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        } else if (ae.getSource() == exitButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Transactions("").setVisible(true);
    }
}
