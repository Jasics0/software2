/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unillanos.software2.model;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;

@Getter
public class Conexion {

    private Connection con;

    public Conexion() {
        con = con();
    }

    public Connection con() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://unillanos-database.cnl6g0a6mx4w.sa-east-1.rds.amazonaws.com:3306/unillanos", "admin", "Un1ll4n0s123");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
}
