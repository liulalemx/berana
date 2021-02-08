package berana;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PopulatePostTable {
    String email;
    String postString;
    String postDateString;
    String tableView;
    public void populate(String email,String tableView, JTable jp,boolean input) {
        this.email = email;
        this.tableView = tableView;
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
    public void deletePost(String email,String tableView) {
        this.email = email;
        this.tableView = tableView;
        try {
            Conndb connOb = new Conndb();
            Statement st = connOb.connectDb().createStatement();
            st.executeUpdate("delete posts where email ='"+this.email+"'and post='"+this.tableView+"'");
            st.executeUpdate("UPDATE users SET postNo=postNO-1 WHERE email='"+email+"'");
            connOb.connectDb().close(); 
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }
}
