import java.sql.*;
public class conn {
    Connection c;
    Statement s;
    public conn(){
        try{
            c=DriverManager.getConnection("jdbc:mysql:///ATM","root","$.cs/sd2598");
            s=c.createStatement();

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
