package com.bankingSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{
    String BankName=null;
    void setBankName(String name){
            BankName=name;
        }
    public String getBankName(){
        return BankName;
    }

    JButton SignIn, SignUp, Reset;
    JTextField cardTxtFld;
    JPasswordField pinTxtFld;

    Login(){
        setLayout(null);
        
        ImageIcon logo= new ImageIcon(ClassLoader.getSystemClassLoader().getResource("com/bankingSystem/icons/logo.jpg"));
        Image logoSc= logo.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon logof= new ImageIcon(logoSc);
        JLabel label= new JLabel(logof);
        label.setBounds(20,10,100,100);
        add(label);

        JLabel text= new JLabel("Welcome to Atm");
        text.setFont(new Font("Montserrat", Font.BOLD, 38));
        text.setBounds(120,45,600,40);
        add(text);

        JLabel CardNo= new JLabel("Card No:");
        CardNo.setForeground(Color.decode("#1C1C84"));
        CardNo.setFont(new Font("Montserrat", Font.BOLD,28));
        CardNo.setBounds(100,150,150,40);
        add(CardNo);
        cardTxtFld= new JTextField();
        cardTxtFld.setBounds(230, 157, 200, 33);
        add(cardTxtFld);

        JLabel Pin= new JLabel("PIN:");
        Pin.setForeground(Color.decode("#1C1C84"));
        Pin.setFont(new Font("Montserrat", Font.BOLD,28));
        Pin.setBounds(100,200,100,40);
        add(Pin);
        pinTxtFld= new JPasswordField();
        pinTxtFld.setBounds(230, 207, 200, 33);
        add(pinTxtFld);

        SignIn= new JButton("Sign In");
        SignIn.setBounds(230,255,80,30);
        SignIn.setBackground(Color.GRAY); 
        SignIn.setForeground(Color.white);
        SignIn.addActionListener(this); 
        add(SignIn);

        Reset= new JButton("Reset");
        Reset.setBounds(350,255,80,30);
        Reset.setBackground(Color.GRAY); 
        Reset.setForeground(Color.white);
        Reset.addActionListener(this); 
        add(Reset);

        SignUp= new JButton("Sign UP");
        SignUp.setBounds(230,300,200,30);
        SignUp.setBackground(Color.GRAY); 
        SignUp.setForeground(Color.white);
        SignUp.addActionListener(this); 
        add(SignUp);

        setResizable(false);
        setTitle("Automatic Teller Machine");
        setSize(720,480);
        setVisible(true);
        setLocation(350,200);
        getContentPane().setBackground(Color.WHITE);

    }
    public static void main(String[] args) throws Exception {
        new Login();
        // new Login().setBankName("GL Bank");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Reset){
            cardTxtFld.setText(null);
            pinTxtFld.setText(null);
        }else if(e.getSource()==SignIn){
                Conn c1 = new Conn();
                String cardno  = cardTxtFld.getText();
                String pin  = pinTxtFld.getText();
                String q  = "select * from login where cardno = '"+cardno+"' and pin = '"+pin+"'";

                try (ResultSet rs = c1.st.executeQuery(q)) {
                    if(rs.next()){
                        setVisible(false);
                        new Transactions(pin).setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                    }
                } catch (HeadlessException | SQLException e1) {
                    // TODO Auto-generated catch block
                    System.out.println(" something went wrong!!");
                    e1.printStackTrace();
                }

        }
        else if(e.getSource()==SignUp){new SignUpOne();
        setVisible(false);}
    }
}
