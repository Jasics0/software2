package com.unillanos.software2.model.database.implementation;

import com.unillanos.software2.model.database.Conexion;
import com.unillanos.software2.model.database.interfaces.EmpleadoRepository;
import com.unillanos.software2.model.entities.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoRepositoryImpl implements EmpleadoRepository {

    Conexion conexion;
    private final Connection mySqlConnection;

    private final Connection oracleConnection;

    private PreparedStatement ps;

    private ResultSet rs;

    public EmpleadoRepositoryImpl() {
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

    private List<Empleado> getEmpleados(String con) {
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

        } catch (Exception e) {
            e.printStackTrace();
        }
        return datos;
    }

    private int saveEmpleado(Empleado e, String con) {
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

    private int deleteEmpleado(int id, String con){
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

    private int updateEmpleado(Empleado e,String con){
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

    private String getFunction(int id, String con){
        String sql;
        try {
            if (con.equals("oracle")) {
                sql = "SELECT CANTIDAD_PAGA_EMPLEADO(?) FROM dual";
            } else {
                sql = "SELECT CANTIDAD_PAGA_EMPLEADO(?)";
            }
            ps = getConnection(con).prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            return rs.getString(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<List<Empleado>> findAll() {
        List<List<Empleado>> data = new ArrayList<>();
        List<Empleado> ora = getEmpleados("oracle");
        List<Empleado> mys = getEmpleados("mys");
        data.add(ora);
        data.add(mys);
        return data;
    }

    @Override
    public int save(Empleado empleado) {
        int saved = saveEmpleado(empleado, "oracle");
        saved *= saveEmpleado(empleado, "mys");
        return saved;
    }

    @Override
    public int delete(int empleado) {
        int deleted= deleteEmpleado(empleado,"oracle");
        deleted*= deleteEmpleado(empleado,"mys");
        return deleted;
    }

    @Override
    public int update(Empleado empleado) {
        int updated= updateEmpleado(empleado,"oracle");
        updated*= updateEmpleado(empleado,"mys");
        return updated;
    }

    @Override
    public List<String> cantidadPagaEmpleado(int id) {
        List<String> cantity= new ArrayList<>();
        cantity.add(getFunction(id,"oracle"));
        cantity.add(getFunction(id,"mys"));
        return cantity;
    }
}
