package com.jdbc.demo.Insertion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class Update {
    public static void main(String[] args) {
    	int studentId = 3; 
        String newPlace = "San Francisco";
        String newCourse = "PhD";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/student_databases";
            Connection con = DriverManager.getConnection(url, "root", "admin");
            PreparedStatement stmt = con.prepareStatement("update students set Student_place = ?, course = ? where Student_id = ?");
            stmt.setString(1, newPlace);
            stmt.setString(2, newCourse);
            stmt.setInt(3, studentId);
            int i = stmt.executeUpdate();
            if (i > 0) 
            {
                System.out.println("Update successful for Student ID " + studentId);
            } 
            else 
            {
                System.out.println("Update failure for Student ID " + studentId);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}