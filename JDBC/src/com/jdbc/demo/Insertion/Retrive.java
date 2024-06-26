package com.jdbc.demo.Insertion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class Retrive {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//Loading JDBC Driver
            String url = "jdbc:mysql://localhost:3306/student_databases";//Define connection URL // Port number Username Password database name 
            Connection con = DriverManager.getConnection(url, "root", "admin");// Establish the Connection
            Statement stmt=con.createStatement();//Creating statement
		    ResultSet rs=stmt.executeQuery("select * from students");//Execute Query //ResultSet
            while (rs.next()) 
            {
                System.out.println("ID: " + rs.getInt("Student_id"));
                System.out.println("Name: " + rs.getString("Student_name"));
                System.out.println("Place: " + rs.getString("Student_place"));
                System.out.println("Course: " + rs.getString("course"));
                System.out.println("Contact: " + rs.getString("contact_num"));
            }
            con.close();//Close Db Connection
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}