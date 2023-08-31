import java.awt.*;
import javax.swing.*;
import java.sql.*;
public class MiniStatement extends JFrame{
    String pinnum;

    MiniStatement(String pinnum ){
        setTitle("Mini Statement ");
        setLayout(null);

        JLabel bank=new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card=new JLabel("");
        card.setBounds(20,50,300,20);
        add(card);

        JLabel mini=new JLabel();
        mini.setBounds(15,80,400,200);
        add(mini);
        JLabel balance=new JLabel();
        balance.setBounds(20,320,300,200);
        add(balance);
        try{
            conn c=new conn();
            ResultSet rs= c.s.executeQuery("select * from login where pin = '"+pinnum+"'");
            while(rs.next()){
                card.setText("Card Number : "+rs.getString("Cardnumber").substring(0,4)+ "XXXXXXXX"+rs.getString("Cardnumber").substring(12));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        try{
            conn c=new conn();
            int bal =0;
            ResultSet rs= c.s.executeQuery("select * from bank where pin = '"+pinnum+"'");
            while(rs.next()){
                mini.setText(mini.getText()+ "<html>" +rs.getString("date") + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
                if(rs.getString("type").equals("deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -=Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your Current Account Balance is Rs : " + bal);
        }catch (Exception e){
            System.out.println(e);
        }
        setSize(400,500);
        setLocation(20,50);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
