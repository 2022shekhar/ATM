import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Singuptwo extends JFrame implements ActionListener {
    JTextField pann, adhar;
    JRadioButton syes, sno, eayes, eano;
    JComboBox rel, catb, in, educa, occup;
    JButton next;
    String formno;

    Singuptwo(String formno) {
        this.formno = formno;
        setLayout(null);
        setTitle("New Account Application form - FORM 2");

        JLabel personDetail = new JLabel("FORM 2: Addtional Details ");
        personDetail.setFont(new Font("Raleway", Font.BOLD, 30));
        personDetail.setBounds(250, 50, 400, 40);
        add(personDetail);

        JLabel reg = new JLabel("Religious :");
        reg.setFont(new Font("Raleway", Font.BOLD, 24));
        reg.setBounds(100, 120, 250, 30);
        add(reg);
        String valrel[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        rel = new JComboBox(valrel);
        rel.setBounds(300, 122, 400, 28);
        rel.setBackground(Color.WHITE);
        add(rel);

        JLabel cat = new JLabel("Category :");
        cat.setFont(new Font("Raleway", Font.BOLD, 24));
        cat.setBounds(100, 180, 250, 30);
        add(cat);
        String valcat[] = {"General", "OBC", "ST", "SC", "EWS"};
        catb = new JComboBox(valcat);
        catb.setBounds(300, 182, 400, 28);
        catb.setBackground(Color.WHITE);
        add(catb);

        JLabel income = new JLabel("Income :");
        income.setFont(new Font("Raleway", Font.BOLD, 24));
        income.setBounds(100, 240, 250, 30);
        add(income);
        String valincome[] = {"Above 2000000", "1000000-2000000", "600000-1000000", "100000-600000", "100000-50000", "null"};
        in = new JComboBox(valincome);
        in.setBounds(300, 242, 400, 28);
        in.setBackground(Color.WHITE);
        add(in);

        JLabel education = new JLabel("Education :");
        education.setFont(new Font("Raleway", Font.BOLD, 24));
        education.setBounds(100, 300, 250, 30);
        add(education);
        String valedu[] = {"Doctorate", "Post-Graduation", "Graduate", "Non-Graduation", "Other"};
        educa = new JComboBox(valedu);
        educa.setBounds(300, 302, 400, 28);
        educa.setBackground(Color.WHITE);
        add(educa);

        JLabel occupation = new JLabel("Occupation :");
        occupation.setFont(new Font("Raleway", Font.BOLD, 24));
        occupation.setBounds(100, 360, 250, 30);
        add(occupation);
        String valoccp[] = {"Salaried", "Self-Employed", "Businessman", "Student", "Retired", "Other"};
        occup = new JComboBox(valoccp);
        occup.setBounds(300, 362, 400, 28);
        occup.setBackground(Color.WHITE);
        add(occup);
        JLabel pan = new JLabel("PAN Number :");
        pan.setFont(new Font("Raleway", Font.BOLD, 24));
        pan.setBounds(100, 420, 250, 30);
        add(pan);
        pann = new JTextField();
        pann.setFont(new Font("Raleway ", Font.BOLD, 16));
        pann.setBounds(300, 420, 400, 28);
        add(pann);

        JLabel aadhar = new JLabel("Aadhar Number :");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 24));
        aadhar.setBounds(100, 480, 250, 30);
        add(aadhar);
        adhar = new JTextField();
        adhar.setFont(new Font("Raleway ", Font.BOLD, 16));
        adhar.setBounds(300, 480, 400, 28);
        add(adhar);

        JLabel Senior = new JLabel("Senior Citizen :");
        Senior.setFont(new Font("Raleway", Font.BOLD, 24));
        Senior.setBounds(100, 540, 250, 30);
        add(Senior);
        syes = new JRadioButton("Yes");
        syes.setBounds(350, 540, 90, 30);
        syes.setFont(new Font("Raleway", Font.BOLD, 18));
        syes.setBackground(Color.lightGray);
        add(syes);
        sno = new JRadioButton("No");
        sno.setBounds(550, 540, 90, 30);
        sno.setFont(new Font("Raleway", Font.BOLD, 18));
        sno.setBackground(Color.lightGray);
        add(sno);
        ButtonGroup sergroup = new ButtonGroup();
        sergroup.add(syes);
        sergroup.add(sno);

        JLabel exiting = new JLabel("Exisiting Account :");
        exiting.setFont(new Font("Raleway", Font.BOLD, 24));
        exiting.setBounds(100, 600, 250, 30);
        add(exiting);
        eayes = new JRadioButton("Yes");
        eayes.setBounds(350, 600, 90, 30);
        eayes.setFont(new Font("Raleway", Font.BOLD, 18));
        eayes.setBackground(Color.lightGray);
        add(eayes);
        eano = new JRadioButton("No");
        eano.setBounds(550, 600, 90, 30);
        eano.setFont(new Font("Raleway", Font.BOLD, 18));
        eano.setBackground(Color.lightGray);
        add(eano);
        ButtonGroup eagroup = new ButtonGroup();
        eagroup.add(eayes);
        eagroup.add(eano);

        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 680, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.lightGray);
        setSize(820, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String srel = (String)rel.getSelectedItem();
        String scat = (String)catb.getSelectedItem();
        String sin = (String)in.getSelectedItem();
        String seduca = (String)educa.getSelectedItem();
        String soccu = (String)occup.getSelectedItem();
        String span = pann.getText();
        String sadhar = adhar.getText();
        String ssenior = null;
        if (syes.isSelected()) {
            ssenior = "Yes";
        } else if (sno.isSelected()) {
            ssenior = "No";
        }
        String exexting = null;
        if (eayes.isSelected()) {
            exexting = "Yes";
        } else if (eano.isSelected()) {
            exexting = "No";
        }
        try {
            conn c = new conn();
            String query = "insert into Singuptwo values('" +formno+ "','" + srel + "','" + scat + "','" + sin + "','" + seduca + "','" + soccu + "','" + span + "','" + sadhar + "','" + ssenior + "','" + exexting+"')";
            c.s.executeUpdate(query);
            setVisible(false);
            new Signupthree(formno).setVisible(true);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new Singuptwo("");
    }
}
