package com.jdbc.demo.Insertion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class Delete {
    public static void main(String[] args) {
    	int studentId = 4; 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/student_databases";
            Connection con = DriverManager.getConnection(url, "root", "admin");
            PreparedStatement stmt = con.prepareStatement("Delete from students where Student_id = ?");
            stmt.setInt(1, studentId);
            int i = stmt.executeUpdate();
            if (i > 0) 
            {
                System.out.println("Deletion successful for Student ID " + studentId);
            } 
            else 
            {
                System.out.println("Deletion failure for Student ID " + studentId);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}