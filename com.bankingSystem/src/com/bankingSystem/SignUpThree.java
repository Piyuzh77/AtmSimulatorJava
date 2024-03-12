
package com.bankingSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class SignUpThree extends JFrame implements ActionListener{
    
    JLabel l1,accountTypeLabel,cardNumberLabel,cardNumberDisplay,cardNumberInfo,cardNumberDescription,pinLabel,pinDisplay,pinInfo,servicesRequiredLabel,formNumberLabel,formNumberDisplay;
    JRadioButton savingAccountRadioButton,fixedDepositAccountRadioButton,currentAccountRadioButton,recurringDepositAccountRadioButton;
    JButton submitButton,cancelButton;
    JCheckBox atmCardCheckbox,c2,mobileBankingCheckbox,emailAlertsCheckbox,chequeBookCheckbox,eStatementCheckbox,declarationCheckbox;
    String formno;


    SignUpThree(String formno){
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
    
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/bankingSystem/icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l14 = new JLabel(i3);
        l14.setBounds(150, 0, 100, 100);
        add(l14);
        
        l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        accountTypeLabel = new JLabel("Account Type:");
        accountTypeLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        
        cardNumberLabel = new JLabel("Card Number:");
        cardNumberLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        
        cardNumberDisplay = new JLabel("XXXX-XXXX-XXXX-4184");
        cardNumberDisplay.setFont(new Font("Raleway", Font.BOLD, 18));
        
        cardNumberInfo = new JLabel("(Your 16-digit Card number)");
        cardNumberInfo.setFont(new Font("Raleway", Font.BOLD, 12));
        
        cardNumberDescription = new JLabel("It would appear on ATM Card/Cheque Book and Statements");
        cardNumberDescription.setFont(new Font("Raleway", Font.BOLD, 12));
        
        pinLabel = new JLabel("PIN:");
        pinLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        
        pinDisplay = new JLabel("XXXX");
        pinDisplay.setFont(new Font("Raleway", Font.BOLD, 18));
    
        pinInfo = new JLabel("(4-digit password)");
        pinInfo.setFont(new Font("Raleway", Font.BOLD, 12));
    
        servicesRequiredLabel = new JLabel("Services Required:");
        servicesRequiredLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        
        formNumberLabel = new JLabel("Form No:");
        formNumberLabel.setFont(new Font("Raleway", Font.BOLD, 14));
        
        formNumberDisplay = new JLabel(formno);
        formNumberDisplay.setFont(new Font("Raleway", Font.BOLD, 14));
        
        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Raleway", Font.BOLD, 14));
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        
        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Raleway", Font.BOLD, 14));
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        
        
        atmCardCheckbox = new JCheckBox("ATM CARD");
        atmCardCheckbox.setBackground(Color.WHITE);
        atmCardCheckbox.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        
        mobileBankingCheckbox = new JCheckBox("Mobile Banking");
        mobileBankingCheckbox.setBackground(Color.WHITE);
        mobileBankingCheckbox.setFont(new Font("Raleway", Font.BOLD, 16));
        
        emailAlertsCheckbox = new JCheckBox("EMAIL Alerts");
        emailAlertsCheckbox.setBackground(Color.WHITE);
        emailAlertsCheckbox.setFont(new Font("Raleway", Font.BOLD, 16));
        
        chequeBookCheckbox = new JCheckBox("Cheque Book");
        chequeBookCheckbox.setBackground(Color.WHITE);
        chequeBookCheckbox.setFont(new Font("Raleway", Font.BOLD, 16));
        
        eStatementCheckbox = new JCheckBox("E-Statement");
        eStatementCheckbox.setBackground(Color.WHITE);
        eStatementCheckbox.setFont(new Font("Raleway", Font.BOLD, 16));
        
        declarationCheckbox = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.",true);
        declarationCheckbox.setBackground(Color.WHITE);
        declarationCheckbox.setFont(new Font("Raleway", Font.BOLD, 12));
         
        
        savingAccountRadioButton = new JRadioButton("Saving Account");
        savingAccountRadioButton.setFont(new Font("Raleway", Font.BOLD, 16));
        savingAccountRadioButton.setBackground(Color.WHITE);
        
        fixedDepositAccountRadioButton = new JRadioButton("Fixed Deposit Account");
        fixedDepositAccountRadioButton.setFont(new Font("Raleway", Font.BOLD, 16));
        fixedDepositAccountRadioButton.setBackground(Color.WHITE);
        
        currentAccountRadioButton = new JRadioButton("Current Account");
        currentAccountRadioButton.setFont(new Font("Raleway", Font.BOLD, 16));
        currentAccountRadioButton.setBackground(Color.WHITE);
        
        recurringDepositAccountRadioButton = new JRadioButton("Recurring Deposit Account");
        recurringDepositAccountRadioButton.setFont(new Font("Raleway", Font.BOLD, 16));
        recurringDepositAccountRadioButton.setBackground(Color.WHITE);
        
        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(savingAccountRadioButton);
        groupgender.add(fixedDepositAccountRadioButton);
        groupgender.add(currentAccountRadioButton);
        groupgender.add(recurringDepositAccountRadioButton);
        
        setLayout(null);
        
        formNumberLabel.setBounds(700,10,70,30);
        add(formNumberLabel);
        
        formNumberDisplay.setBounds(770,10,40,30);
        add(formNumberDisplay);
        
        l1.setBounds(280,40,400,40);
        add(l1); 
        
        accountTypeLabel.setBounds(100,140,200,30);
        add(accountTypeLabel);
        
        savingAccountRadioButton.setBounds(100,180,150,30);
        add(savingAccountRadioButton);
        
        fixedDepositAccountRadioButton.setBounds(350,180,300,30);
        add(fixedDepositAccountRadioButton);
        
        currentAccountRadioButton.setBounds(100,220,250,30);
        add(currentAccountRadioButton);
        
        recurringDepositAccountRadioButton.setBounds(350,220,250,30);
        add(recurringDepositAccountRadioButton);
        
        cardNumberLabel.setBounds(100,300,200,30);
        add(cardNumberLabel);
        
        cardNumberDisplay.setBounds(330,300,250,30);
        add(cardNumberDisplay);
        
        cardNumberInfo.setBounds(100,330,200,20);
        add(cardNumberInfo);
        
        cardNumberDescription.setBounds(330,330,500,20);
        add(cardNumberDescription);
        
        pinLabel.setBounds(100,370,200,30);
        add(pinLabel);
        
        pinDisplay.setBounds(330,370,200,30);
        add(pinDisplay);
        
        pinInfo.setBounds(100,400,200,20);
        add(pinInfo);
        
        servicesRequiredLabel.setBounds(100,450,200,30);
        add(servicesRequiredLabel);
        
        atmCardCheckbox.setBounds(100,500,200,30);
        add(atmCardCheckbox);
        
        c2.setBounds(350,500,200,30);
        add(c2);
        
        mobileBankingCheckbox.setBounds(100,550,200,30);
        add(mobileBankingCheckbox);
        
        emailAlertsCheckbox.setBounds(350,550,200,30);
        add(emailAlertsCheckbox);
        
        chequeBookCheckbox.setBounds(100,600,200,30);
        add(chequeBookCheckbox);
        
        eStatementCheckbox.setBounds(350,600,200,30);
        add(eStatementCheckbox);
        
        declarationCheckbox.setBounds(100,680,600,20);
        add(declarationCheckbox);
        
        submitButton.setBounds(250,720,100,30);
        add(submitButton);
        
        cancelButton.setBounds(420,720,100,30);
        add(cancelButton);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,850);
        setLocation(500,120);
        setVisible(true);
        
        submitButton.addActionListener(this);
        cancelButton.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String atype = null;
        if(savingAccountRadioButton.isSelected()){ 
            atype = "Saving Account";
        }
        else if(fixedDepositAccountRadioButton.isSelected()){ 
            atype = "Fixed Deposit Account";
        }
        else if(currentAccountRadioButton.isSelected()){ 
            atype = "Current Account";
        }else if(recurringDepositAccountRadioButton.isSelected()){ 
            atype = "Recurring Deposit Account";
        }
        
        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
        String cardno = "" + Math.abs(first7);
        
        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);
        
        String facility = "";
        if(atmCardCheckbox.isSelected()){ 
            facility = facility + " ATM Card";
        }
        if(c2.isSelected()){ 
            facility = facility + " Internet Banking";
        }
        if(mobileBankingCheckbox.isSelected()){ 
            facility = facility + " Mobile Banking";
        }
        if(emailAlertsCheckbox.isSelected()){ 
            facility = facility + " EMAIL Alerts";
        }
        if(chequeBookCheckbox.isSelected()){ 
            facility = facility + " Cheque Book";
        }
        if(eStatementCheckbox.isSelected()){ 
            facility = facility + " E-Statement";
        }
        
        try{
            if(ae.getSource()==submitButton){
                
                if(atype.equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                }else{
                    Conn atmCardCheckbox = new Conn();
                    String q1 = "insert into signup3 values('"+formno+"','"+atype+"','"+cardno+"','"+pin+"','"+facility+"')";  
                    String q2 = "insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
                    atmCardCheckbox.st.executeUpdate(q1);
                    atmCardCheckbox.st.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n Pin:"+ pin);
                    
                    new Deposit(pin).setVisible(true);
                    setVisible(false);
                }
            
            }else if(ae.getSource()==cancelButton){
                System.exit(0);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    
    public static void main(String[] args){
        new SignUpThree("").setVisible(true);
    }
    
}