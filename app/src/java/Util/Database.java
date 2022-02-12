package com.company;

import java.beans.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class Database {

    public static void main(String[] args) {

        Connection conn = null;
        ArrayList<Statement> statements = new ArrayList<Statement>(); // list of Statements, PreparedStatements
        PreparedStatement prepStmtInsert;
        PreparedStatement prepStmtUpdate;
        Statement stmt;
        ResultSet results = null;
	// write your code here
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

            String dbName = "BootsDB";
            String urlProtocol = "jdbc:derby://localhost:1527/" + dbName;
            Properties properties = new Properties();
            properties.put("user", "dba");
            properties.put("password","dba");

            try {
                conn = DriverManager.getConnection(urlProtocol, properties);


            } catch (SQLException e) {
                System.err.println("ConnectionException: "+e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException: "+e.getMessage());
        }
    }
}
