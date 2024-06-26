package com.jdbc.demo.Insertion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ProjectJDBC {
    public static void main(String[] args) {
    	 String[] names = {"Alice", "Bob", "Charlie", "David", "Eve"};
         String[] places = {"New York", "Los Angeles", "Chicago", "Houston", "Phoenix"};
         String[] courses = {"B.Tech", "M.Tech", "MBA", "B.Sc", "M.Sc"};
         String[] contactNums = {"1234567890", "2345678901", "3456789012", "4567890123", "5678901234"};
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// Loading JDBC Driver
            String url = "jdbc:mysql://localhost:3306/student_databases";//Define connection URL // Port number Username Password database name 
            Connection con = DriverManager.getConnection(url, "root", "admin");// Establish the Connection
            PreparedStatement stmt = con.prepareStatement("insert into students(Student_name, Student_place, course, contact_num)values(?, ?, ?, ?)");// Creating Statement);
            // Set parameters
            for (int j = 0; j < names.length; j++) 
            {
            	stmt.setString(1, names[j]);
                stmt.setString(2, places[j]);
                stmt.setString(3, courses[j]);
                stmt.setString(4, contactNums[j]);
                int i = stmt.executeUpdate();//Execute Query
                if (i > 0) 
                {
                    System.out.println("Insertion successful for " + names[j]);
                } else 
                {
                    System.out.println("Insertion failure for " + names[j]);
                }
            }
            con.close();//Close Db Connection
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}