import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JButton login,clear,Signup;
    JTextField cardTextField;
    JPasswordField pinField;
    Login(){
        setTitle("ATM");
        setLayout(null);
        setTitle("LOGIN PAGE");
        ImageIcon il =new ImageIcon(ClassLoader.getSystemResource("logo.jpg"));
        Image i2 =il.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(250,40,400,30);
        add(text);
        JLabel cardno=new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD,30));
        cardno.setBounds(120,150,150,30);
        add(cardno);
        cardTextField=new JTextField();
        cardTextField.setBounds(300,150,240,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(cardTextField);
        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Osward",Font.BOLD,30));
        pin.setBounds(120,250,100,30);
        add(pin);
         pinField=new JPasswordField();
        pinField.setBounds(300,250,240,30);
        add(pinField);
         login =new JButton("SIGN IN");
        login.setBounds(300,320,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
         clear =new JButton("CLEAR");
        clear.setBounds(440,320,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
         Signup =new JButton("SIGN UP");
        Signup.setBounds(300,400,240,30);
        Signup.setBackground(Color.BLACK);
        Signup.setForeground(Color.WHITE);
        Signup.addActionListener(this);
        add(Signup);
        getContentPane().setBackground(Color.WHITE);
        setSize(800,500);
        setUndecorated(true);
        setVisible(true);
        setLocation(350,200);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            if (ae.getSource()==login) {
                conn c = new conn();
                String cardnum = cardTextField.getText();
                String pinnum = pinField.getText();
                String query = "select * from login where Cardnumber ='" + cardnum + "'and pin ='" + pinnum + "'";
                ResultSet rs = c.s.executeQuery(query);
                    if (rs.next()) {
                        setVisible(false);
                        new Transactions(pinnum).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                    }
            } else if (ae.getSource() == clear) {
                        cardTextField.setText("");
                        pinField.setText("");
            } else if (ae.getSource() == Signup) {
                        setVisible(false);
                        new Signup().setVisible(true);
                    }
            }catch (Exception e) {
                    System.out.println(e);
            }
    }
    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}
