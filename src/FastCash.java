import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener {
    JButton hundred,five,thousand, two,pinchange,balnace,exit;
    String pinnum;
    FastCash(String pinnum){
        this.pinnum=pinnum;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("SELECT WITHDRAWAL AMOUNT ");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,18));
        text.setBounds(200,300,700,30);
        image.add(text);

        hundred =new JButton("Rs 100");
        hundred.setBounds(170,415,150,28);
        hundred.addActionListener(this);
        image.add(hundred);
        five =new JButton("Rs 500");
        five.setBounds(350,415,150,28);
        five.addActionListener(this);
        image.add(five);

        thousand=new JButton("Rs 1000");
        thousand.setBounds(170,450,150,28);
        thousand.addActionListener(this);
        image.add(thousand);
        two =new JButton("Rs 2000");
        two.setBounds(350,450,150,28);
        two.addActionListener(this);
        image.add(two);

        pinchange=new JButton("RS 5000");
        pinchange.setBounds(170,485,150,28);
        pinchange.addActionListener(this);
        image.add(pinchange);
        balnace=new JButton("RS 10000");
        balnace.setBounds(350,485,150,28);
        balnace.addActionListener(this);
        image.add(balnace);

        exit=new JButton("BACK");
        exit.setBounds(350,520,150,28);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
           setVisible(false);
           new Transactions(pinnum).setVisible(true);
        } else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            conn c =new conn();
            try {
            ResultSet rs=c.s.executeQuery("select * from bank where pin = '"+pinnum+"'");
            int balance=0;
            while(rs.next()){
                if(rs.getString("type").equals("deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
            if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                 JOptionPane.showConfirmDialog(null,"Insufficient Balance");
                 return;
                }
                Date date =new Date();
                String query="insert into bank values('"+pinnum+"','"+date+"','Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Successfully");
                setVisible(false);
                new Transactions(pinnum).setVisible(true);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        new FastCash("");
    }
}
