/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oguev
 */
public class EmpleadoDAO {

    Conexion conec = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List Listar() {
        List<Empleado> datos = new ArrayList<>();
        try {
            con = conec.con();
            ps = con.prepareStatement("select * from EMPLEADOS");
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado e = new Empleado();
                e.setId(rs.getInt(1));
                e.setTipo(rs.getString(2));
                e.setNombre_1(rs.getString(3));
                e.setNombre_2(rs.getString(4));
                e.setApellido_1(rs.getString(5));
                e.setApellido_2(rs.getString(6));
                e.setSexo(rs.getString(7));
                e.setFecha_n(rs.getString(8));
                e.setLugar_n(rs.getString(9));
                e.setDireccion(rs.getString(10));
                e.setTelefono(rs.getString(11));
                e.setEmail(rs.getString(12));
                e.setSalario(rs.getInt(13));
                e.setActivo(rs.getString(14));
                e.setClave(rs.getString(15));
                datos.add(e);
            }
        } catch (Exception e) {
        }
        return datos;
    }
}
