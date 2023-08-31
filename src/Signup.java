import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class Signup extends JFrame implements ActionListener{
    long random;
    JTextField nameTextField,FTextField,emailTextField,addTextField, cityTextField,stateTextField,pinTextField;
    JButton next;
    JRadioButton male, female,married,Unmarried,other;
    JDateChooser dateChooser;
    Signup(){
        Random ran=new Random();
        setLayout(null);
        setTitle("New Account Application form - FORM 1");
         random =Math.abs((ran.nextLong() %9000L)+1000L);

        JLabel formno=new JLabel("APPLICATION FORM NO. "+ random);
        formno.setFont(new Font ("Raleway",Font.BOLD,38));
        formno.setBounds(130,20,600,50);
        add(formno);
        JLabel personDetail=new JLabel("FORM 1: Personal Details ");
        personDetail.setFont(new Font("Raleway",Font.BOLD,30));
        personDetail.setBounds(250,90,400,40);
        add(personDetail);

        JLabel name=new JLabel("Name :");
        name.setFont(new Font("Raleway",Font.BOLD,24));
        name.setBounds(100,180,200,25);
        add(name);
         nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,15));
        nameTextField.setBounds(300,180,400,25);
        add(nameTextField);

        JLabel fname=new JLabel("Father's Name : ");
        fname.setFont(new Font("Raleway",Font.BOLD,24));
        fname.setBounds(100,220,200,25);
        add(fname);
         FTextField=new JTextField();
        FTextField.setFont(new Font("Raleway",Font.BOLD,15));
        FTextField.setBounds(300,220,400,25);
        add(FTextField);

        JLabel age=new JLabel("Date of Birth : ");
        age.setFont(new Font("Raleway",Font.BOLD,24));
        age.setBounds(100,260,200,25);
        add(age);
        dateChooser= new JDateChooser();
        dateChooser.setBounds(300,260,400,25);
        dateChooser.setForeground(Color.WHITE);
        add(dateChooser);

        JLabel gender=new JLabel("Gender : ");
        gender.setFont(new Font("Raleway",Font.BOLD,24));
        gender.setBounds(100,300,200,25);
        add(gender);
         male=new JRadioButton("Male");
        male.setBounds(300,300,90,35);
        male.setBackground(Color.lightGray);
        add(male);
         female=new JRadioButton("Female");
        female.setBounds(400,300,90,35);
        female.setBackground(Color.lightGray);
        add(female);
        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel address=new JLabel("Email Address : ");
        address.setFont(new Font("Raleway",Font.BOLD,24));
        address.setBounds(100,340,200,25);
        add(address);
         emailTextField=new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,15));
        emailTextField.setBounds(300,340,400,25);
        add(emailTextField);

        JLabel marital=new JLabel("Martial Status : ");
        marital.setFont(new Font("Raleway",Font.BOLD,24));
        marital.setBounds(100,380,200,25);
        add(marital);

         married=new JRadioButton("Married");
        married.setBounds(300,380,90,35);
        married.setBackground(Color.lightGray);
        add(married);
         Unmarried=new JRadioButton("Unmarried");
        Unmarried.setBounds(400,380,100,35);
        Unmarried.setBackground(Color.lightGray);
        add(Unmarried);
         other=new JRadioButton("Other");
        other.setBounds(500,380,90,35);
        other.setBackground(Color.lightGray);
        add(other);
        ButtonGroup Martialgroup=new ButtonGroup();
        Martialgroup.add(married);
        Martialgroup.add(Unmarried);
        Martialgroup.add(other);

        JLabel Address=new JLabel("Address :");
        Address.setFont(new Font("Raleway",Font.BOLD,24));
        Address.setBounds(100,420,200,25);
        add(Address);
        addTextField=new JTextField();
        addTextField.setFont(new Font("Raleway",Font.BOLD,15));
        addTextField.setBounds(300,420,400,25);
        add(addTextField);

        JLabel City=new JLabel("City :");
        City.setFont(new Font("Raleway",Font.BOLD,24));
        City.setBounds(100,460,200,25);
        add(City);
         cityTextField=new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,15));
        cityTextField.setBounds(300,460,400,25);
        add(cityTextField);

        JLabel State=new JLabel("State :");
        State.setFont(new Font("Raleway",Font.BOLD,24));
        State.setBounds(100,500,200,25);
        add(State);
        stateTextField=new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,15));
        stateTextField.setBounds(300,500,400,25);
        add(stateTextField);
        JLabel pincode=new JLabel("Pin Code :");
        pincode.setFont(new Font("Raleway",Font.BOLD,24));
        pincode.setBounds(100,540,200,25);
        add(pincode);
         pinTextField=new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,15));
        pinTextField.setBounds(300,540,400,25);
        add(pinTextField);

         next =new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,620,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.lightGray);
        setSize(820,800);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String formno= ""+random; //long +""=string
        String name=nameTextField.getText();
        String fname=FTextField.getText();
        String age=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }
        else if(female.isSelected()){
            gender="Female";
        }
        String email=emailTextField.getText();
        String martial=null;
        if (married.isSelected()){
            martial="Married";
        } else if (Unmarried.isSelected()){
            martial="Unmarried";
        }
        else if (other.isSelected()){
            martial="Other";
        }
        String address=addTextField.getText();
        String city=cityTextField.getText();
        String state=stateTextField.getText();
        String pin=pinTextField.getText();
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }else{
                conn c=new conn();
                String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+age+"','"+gender+"','"+email+"','"+martial+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);
            setVisible(false);
            new Singuptwo(formno).setVisible(true);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args){
        new Signup();
        }
    }

