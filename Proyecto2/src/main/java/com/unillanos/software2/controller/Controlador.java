/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unillanos.software2.controller;


import com.unillanos.software2.model.Conexion;
import com.unillanos.software2.model.Empleado;
import com.unillanos.software2.model.EmpleadoDAO;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @author oguev
 */
public class Controlador {

    private EmpleadoDAO dao = new EmpleadoDAO();
    private Empleado e = new Empleado();


    public DefaultTableModel listar(String con, DefaultTableModel modelo) {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
        List<Empleado> lista = dao.Listar(con);
        Object[] object = new Object[15];
        for (Empleado empleado : lista) {
            object[0] = empleado.getId();
            object[1] = empleado.getTipo();
            object[2] = empleado.getNombre_1();
            object[3] = empleado.getNombre_2();
            object[4] = empleado.getApellido_1();
            object[5] = empleado.getApellido_2();
            object[6] = empleado.getSexo();
            object[7] = empleado.getFecha_n();
            object[8] = empleado.getLugar_n();
            object[9] = empleado.getDireccion();
            object[10] = empleado.getTelefono();
            object[11] = empleado.getEmail();
            object[12] = empleado.getSalario();
            object[13] = empleado.getActivo();
            object[14] = empleado.getClave();
            modelo.addRow(object);
        }
        Conexion conexion = Conexion.getInstance();
        return modelo;
    }

    public boolean guardar(String con, String id, String nombre_1, String nombre_2, String apellido_1, String apellido_2, String sexo, Date fecha_n, String lugar_n, String direccion, String telefono, String email, int salario, String clave, String activo) {
        String tipo = "CC";
        e.setId(Integer.parseInt(id));
        e.setTipo(tipo);
        e.setNombre_1(nombre_1);
        e.setNombre_2(nombre_2);
        e.setApellido_1(apellido_1);
        e.setApellido_2(apellido_2);
        e.setSexo(sexo);
        e.setFecha_n(new java.sql.Date(fecha_n.getTime()));
        e.setLugar_n(lugar_n);
        e.setDireccion(direccion);
        e.setTelefono(telefono);
        e.setEmail(email);
        e.setSalario(salario);
        e.setActivo(activo);
        e.setClave(clave);
        int response = dao.save(con, e);
        return response == 1;
    }

    public boolean actualizar(String con, String id, String nombre_1, String nombre_2, String apellido_1, String apellido_2, String sexo, Date fecha_n, String lugar_n, String direccion, String telefono, String email, int salario, String clave, String activo) {
        String tipo = "CC";
        e.setId(Integer.parseInt(id));
        e.setTipo(tipo);
        e.setNombre_1(nombre_1);
        e.setNombre_2(nombre_2);
        e.setApellido_1(apellido_1);
        e.setApellido_2(apellido_2);
        e.setSexo(sexo);
        e.setFecha_n(new java.sql.Date(fecha_n.getTime()));
        e.setLugar_n(lugar_n);
        e.setDireccion(direccion);
        e.setTelefono(telefono);
        e.setEmail(email);
        e.setSalario(salario);
        e.setActivo(activo);
        e.setClave(clave);
        int response = dao.update(con, e);
        return response == 1;
    }

    public boolean eliminar(String con, int id) {
        int response = dao.delete(con, id);
        return response == 1;
    }

    public String cantidadPagaEmpleado(String con, int id) throws SQLException {
        return dao.cantidadPagaEmpleado(con, id);
    }
}
