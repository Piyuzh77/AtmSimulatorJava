package com.bankingSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;

public class SignUpOne extends JFrame implements ActionListener {

    private boolean isValidEmail(String email) {
        String emailGenEx = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+.[A-Za-z0-9.-]$";
        return email.matches(emailGenEx);
    }
    JTextField nameTextField, fathersNameTextFld, emailField, phNoField, addressTextFld, cityTextFld, stateTextFld,
            pincodeTextFld;
    JRadioButton male, female, G_others, married, unmarried, M_other;
    JButton next;
    static JDateChooser jd;
    long random;

    SignUpOne() {
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        setLayout(null);

        JLabel formNum = new JLabel("Your form Number:" + random);
        formNum.setBounds(500, 30, 150, 40);
        add(formNum);

        JLabel heading = new JLabel("Page 1: Personal Info");
        heading.setBounds(210, 30, 300, 40);
        heading.setFont(new Font("Ariel", Font.BOLD, 28));
        add(heading);

        JLabel name = new JLabel("Name:");
        name.setBounds(100, 90, 100, 20);
        name.setFont(new Font("Ariel", Font.BOLD, 18));
        add(name);
        nameTextField = new JTextField();
        nameTextField.setBounds(300, 90, 300, 25);
        add(nameTextField);

        JLabel fatehrsName = new JLabel("Father Name:");
        fatehrsName.setBounds(100, 135, 200, 20);
        fatehrsName.setFont(new Font("Ariel", Font.BOLD, 18));
        add(fatehrsName);
        fathersNameTextFld = new JTextField();
        fathersNameTextFld.setBounds(300, 135, 300, 25);
        add(fathersNameTextFld);

        JLabel email = new JLabel("Email:");
        email.setBounds(100, 175, 150, 20);
        email.setFont(new Font("Ariel", Font.BOLD, 18));
        add(email);
        emailField = new JTextField();
        emailField.setBounds(300, 175, 300, 25);
        add(emailField);
        JButton validate = new JButton("Validate Email");
        validate.setBounds(380, 220, 120, 20);
        validate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                if (!isValidEmail(email)) {
                    JOptionPane.showMessageDialog(SignUpOne.this, "Invalid email!","Error",JOptionPane.ERROR_MESSAGE);
                    emailField.setText(null);
                }
                else{JOptionPane.showMessageDialog(SignUpOne.this, "Email verified successfully","Done",JOptionPane.PLAIN_MESSAGE);}
            }
        });
        add(validate);
        JLabel gender = new JLabel("Gender:");
        gender.setBounds(100, 250, 150, 20);
        gender.setFont(new Font("Ariel", Font.BOLD, 18));
        add(gender);
        male = new JRadioButton("Male");
        male.setBounds(300, 250, 80, 25);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(420, 250, 88, 25);
        add(female);
        G_others = new JRadioButton("Others");
        G_others.setBounds(540, 250, 80, 25);
        add(G_others);
        ButtonGroup BG = new ButtonGroup();
        BG.add(G_others);
        BG.add(male);
        BG.add(female);

        JLabel phNo = new JLabel("Phone number:");
        phNo.setBounds(100, 300, 200, 20);
        phNo.setFont(new Font("Ariel", Font.BOLD, 18));
        add(phNo);
        phNoField = new JTextField(15);
        phNoField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if (!Character.isDigit(input) && input != KeyEvent.VK_BACK_SPACE && input != KeyEvent.VK_DELETE) {
                    e.consume();
                }
            }
        });
        phNoField.setBounds(300, 300, 300, 25);
        add(phNoField);

        JLabel maritalStatus = new JLabel("Marital Status:");
        maritalStatus.setBounds(100, 350, 150, 20);
        maritalStatus.setFont(new Font("Ariel", Font.BOLD, 18));
        add(maritalStatus);
        married = new JRadioButton("Married");
        married.setBounds(300, 350, 80, 25);
        add(married);
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(420, 350, 88, 25);
        add(unmarried);
        M_other = new JRadioButton("Other");
        M_other.setBounds(540, 350, 88, 25);
        add(M_other);
        ButtonGroup MS = new ButtonGroup();
        MS.add(married);
        MS.add(unmarried);
        MS.add(M_other);

        JLabel address = new JLabel("Address:");
        address.setBounds(100, 400, 200, 20);
        address.setFont(new Font("Ariel", Font.BOLD, 18));
        add(address);
        addressTextFld = new JTextField();
        addressTextFld.setBounds(300, 400, 300, 25);
        add(addressTextFld);

        JLabel city = new JLabel("City:");
        city.setBounds(100, 440, 200, 20);
        city.setFont(new Font("Ariel", Font.BOLD, 18));
        add(city);
        cityTextFld = new JTextField();
        cityTextFld.setBounds(300, 440, 300, 25);
        add(cityTextFld);

        JLabel state = new JLabel("State:");
        state.setBounds(100, 480, 200, 20);
        state.setFont(new Font("Ariel", Font.BOLD, 18));
        add(state);
        stateTextFld = new JTextField();
        stateTextFld.setBounds(300, 480, 300, 25);
        add(stateTextFld);

        JLabel pincode = new JLabel("Pin Code");
        pincode.setBounds(100, 520, 200, 20);
        pincode.setFont(new Font("Ariel", Font.BOLD, 18));
        add(pincode);
        pincodeTextFld = new JTextField();
        pincodeTextFld.setBounds(300, 520, 300, 25);
        add(pincodeTextFld);

        next = new JButton("Next");
        new Color(0);
        next.setBounds(300, 650, 100, 50);
        next.setFont(new Font("Montserrat", Font.CENTER_BASELINE, 25));
        next.addActionListener(this);
        add(next);

        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(100, 580, 200, 20);
        dob.setFont(new Font("Ariel", Font.BOLD, 18));
        add(dob);
        jd = new JDateChooser();
        jd.setBounds(300, 580, 300, 30);
        add(jd);

        System.out.println(nameTextField.getText());
        setSize(720, 800);
        setLocation(300, 20);
        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) {
        new SignUpOne();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            String formNo = "" + random;
            String name = nameTextField.getText();
            String fName = fathersNameTextFld.getText();
            String dob = ((JTextField) jd.getDateEditor().getUiComponent()).getText();
            String gender = null;
            if (male.isSelected())
                gender = "Male";
            else if (female.isSelected())
                gender = "Female";
            else if (G_others.isSelected())
                gender = "Other";

            String email = emailField.getText();
            String MaritalStatus = null;
            if (married.isSelected())
                MaritalStatus = "Married";
            else if (unmarried.isSelected())
                MaritalStatus = "Unmarried";
            else if (M_other.isSelected())
                MaritalStatus = "Other";
            
            String phoneNum= phNoField.getText();
            String state= stateTextFld.getText();
            String city= cityTextFld.getText();
            String address= addressTextFld.getText();
            String pincode= pincodeTextFld.getText();

            try {
                if(name.isBlank()||name.equals("")){
                    JOptionPane.showMessageDialog(this, "Name cant be Empty","Error",JOptionPane.ERROR_MESSAGE);
                }
                else if(fName.isBlank()||name.equals("")){
                    JOptionPane.showMessageDialog(this, "Father's Name cant be Empty","Error",JOptionPane.ERROR_MESSAGE);
                }
                else if(dob.isBlank()||name.equals("")){
                    JOptionPane.showMessageDialog(this, "Were You Not Born!? Enter A Date of Birth","Error",JOptionPane.ERROR_MESSAGE);
                }
                else if(email.isBlank()||name.equals("")){
                    JOptionPane.showMessageDialog(this, "Enter an Email","Error",JOptionPane.ERROR_MESSAGE);
                }
                else if(phoneNum.isBlank()||name.equals("")){
                    JOptionPane.showMessageDialog(this, "We want Your Number","Error",JOptionPane.ERROR_MESSAGE);
                }
                else{

                    Conn c= new Conn();
                    String query="insert into signup values('"+formNo+"','"+name+"','"+fName+"','"+dob+"','"+gender+"','"+email+"','"+MaritalStatus+"','"+phoneNum+"','"+state+"','"+city+"','"+address+"','"+pincode+"')";
                    c.executeQuery(query);

                    new SignupTwo(formNo).setVisible(true);
                    setVisible(false);
                }
            } catch (Exception ex) {
                System.out.println("Error occured");
            }

        }
    }
}