//import com.mysql.cj.xdevapi.DeleteStatement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
    JButton deposit,withdrawal,FastCash,Statement,pinchange,balnace,exit;
    String pinnum;
    Transactions(String pinnum){
        this.pinnum=pinnum;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("Please select your Transaction ");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,18));
        text.setBounds(200,300,700,30);
        image.add(text);

        deposit =new JButton("Deposit");
        deposit.setBounds(170,415,150,28);
        deposit.addActionListener(this);
        image.add(deposit);
        withdrawal =new JButton("Cash withdrawal");
        withdrawal.setBounds(350,415,150,28);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        FastCash=new JButton("Fast Cash");
        FastCash.setBounds(170,450,150,28);
        FastCash.addActionListener(this);
        image.add(FastCash);
        Statement =new JButton("Mini Statement");
        Statement.setBounds(350,450,150,28);
        Statement.addActionListener(this);
        image.add(Statement);

        pinchange=new JButton("Pin Change");
        pinchange.setBounds(170,485,150,28);
        pinchange.addActionListener(this);
        image.add(pinchange);
        balnace=new JButton("Balance Enquiry");
        balnace.setBounds(350,485,150,28);
        balnace.addActionListener(this);
        image.add(balnace);


        exit=new JButton("Exit");
        exit.setBounds(350,520,150,28);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae ){
        if(ae.getSource()==exit){
            System.exit(0);
        } else if (ae.getSource()==deposit) {
            setVisible(false);
            new Deposit(pinnum).setVisible(true);
        } else if (ae.getSource()==withdrawal) {
            setVisible(false);
            new Withdrawl(pinnum).setVisible(true);
        } else if (ae.getSource()==FastCash) {
            setVisible(false);
            new FastCash(pinnum).setVisible(true);
        } else if (ae.getSource()==pinchange) {
            setVisible(false);
            new PinChange(pinnum).setVisible(true);
        }else if (ae.getSource()==balnace) {
            setVisible(false);
            new BalanceEnquiry(pinnum).setVisible(true);
        }else if (ae.getSource()==Statement) {

            new MiniStatement(pinnum).setVisible(true);
        }

    }
    public static void main(String[] args)
    {
        new Transactions("");
    }
}
