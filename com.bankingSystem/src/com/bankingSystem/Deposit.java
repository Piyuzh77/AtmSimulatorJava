package com.bankingSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField amountField;
    JButton depositButton, backButton;
    JLabel depositLabel;
    String pin;
    
    Deposit(String pin){
        this.pin = pin;
        
        ImageIcon atmIcon = new ImageIcon(ClassLoader.getSystemResource("com/bankingSystem/icons/atm.jpg"));
        Image scaledImage = atmIcon.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel(scaledIcon);
        backgroundLabel.setBounds(0, 0, 960, 1080);
        add(backgroundLabel);
        
        depositLabel = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        depositLabel.setForeground(Color.WHITE);
        depositLabel.setFont(new Font("System", Font.BOLD, 16));
        
        amountField = new JTextField();
        amountField.setFont(new Font("Raleway", Font.BOLD, 22));
        
        depositButton = new JButton("DEPOSIT");
        backButton = new JButton("BACK");
        
        setLayout(null);
        
        depositLabel.setBounds(190, 350, 400, 35);
        backgroundLabel.add(depositLabel);
        
        amountField.setBounds(190, 420, 320, 25);
        backgroundLabel.add(amountField);
        
        depositButton.setBounds(390, 588, 150, 35);
        backgroundLabel.add(depositButton);
        
        backButton.setBounds(390, 633, 150, 35);
        backgroundLabel.add(backButton);
        
        depositButton.addActionListener(this);
        backButton.addActionListener(this);
        
        setSize(960, 1080);
        setUndecorated(true);
        setLocation(500, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try {        
            String amount = amountField.getText();
            Date date = new Date();
            
            if(ae.getSource() == depositButton){
                if(amountField.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit.");
                } else {
                    Conn connection = new Conn();
                    connection.st.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Deposit', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            } else if(ae.getSource() == backButton){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new Deposit("").setVisible(true);
    }
}
