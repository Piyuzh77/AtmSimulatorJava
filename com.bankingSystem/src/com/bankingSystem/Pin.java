package com.bankingSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pin extends JFrame implements ActionListener {
    
    JPasswordField newPasswordField, reenterPasswordField;
    JButton changeButton, backButton;                               
    JLabel changePinLabel, newPinLabel, reenterPinLabel;
    String pin;

    Pin(String pin){
        this.pin = pin;
        ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("com/bankingSystem/icons/atm.jpg"));
        Image backgroundImage = backgroundIcon.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon scaledBackgroundIcon = new ImageIcon(backgroundImage);
        JLabel backgroundLabel = new JLabel(scaledBackgroundIcon);
        backgroundLabel.setBounds(0, 0, 960, 1080);
        add(backgroundLabel);
        
        changePinLabel = new JLabel("CHANGE YOUR PIN");
        changePinLabel.setFont(new Font("System", Font.BOLD, 16));
        changePinLabel.setForeground(Color.WHITE);
        
        newPinLabel = new JLabel("New PIN:");
        newPinLabel.setFont(new Font("System", Font.BOLD, 16));
        newPinLabel.setForeground(Color.WHITE);
        
        reenterPinLabel = new JLabel("Re-Enter New PIN:");
        reenterPinLabel.setFont(new Font("System", Font.BOLD, 16));
        reenterPinLabel.setForeground(Color.WHITE);
        
        newPasswordField = new JPasswordField();
        newPasswordField.setFont(new Font("Raleway", Font.BOLD, 25));
        
        reenterPasswordField = new JPasswordField();
        reenterPasswordField.setFont(new Font("Raleway", Font.BOLD, 25));
        
        changeButton = new JButton("CHANGE");
        backButton = new JButton("BACK");
        
        changeButton.addActionListener(this);
        backButton.addActionListener(this);
        
        setLayout(null);
        
        changePinLabel.setBounds(280, 330, 800, 35);
        backgroundLabel.add(changePinLabel);
        
        newPinLabel.setBounds(180, 390, 150, 35);
        backgroundLabel.add(newPinLabel);
        
        reenterPinLabel.setBounds(180, 440, 200, 35);
        backgroundLabel.add(reenterPinLabel);
        
        newPasswordField.setBounds(350, 390, 180, 25);
        backgroundLabel.add(newPasswordField);
        
        reenterPasswordField.setBounds(350, 440, 180, 25);
        backgroundLabel.add(reenterPasswordField);
        
        changeButton.setBounds(390, 588, 150, 35);
        backgroundLabel.add(changeButton);
        
        backButton.setBounds(390, 633, 150, 35);
        backgroundLabel.add(backButton);
        
        setSize(960, 1080);
        setLocation(500, 0);
        setUndecorated(true);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        try {
            String newPassword = newPasswordField.getText();
            String reenteredPassword = reenterPasswordField.getText();
            
            if (!newPassword.equals(reenteredPassword)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            
            if (ae.getSource() == changeButton) {
                if (newPasswordField.getPassword().equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                }
                if (reenterPasswordField.getPassword().equals("")) {
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                }
                
                Conn connection = new Conn();
                String updateBankQuery = "update bank set pin = '"+reenteredPassword+"' where pin = '"+pin+"' ";
                String updateLoginQuery = "update login set pin = '"+reenteredPassword+"' where pin = '"+pin+"' ";
                String updateSignupQuery = "update signup3 set pin = '"+reenteredPassword+"' where pin = '"+pin+"' ";

                connection.st.executeUpdate(updateBankQuery);
                connection.st.executeUpdate(updateLoginQuery);
                connection.st.executeUpdate(updateSignupQuery);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(reenteredPassword).setVisible(true);
            
            } else if (ae.getSource() == backButton) {
                new Transactions(pin).setVisible(true);
                setVisible(false);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Pin("").setVisible(true);
    }
}
