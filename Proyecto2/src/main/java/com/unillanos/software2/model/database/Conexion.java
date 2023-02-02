/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unillanos.software2.model.database;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Getter
public class Conexion {

    private static Connection mySqlConnection;

    private static Connection oracleConnection;

    private static Conexion conexion;

    private Conexion() {
        mySqlConnection = mySqlConnection();
        oracleConnection = oracleConnection();
    }

    public static Conexion getInstance() {
        if (conexion==null){
            conexion = new Conexion();
        }
        System.out.println(conexion);
        return conexion;
    }

    public Connection getMySqlConnection(){
        return mySqlConnection;
    }

    public Connection getOracleConnection(){
        return oracleConnection;
    }

    private static Connection mySqlConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://unillanos-database.cnl6g0a6mx4w.sa-east-1.rds.amazonaws.com:3306/unillanos", "admin", "Un1ll4n0s123");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    // init database constants
    // com.mysql.jdbc.Driver
    private static final String DATABASE_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DATABASE_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USERNAME = "Henrro";
    private static final String PASSWORD = "henrro";

    private static Connection connection;
    private static Properties properties;

    private static Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
        }
        return properties;
    }

    private static Connection oracleConnection() {
        if (connection == null) {
            try {
                Class.forName(DATABASE_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, getProperties());
                connection.setAutoCommit(false);
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return connection;
    }

}
