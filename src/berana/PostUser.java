/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package berana;

import static berana.UcreatePost.*;
import static berana.Ulogin.*;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author user
 */
public class PostUser {
    
    public PostUser(){
        try {
            Conndb connOb = new Conndb();
            System.out.println(connOb.connectDb());
            Statement st = connOb.connectDb().createStatement();
            String data = "INSERT INTO posts(email,post) values('"+email+"','"+postText+"') "
                    + "UPDATE users SET postNo=postNO+1 WHERE email='"+email+"'";
            st.executeUpdate(data);
            
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Succesfully Posted!");
            
        }
    }
}







