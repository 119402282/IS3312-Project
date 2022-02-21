package Data;

import static Data.DataBase.getInstance;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PopulateDb {
    DataBase db = getInstance();
    Connection conn = db.getConnection();
    
    public void createTables() {
        InputStream in = this.getClass().getResourceAsStream("sql/ddl.sql");
        runSql(conn, in);
    }

    public void insertData() {
        InputStream in = this.getClass().getResourceAsStream("sql/dml.sql");
        runSql(conn, in);
    }

    public void runSql(Connection conn, InputStream in) {

        String pathSep = ";";
        Scanner sc;

        sc = new Scanner(in).useDelimiter(pathSep);

        // Loop through the SQL file statements 
        Statement currStmt = null;
        while (sc.hasNext()) {

            // Get statement 
            String line = sc.next();
            try {
                // Execute statement
                currStmt = conn.createStatement();
                currStmt.execute(line);
            } catch (SQLException e) {
                System.err.println("SQLException: "+e.getMessage());
            } finally {
                
                if (currStmt != null) {
                    try {
                        currStmt.close();
                    } catch (SQLException e) {
                        System.err.println("SQLException: "+e.getMessage());
                    }
                }
                currStmt = null;
            }
        }
    }

}
