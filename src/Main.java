/**
 * Created by rasiel on 07.04.16.
 */

import java.sql.*;
import javax.swing.*;

public class Main {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.firebirdsql.jdbc.FBDriver";
    static final String DB_URL = "jdbc:firebirdsql:class.mmcs.sfedu.ru/3050:/fbdata/shop.fdb ?encoding=UNICODE_FSS";

    //  Database credentials
    static final String USER = "IT38";
    static final String PASS = "it38";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT kol FROM operation";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int x  = rs.getInt("kol");

                //Display values
                System.out.print("\nkol: " + x);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");


        JFrame frame = new JFrame("MainFrom");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
