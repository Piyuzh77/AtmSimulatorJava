
package com.bankingSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SignupTwo extends JFrame implements ActionListener{
    
    JLabel pg2,religion,catgry,incm,eductn,occ,panNo,adhNo,snrCitzn,E_acc,pg21,formNo,pg23;
    JButton next;
    JRadioButton r1,r2,r3,r4;
    JTextField t1,t2,t3;
    JComboBox c1,c2,c3,c4,c5;
    String formno;
    SignupTwo(String formno){
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/bankingSystem/icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel pg24 = new JLabel(i3);
        pg24.setBounds(150, 0, 100, 100);
        add(pg24);
        
        
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        pg2 = new JLabel("Page 2: Additonal Details");
        pg2.setFont(new Font("Raleway", Font.BOLD, 22));
        
        religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 18));
        
        catgry = new JLabel("Category:");
        catgry.setFont(new Font("Raleway", Font.BOLD, 18));
        
        incm = new JLabel("Income:");
        incm.setFont(new Font("Raleway", Font.BOLD, 18));
        
        eductn = new JLabel("Educational");
        eductn.setFont(new Font("Raleway", Font.BOLD, 18));
        
        pg21 = new JLabel("Qualification:");
        pg21.setFont(new Font("Raleway", Font.BOLD, 18));
        
        occ = new JLabel("Occupation:");
        occ.setFont(new Font("Raleway", Font.BOLD, 18));
        
        panNo = new JLabel("PAN Number:");
        panNo.setFont(new Font("Raleway", Font.BOLD, 18));
        
        adhNo = new JLabel("Aadhar Number:");
        adhNo.setFont(new Font("Raleway", Font.BOLD, 18));
        
        snrCitzn = new JLabel("Senior Citizen:");
        snrCitzn.setFont(new Font("Raleway", Font.BOLD, 18));
        
        E_acc = new JLabel("Existing Account:");
        E_acc.setFont(new Font("Raleway", Font.BOLD, 18));
        
        formNo = new JLabel("Form No:");
        formNo.setFont(new Font("Raleway", Font.BOLD, 13));
        
        pg23 = new JLabel(formno);
        pg23.setFont(new Font("Raleway", Font.BOLD, 13));
        
        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));
        
        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);
        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);
        ButtonGroup BG1= new ButtonGroup();
        BG1.add(r1);
        BG1.add(r2);
        
        r3 = new JRadioButton("Yes");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(Color.WHITE);
        r4 = new JRadioButton("No");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(Color.WHITE);
        ButtonGroup BG2= new ButtonGroup();
        BG2.add(r3);
        BG2.add(r4);
        
        
        String religions[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        c1 = new JComboBox(religions);
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 14));
        
        String categories[] = {"General","OBC","SC","ST","Other"};
        c2 = new JComboBox(categories);
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 14));
        
        String incomes[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        c3 = new JComboBox(incomes);
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 14));
        
        String educations[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        c4 = new JComboBox(educations);
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 14));
        
        String occupations[] = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        c5 = new JComboBox(occupations);
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 14));
       
        
        setLayout(null);
        
        
        formNo.setBounds(700,10,60,30);
        add(formNo);
        
        pg23.setBounds(760,10,60,30);
        add(pg23);
        
        pg2.setBounds(280,30,600,40);
        add(pg2);
        
        religion.setBounds(100,120,100,30);
        add(religion);
        
        c1.setBounds(350,120,320,30);
        add(c1);
        
        catgry.setBounds(100,170,100,30);
        add(catgry);
        
        c2.setBounds(350,170,320,30);
        add(c2);
        
        incm.setBounds(100,220,100,30);
        add(incm);
        
        c3.setBounds(350,220,320,30);
        add(c3);
        
        eductn.setBounds(100,270,150,30);
        add(eductn);
        
        c4.setBounds(350,270,320,30);
        add(c4);
        
        pg21.setBounds(100,290,150,30);
        add(pg21);
        
        occ.setBounds(100,340,150,30);
        add(occ);
        
        c5.setBounds(350,340,320,30);
        add(c5);
        
        panNo.setBounds(100,390,150,30);
        add(panNo);
        
        t1.setBounds(350,390,320,30);
        add(t1);
        
        adhNo.setBounds(100,440,180,30);
        add(adhNo);
        
        t2.setBounds(350,440,320,30);
        add(t2);
        
        snrCitzn.setBounds(100,490,150,30);
        add(snrCitzn);
        
        r1.setBounds(350,490,100,30);
        add(r1);
        
        r2.setBounds(460,490,100,30);
        add(r2);
        
        E_acc.setBounds(100,540,180,30);
        add(E_acc);
        
        r3.setBounds(350,540,100,30);
        add(r3);
        
        r4.setBounds(460,540,100,30);
        add(r4);
        
        next.setBounds(570,640,100,30);
        add(next);
        
        next.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,750);
        setLocation(500,120);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String religion = (String)c1.getSelectedItem(); 
        String category = (String)c2.getSelectedItem();
        String income = (String)c3.getSelectedItem();
        String education = (String)c4.getSelectedItem();
        String occupation = (String)c5.getSelectedItem();
        
        String pan = t1.getText();
        String aadhar = t2.getText();
        
        String scitizen = "";
        if(r1.isSelected()){ 
            scitizen = "Yes";
        }
        else if(r2.isSelected()){ 
            scitizen = "No";
        }
           
        String eaccount = "";
        if(r3.isSelected()){ 
            eaccount = "Yes";
        }else if(r4.isSelected()){ 
            eaccount = "No";
        }
        
        try{
            if(t2.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            }else{
                Conn c1 = new Conn();
                String q1 = "insert into signup2 values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+scitizen+"','"+eaccount+"')";
                c1.st.executeUpdate(q1);
                
                new SignUpThree(formno).setVisible(true);
                setVisible(false);
            }
                
      
            
        }catch(Exception ex){
             ex.printStackTrace();
        }
    
               
    }
    
    
    public static void main(String[] args){
        new SignupTwo("").setVisible(true);
    }
}