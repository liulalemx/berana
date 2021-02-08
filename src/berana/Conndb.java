
package berana;

import java.sql.*;

public class Conndb {
    public Connection connectDb() throws SQLException,ClassNotFoundException{

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databasename=BeranaUsers";
        Connection connectDb = DriverManager.getConnection(url,"testuser","password");

        return connectDb;
    }
}
