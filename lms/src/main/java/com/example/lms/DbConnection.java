package com.example.lms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
    String sqlquery = "CREATE TABLE IF NOT EXISTS book( id SERIAL PRIMARY KEY, book_name VARCHAR(50) NOT NULL, author VARCHAR(30) NOT NULL);";
    String url = System.getenv("URL");
    String user = System.getenv("USERNAME");
    String password = System.getenv("PASSWORD");
    Connection con;

    {
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to PostgreSQL database");
            Statement st = con.createStatement();
            st.executeUpdate(sqlquery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

