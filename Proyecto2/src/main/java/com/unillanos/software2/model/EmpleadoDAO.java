/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unillanos.software2.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author oguev
 */
public class EmpleadoDAO {

    private Conexion conexion = new Conexion();

    private Connection con;

    private PreparedStatement ps;

    private ResultSet rs;

    public EmpleadoDAO() {
        con = conexion.getCon();
    }

    public List<Empleado> Listar() {
        List<Empleado> datos = new ArrayList<>();
        try {
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
            e.printStackTrace();
        }
        return datos;
    }

    //Save empleado

    public int save(Empleado e) {
        int r = 0;
        String sql = "insert into EMPLEADOS (id,tipo, nombre_1, nombre_2, apellido_1, apellido_2, sexo, fecha_n, lugar_n, direccion, telefono, email, salario, activo, clave) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, e.getId());
            ps.setString(2, e.getTipo());
            ps.setString(3, e.getNombre_1());
            ps.setString(4, e.getNombre_2());
            ps.setString(5, e.getApellido_1());
            ps.setString(6, e.getApellido_2());
            ps.setString(7, e.getSexo());
            ps.setString(8, e.getFecha_n());
            ps.setString(9, e.getLugar_n());
            ps.setString(10, e.getDireccion());
            ps.setString(11, e.getTelefono());
            ps.setString(12, e.getEmail());
            ps.setInt(13, e.getSalario());
            ps.setString(14, e.getActivo());
            ps.setString(15, e.getClave());
            r = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return r;
    }

    //Update empleado

    public int update(Empleado e) {
        int r = 0;
        String sql = "update EMPLEADOS set tipo=?, nombre_1=?, nombre_2=?, apellido_1=?, apellido_2=?, sexo=?, fecha_n=?, lugar_n=?, direccion=?, telefono=?, email=?, salario=?, activo=?, clave=? where id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, e.getTipo());
            ps.setString(2, e.getNombre_1());
            ps.setString(3, e.getNombre_2());
            ps.setString(4, e.getApellido_1());
            ps.setString(5, e.getApellido_2());
            ps.setString(6, e.getSexo());
            ps.setString(7, e.getFecha_n());
            ps.setString(8, e.getLugar_n());
            ps.setString(9, e.getDireccion());
            ps.setString(10, e.getTelefono());
            ps.setString(11, e.getEmail());
            ps.setInt(12, e.getSalario());
            ps.setString(13, e.getActivo());
            ps.setString(14, e.getClave());
            ps.setInt(15, e.getId());
            r = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return r;
    }

    //Delete empleado

    public void delete(int id) {
        String sql = "delete from EMPLEADOS where id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
