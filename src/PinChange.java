import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.util.*;

public class PinChange extends JFrame implements ActionListener {
    JPasswordField pin,repin;
    JButton change,back;
    String pinnum;
    PinChange(String pinnum) {
        this.pinnum=pinnum;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3=new  ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("CHANGE YOUR PIN ");
        text.setForeground(Color.white);
        text.setFont(new Font ("System",Font.BOLD,16));
        text.setBounds(250,280,500,35);
        image.add(text);

        JLabel pintext=new JLabel("New PIN");
        pintext.setForeground(Color.white);
        pintext.setFont(new Font ("System",Font.BOLD,16));
        pintext.setBounds(160,340,180,25);
        image.add(pintext);
        pin= new JPasswordField();
        pin.setFont((new Font("Raleway",Font.BOLD,25)));
        pin.setBounds(320,340,180,25);
        image.add(pin);

        JLabel repintext=new JLabel("Re-Enter New PIN ");
        repintext.setForeground(Color.white);
        repintext.setFont(new Font ("System",Font.BOLD,16));
        repintext.setBounds(160,380,180,25);
        image.add(repintext);

        repin= new JPasswordField();
        repin.setFont((new Font("Raleway",Font.BOLD,25)));
        repin.setBounds(320,380,180,25);
        image.add(repin);

        change=new JButton("CHANGE");
        change.setBounds(355,470,150,30);
        change.addActionListener(this);
        image.add(change);

        back=new JButton("Back");
        back.setBounds(355,510,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setUndecorated(true);
        setLocation(300,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == change){
            try{
                String npin=pin.getText();
                String rpin=repin.getText();
                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                    return;
                }
                if (npin.equals("")){
                    JOptionPane.showMessageDialog(null," Please Enter PIN ");
                    return;
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null," Please Re-e nter NEW-PIN ");
                    return;
                }
                conn c=new conn();
                String query1="update bank set pin= '"+rpin+"'where pin='"+pinnum+"'";
                String query2="update login set pin= '"+rpin+"'where pin='"+pinnum+"'";
                String query3="update signupthree set pin= '"+rpin+"'where pin='"+pinnum+"'";
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                c.s.executeUpdate(query1);
                JOptionPane.showMessageDialog(null,"PIN Change Successfully ");
                setVisible(false);
                new Transactions(rpin).setVisible(true);
            }catch(Exception e ){
                System.out.println(e);
            }
        }else {
            setVisible(false);
            new Transactions(pinnum).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
