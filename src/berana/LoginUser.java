
package berana;

import static berana.Ulogin.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class LoginUser {
    
    int errors = 1;
    public int error(){
           return errors; 
    }
       
    public LoginUser(){
        try {
            Conndb connOb = new Conndb();
            Statement st = connOb.connectDb().createStatement();
            ResultSet rs = st.executeQuery("select * from users where email='"+email+"' and password ='"+pass+"'" );
            while(rs.next())
            {
                if(email.equals(rs.getString("email")) && pass.equals(rs.getString("password")) ){
                  System.out.println("User detected");
                  errors = 0;
                }
            }
            connOb.connectDb().close();    
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("damn");
            errors = 1;
        } 
    }
    
    
}
