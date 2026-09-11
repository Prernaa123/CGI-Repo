/**
 * 
 */
package com.cgi.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 */


public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/cgi_schema";

    private static final String USER = "root";
    private static final String PASSWORD = "Pass@word1";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}