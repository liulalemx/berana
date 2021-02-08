
package berana;

import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.*;

/**
 *
 * @author user
 */
public class PictureUser {
    String email;
    String s;
    public void addPicture(String email,String s) {
        this.email = email;
        this.s=s;
        try {
            Conndb connOb = new Conndb();
            Statement st = connOb.connectDb().createStatement();
            String data = "INSERT INTO profilePictures(email,Files) select '"+this.email+"',BulkColumn FROM OPENROWSET(BULK N'"+this.s+"', SINGLE_BLOB) image"; 
            st.executeUpdate(data);
            
        connOb.connectDb().close(); 
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }
    public void getPicture(String email,JLabel jl) {
        this.email = email;
        
        try {
            Conndb connOb = new Conndb();
            Statement st = connOb.connectDb().createStatement();
            ResultSet rs = st.executeQuery("select Files from profilePictures where email='"+this.email+"'");
            while(rs.next())
            {
            ImageIcon image = new ImageIcon(rs.getBytes("Files"));
            Image img=image.getImage();
            Image newimg=img.getScaledInstance(jl.getWidth(),jl.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon picture=new ImageIcon(newimg);
            jl.setIcon(picture);
            } 
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }
    
    
}

