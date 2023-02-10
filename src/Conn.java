import java.sql.*;
public class Conn {

    Connection c;
    Statement s;
    public Conn(){
        try{
              //Class.forName(com.mysql.cj.jdbc.Driver);//1.REGISTER DRIVER
              c=DriverManager.getConnection("jdbc:mysql://localhost:3307/bankmanagement","root","Maithilisomayaji");//2.Create Connection
              s=c.createStatement();  //3.CREATE STATEMENT
        } catch(Exception e){
            System.out.println(e);
        }
    }
}
