package com.bankingSystem;
import java.sql.*;

public class Conn {
    private String PASSWORD = "Piyush@0719";
    private String USID = "root";
    private Connection con;
    Statement st;

    public Conn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///bms", USID, PASSWORD);
            st = con.createStatement();
        } catch (Exception e) {
            System.out.println("Something Went Wrong");
            e.printStackTrace();
        }
    }

    public void executeQuery(String sqlQuery) {
        try {
            st.executeUpdate(sqlQuery);
            System.out.println("Query executed successfully!");
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}
