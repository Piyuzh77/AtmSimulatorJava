package com.bankingSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.sql.*;

class Withdrawal extends JFrame implements ActionListener {
    
    JTextField withdrawalField;
    JButton withdrawButton, backButton;
    JLabel maxWithdrawalLabel, enterammountLabel;
    String pin;

    Withdrawal(String pin){
        this.pin = pin;
        
        ImageIcon atmIcon = new ImageIcon(ClassLoader.getSystemResource("com/bankingSystem/icons/atm.jpg"));
        Image scaledImage = atmIcon.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel(scaledIcon);
        backgroundLabel.setBounds(0, 0, 960, 1080);
        add(backgroundLabel);
        
        maxWithdrawalLabel = new JLabel("MAXIMUM WITHDRAWAL IS RS.10,000");
        maxWithdrawalLabel.setForeground(Color.WHITE);
        maxWithdrawalLabel.setFont(new Font("System", Font.BOLD, 16));
        
        enterammountLabel = new JLabel("PLEASE ENTER YOUR ammount");
        enterammountLabel.setForeground(Color.WHITE);
        enterammountLabel.setFont(new Font("System", Font.BOLD, 16));
        
        withdrawalField = new JTextField();
        withdrawalField.setFont(new Font("Raleway", Font.BOLD, 25));
        
        withdrawButton = new JButton("WITHDRAW");
        backButton = new JButton("BACK");
        
        setLayout(null);
        
        maxWithdrawalLabel.setBounds(190, 350, 400, 20);
        backgroundLabel.add(maxWithdrawalLabel);
        
        enterammountLabel.setBounds(190, 400, 400, 20);
        backgroundLabel.add(enterammountLabel);
        
        withdrawalField.setBounds(190, 450, 330, 30);
        backgroundLabel.add(withdrawalField);
        
        withdrawButton.setBounds(390, 588, 150, 35);
        backgroundLabel.add(withdrawButton);
        
        backButton.setBounds(390, 633, 150, 35);
        backgroundLabel.add(backButton);
        
        withdrawButton.addActionListener(this);
        backButton.addActionListener(this);
        
        setSize(960, 1080);
        setLocation(500, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try {        
            String ammount = withdrawalField.getText();
            Date date = new Date();
            
            if(ae.getSource() == withdrawButton){
                if(withdrawalField.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the ammount you want to withdraw");
                } else {
                    Conn connection = new Conn();
                    ResultSet rs = connection.st.executeQuery("select * from bank where pin = '"+pin+"'");
                    int balance = 0;
                    while(rs.next()){
                        if(rs.getString("mode").equals("Deposit")){
                            balance += Integer.parseInt(rs.getString("ammount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("ammount"));
                        }
                    }
                    
                    if(balance < Integer.parseInt(ammount)){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    
                    connection.st.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawal', '"+ammount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+ammount+" Debited Successfully");
                    
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            } else if(ae.getSource() == backButton){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("error: "+e);
        }
    }
    
    public static void main(String[] args){
        new Withdrawal("").setVisible(true);
    }
}