import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Signupthree extends JFrame implements ActionListener{
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    Signupthree(String formno) {
        this.formno=formno;
        setLayout(null);
        setTitle("New Account Application form - FORM 3");

        JLabel l1 = new JLabel(" FORM 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 30));
        l1.setBounds(230, 50, 400, 40);
        add(l1);

        JLabel type = new JLabel(" Account Type Details :");
        type.setFont(new Font("Raleway", Font.BOLD, 24));
        type.setBounds(80, 120, 300, 30);
        add(type);
        r1=new JRadioButton("Saving Account ");
        r1.setFont(new Font("Raleway",Font.BOLD, 20));
        r1.setBackground(Color.lightGray);
        r1.setBounds(100, 160, 200, 30);
        add(r1);

        r2=new JRadioButton("Current Account ");
        r2.setFont(new Font("Raleway", Font.BOLD, 20));
        r2.setBackground(Color.lightGray);
        r2.setBounds(400, 160, 200, 30);
        add(r2);

        r3=new JRadioButton("Fixed Deposit Account ");
        r3.setFont(new Font("Raleway", Font.BOLD, 20));
        r3.setBackground(Color.lightGray);
        r3.setBounds(100, 200, 250, 30);
        add(r3);
        r4=new JRadioButton("Recurring Account ");
        r4.setFont(new Font("Raleway", Font.BOLD, 20));
        r4.setBackground(Color.lightGray);
        r4.setBounds(400, 200, 250, 30);
        add(r4);
        ButtonGroup groupaccount =new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        JLabel card = new JLabel("Card Number :");
        card.setFont(new Font("Raleway", Font.BOLD, 24));
        card.setBounds(80, 260, 200, 30);
        add(card);
        JLabel number = new JLabel("XXXX-XXXX-XXXX-6576 ");
        number.setFont(new Font("Raleway", Font.BOLD, 24));
        number.setBounds(350, 260, 300, 30);
        add(number);
        JLabel detail=new JLabel("your 16 Digit Card Number");
        detail.setFont(new Font("Raleway",Font.BOLD,16));
        detail.setBounds(80,290,300,25);
        add(detail);

        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway", Font.BOLD, 24));
        pin.setBounds(80, 350, 200, 30);
        add(pin);
        JLabel pnumber = new JLabel("XXXX ");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 24));
        pnumber.setBounds(350, 350, 300, 30);
        add(pnumber);
        JLabel pdetail=new JLabel("your 4 Digit password");
        pdetail.setFont(new Font("Raleway",Font.BOLD,16));
        pdetail.setBounds(80,380,300,25);
        add(pdetail);

        JLabel services=new JLabel("Services Required :");
        services.setFont(new Font("Raleway",Font.BOLD, 24));
        services.setBounds(80, 440, 400, 30);
        add(services);
        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.lightGray);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,480,200,30);
        add(c1);
        c2=new JCheckBox("Net Banking");
        c2.setBackground(Color.lightGray);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(300,480,200,30);
        add(c2);
        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.lightGray);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(500,480,200,30);
        add(c3);
        c4=new JCheckBox("Email & SMS Alert");
        c4.setBackground(Color.lightGray);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(100,520,200,30);
        add(c4);
        c5=new JCheckBox("Cheque Book");
        c5.setBackground(Color.lightGray);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(300,520,200,30);
        add(c5);
        c6=new JCheckBox("E-Statement");
        c6.setBackground(Color.lightGray);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(500,520,200,30);
        add(c6);
        c7=new JCheckBox("Hereby declares that the above entered are correct to the best of My Knowledge ");
        c7.setBackground(Color.lightGray);
        c7.setFont(new Font("Raleway",Font.BOLD,16));
        c7.setBounds(80,580,640,30);
        add(c7);

        submit =new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,20));
        submit.setBounds(150,680,200,30);
        submit.addActionListener(this);
        add(submit);
        cancel =new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,20));
        cancel.setBounds(450,680,200,30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.lightGray);
        setSize(820, 800);
        setLocation(350, 0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String accountType=null;
            if(r1.isSelected()){
                accountType="Saving Account";
            }else if (r2.isSelected()){
                accountType="Current Account";
            } else if (r3.isSelected()){
                accountType="Fixed Account";
            }else if (r4.isSelected()){
                accountType="Recurring Account";
            }
            Random random=new Random();
            String cardnumber=""+Math.abs((random.nextLong()% 90000000L)+5040936000000000L);
            String pinnumber =""+Math.abs(random.nextLong()%9000L+1000L);
            String facility = "";
            if ( c1.isSelected()){
                facility=facility+"ATM Card";
            } else if (c2.isSelected()) {
                facility=facility+"Net Banking";
            }else if (c3.isSelected()) {
                facility=facility+"Mobile Banking";
            }else if (c4.isSelected()) {
                facility = facility + "Email & SMS Banking";
            } else if (c5.isSelected()) {
                facility=facility+"Cheque book";
            } else if (c6.isSelected()) {
                facility=facility+"E-Statement";
            }
            try {
                if (ae.getSource() == submit) {
                    if (accountType.equals("")) {
                        JOptionPane.showMessageDialog(null, "Account type is Required");
                    } else {
                        conn c = new conn();
                        String query1 = "insert into signupthree values('" + formno + "','" + accountType + "','" + cardnumber + "','" + pinnumber + "','" + facility + "')";
                        String query2 = "insert into login values('" + formno + "','" + cardnumber + "','" + pinnumber + "')";
                        c.s.executeUpdate(query1);
                        c.s.executeUpdate(query2);
                        JOptionPane.showMessageDialog(null, "cardnumber: " + cardnumber + "\n pin: " + pinnumber);

                        new Deposit(pinnumber).setVisible(true);
                        setVisible(false);
                    }
                } else if (ae.getSource() == cancel) {
                    setVisible(false);
                    new Login().setVisible(true);
                }
            }
            catch (Exception e){
                    System.out.println(e);
            }
        }
    public static void main(String[] args) {
        new Signupthree("");
    }
}
