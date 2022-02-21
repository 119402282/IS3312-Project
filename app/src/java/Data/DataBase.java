package Data;

import java.beans.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.jdbc.EmbeddedDriver;

public class DataBase {

    
    private static Connection conn;
    String dbName = "bootsdb";
    String urlProtocol = "jdbc:derby://localhost:1527/" + dbName+ ";create=true";
    private static DataBase db = new DataBase();
    
    
    private DataBase(){
        
        try {
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
            Properties properties = new Properties();
            properties.put("user", "dba");
            properties.put("password","dba");

            try {
                conn = DriverManager.getConnection(urlProtocol, properties);
                conn.setAutoCommit(true);

            } catch (SQLException e) {
                System.err.println("ConnectionException: "+e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException: "+e.getMessage());
        }
    }
    
    public static Connection getConnection() {
        return conn;
    }
    
    public static DataBase getInstance(){
        return db;
    }
}
