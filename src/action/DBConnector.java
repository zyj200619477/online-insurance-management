package action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DBConnector {

	
    
    public static Connection getConnection() {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "insurance?serverTimezone=UTC";
        String driver = "com.mysql.cj.jdbc.Driver";
        String userName = "root";
        String password = "zyjdhr96130";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);
            System.out.println("Connected to the database");
    } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
     public static void main(String arg[]) throws SQLException{
        DBConnector.getConnection();
        String query="select * from admin";
        Connection conn=DBConnector.getConnection();
       Statement stmt=conn.createStatement();
       ResultSet rs=stmt.executeQuery(query);
       while(rs.next()) {
       System.out.println(rs.getString("adminid"));
       }
       rs.close();
       stmt.close();
       conn.close();
    }

}