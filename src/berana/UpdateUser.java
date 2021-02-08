
package berana;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author user
 */
public class UpdateUser {
    String email,fname,lname,gen;
    public void fetchData(String email){
           this.email = email;
           try {
               Conndb connOb = new Conndb();
            Statement st = connOb.connectDb().createStatement();
            ResultSet rs1 = st.executeQuery("select firstname,lastname,gender from users where email = '"+this.email+"'");
            while(rs1.next())
            {   
                fname = rs1.getString("firstname");
                lname = rs1.getString("lastname");
                gen = rs1.getString("gender");
            }
           connOb.connectDb().close();     
           } catch (ClassNotFoundException | SQLException ex) {
               System.out.println(ex.getMessage());
           } 
       }
    public void update(String email,String fname,String lname,String gen){
            this.email = email;
            this.fname =fname;
            this.lname = lname;
            this.gen = gen;
            try {
                Conndb connOb = new Conndb();
                Statement st = connOb.connectDb().createStatement();
                String data = "UPDATE users set firstname = '"+this.fname+"', lastname = '"+this.lname+"',gender = '"+this.gen+"' where email = '"+this.email+"'"; 
                st.executeUpdate(data);
            connOb.connectDb().close();     
            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println(ex.getMessage());
            } 
        }
    
}
