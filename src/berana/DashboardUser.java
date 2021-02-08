
package berana;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class DashboardUser {
    String email;
    String followed;
    String postString;
    String postDateString;
    String followedName;
    public void getFollowing(String email,JComboBox bx) {
        this.email = email;
        try {
            Conndb connOb = new Conndb();
            Statement st = connOb.connectDb().createStatement();
            ResultSet rs1 = st.executeQuery("select followEmail from follow where email ='"+this.email+"'");
            while(rs1.next())
            {   
               followed = rs1.getString("followEmail");
                bx.addItem(followed);
                
            }
        connOb.connectDb().close(); 
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }
    public void populateTable(String email,JTable jp,boolean input) {
        this.email = email;
        try {
            Conndb connOb = new Conndb();
            Statement st = connOb.connectDb().createStatement();
            ResultSet rs1 = st.executeQuery("select post,postdate from users u join posts p on u.email=p.email where u.email ='"+this.email+"'");
            while(rs1.next())
            {   
                postString = rs1.getString("post");
                postDateString = rs1.getString("postDate");
                DefaultTableModel model = (DefaultTableModel)jp.getModel();
                if (input){
                    model.setRowCount(0);
                    input = false;
                }
                model.addRow(new Object [] {postString,postDateString});
                
            }
        connOb.connectDb().close(); 
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }
    public void getFollowedInfo(String email) {
        this.email = email;
        try {
            Conndb connOb = new Conndb();
            Statement st = connOb.connectDb().createStatement();
            ResultSet rs1 = st.executeQuery("select firstname from users where email ='"+this.email+"'");
            while(rs1.next())
            {   
                followedName = rs1.getString("firstname");
                
            }
        connOb.connectDb().close(); 
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }
    public void searchUser(String email,JComboBox bx) {
        this.email = email;
        bx.removeAllItems();
        try {
            Conndb connOb = new Conndb();
            Statement st = connOb.connectDb().createStatement();
            ResultSet rs1 = st.executeQuery("select email from users where email like '%"+this.email+"%' or firstname like '%"+this.email+"%'");
            while(rs1.next())
            {   
                followed = rs1.getString("email");
                bx.addItem(followed);
                
            }
        connOb.connectDb().close(); 
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }
    public void follow(String email,String followemail){
        this.email = email;
        String followEmail = followemail;
        try {
            Conndb connOb = new Conndb();
            Statement st = connOb.connectDb().createStatement();
            String data = "insert into follow (email,followEmail) values ('"+this.email+"','"+followEmail+"')"; 
            st.executeUpdate(data);
        connOb.connectDb().close();     
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }
    public void unfollow(String email,String followemail){
        this.email = email;
        String followEmail = followemail;
        try {
            Conndb connOb = new Conndb();
            Statement st = connOb.connectDb().createStatement();
            String data = "delete follow where email = '"+this.email+"' and followEmail = '"+followEmail+"'"; 
            st.executeUpdate(data);
        connOb.connectDb().close();     
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }
}
