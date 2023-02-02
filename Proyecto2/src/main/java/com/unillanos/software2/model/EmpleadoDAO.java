/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unillanos.software2.model;

import com.unillanos.software2.dto.EmpleadoDTO;
import com.unillanos.software2.util.MapperUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author oguev
 */
public class EmpleadoDAO {
    Conexion conexion;
    private final Connection mySqlConnection;

    private final Connection oracleConnection;

    private PreparedStatement ps;

    private ResultSet rs;

    public EmpleadoDAO() {
        conexion = Conexion.getInstance();
        mySqlConnection = conexion.getMySqlConnection();
        oracleConnection = conexion.getOracleConnection();
    }

    public Connection getConnection(String conexion) {
        if (conexion.equals("oracle")) {
            return this.oracleConnection;
        } else {
            return this.mySqlConnection;
        }
    }

    public List<EmpleadoDTO> Listar(String con) {
        List<EmpleadoDTO> response = new ArrayList<>();
        List<Empleado> datos = new ArrayList<>();
        try {
            ps = getConnection(con).prepareStatement("select * from EMPLEADOS order by identificacion");
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
                e.setFecha_n(rs.getDate(8));
                e.setLugar_n(rs.getString(9));
                e.setDireccion(rs.getString(10));
                e.setTelefono(rs.getString(11));
                e.setEmail(rs.getString(12));
                e.setSalario(rs.getInt(13));
                e.setActivo(rs.getString(14));
                e.setClave(rs.getString(15));
                datos.add(e);
            }
            for (Empleado dato : datos) {
                response.add(MapperUtil.entityToDtoEmpleado(dato));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    //Save empleado

    public int save(String con, EmpleadoDTO e) {
        int r = 0;
        String sql = "insert into EMPLEADOS (identificacion,tipo, nombre_1, nombre_2, apellido_1, apellido_2, sexo, fecha_n, lugar_n, direccion, telefono, email, salario, activo, clave) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = getConnection(con).prepareStatement(sql);
            ps.setInt(1, e.getId());
            ps.setString(2, e.getTipo());
            ps.setString(3, e.getNombre_1());
            ps.setString(4, e.getNombre_2());
            ps.setString(5, e.getApellido_1());
            ps.setString(6, e.getApellido_2());
            ps.setString(7, e.getSexo());
            ps.setDate(8, e.getFecha_n());
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

    public int update(String con, EmpleadoDTO e) {
        int r = 0;
        String sql = "update EMPLEADOS set tipo=?, nombre_1=?, nombre_2=?, apellido_1=?, apellido_2=?, sexo=?, fecha_n=?, lugar_n=?, direccion=?, telefono=?, email=?, salario=?, activo=?, clave=? where identificacion=?";
        try {
            ps = getConnection(con).prepareStatement(sql);
            ps.setString(1, e.getTipo());
            ps.setString(2, e.getNombre_1());
            ps.setString(3, e.getNombre_2());
            ps.setString(4, e.getApellido_1());
            ps.setString(5, e.getApellido_2());
            ps.setString(6, e.getSexo());
            ps.setDate(7, e.getFecha_n());
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

    public int delete(String con, int id) {
        String sql = "delete from EMPLEADOS where identificacion=?";
        int r = 0;
        try {
            ps = getConnection(con).prepareStatement(sql);
            ps.setInt(1, id);
            r = ps.executeUpdate();
            if (con.equals("oracle")) {
                getConnection(con).commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    public String cantidadPagaEmpleado(String con, int id) throws SQLException {
        String sql;
        int r = 0;
        try {
            if (con.equals("oracle")) {
                sql = "SELECT CANTIDAD_PAGA_EMPLEADO(?) FROM dual";
            } else {
                sql = "SELECT CANTIDAD_PAGA_EMPLEADO(?)";
            }
            ps = getConnection(con).prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        rs.next();
        return rs.getString(1);
    }
}
