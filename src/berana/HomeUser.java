
package berana;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;


public class HomeUser {
    String email;
    String password;
    String username;
    String postNum;
    String followers;
    String following;
    public void homeUser(String email,String password){
        this.email = email;
        this.password = password;
        try {
            Conndb connOb = new Conndb();
            Statement st = connOb.connectDb().createStatement();
            ResultSet rs = st.executeQuery("select * from users where email='"+this.email+"' and password ='"+this.password+"'" );
            while(rs.next())
            {   
                if(email.equals(rs.getString("email")) && password.equals(rs.getString("password")) ){
                  username = rs.getString("firstname");
                  postNum = rs.getString("postNo");
                  System.out.println(username);
                }
            }
        connOb.connectDb().close();     
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }
    public void following(String email){
        this.email = email;
        try {
            Conndb connOb = new Conndb();
            Statement st = connOb.connectDb().createStatement();
            ResultSet rs = st.executeQuery("select count(email) as following from follow where email='"+this.email+"'");
            while(rs.next())
            {   
                following = rs.getString("following");             
            }
        connOb.connectDb().close();     
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }
    public void followers(String email){
        this.email = email;
        try {
            Conndb connOb = new Conndb();
            Statement st = connOb.connectDb().createStatement();
            ResultSet rs = st.executeQuery("select count (followEmail) as followers from follow where followEmail='"+this.email+"'");
            while(rs.next())
            {   
                followers = rs.getString("followers");             
            }
        connOb.connectDb().close();     
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }
    
}
