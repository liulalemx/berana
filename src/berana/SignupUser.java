
package berana;

import static berana.Usignup.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SignupUser {
        int errors;
        public int error(){
           return errors; 
        }
        public SignupUser(){

        try {
            Conndb connOb = new Conndb();
            System.out.println(connOb.connectDb());
            Statement st = connOb.connectDb().createStatement();
//            Statement rt = connOb.connectDb().createStatement();
//            ResultSet rs = rt.executeQuery("select email from users" );
            String data = "INSERT INTO users(firstname,lastname,email,password,gender) values('"+fname+"','"+lname+"','"+email+"','"+pass+"','"+gender+"')";
            st.executeUpdate(data);
            errors = 0;
            connOb.connectDb().close(); 
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("The email is already in use!");
            errors = 1;
        }


    }
}
