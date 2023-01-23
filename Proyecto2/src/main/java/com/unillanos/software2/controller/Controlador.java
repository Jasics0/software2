/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unillanos.software2.controller;


import com.unillanos.software2.model.Empleado;
import com.unillanos.software2.model.EmpleadoDAO;

import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 * @author oguev
 */
public class Controlador {

    private EmpleadoDAO dao = new EmpleadoDAO();
    private Empleado e = new Empleado();


    public DefaultTableModel listar(DefaultTableModel modelo) {
        List<Empleado> lista = dao.Listar();
        Object[] object = new Object[15];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getId();
            object[1] = lista.get(i).getTipo();
            object[2] = lista.get(i).getNombre_1();
            object[3] = lista.get(i).getNombre_2();
            object[4] = lista.get(i).getApellido_1();
            object[5] = lista.get(i).getApellido_2();
            object[6] = lista.get(i).getSexo();
            object[7] = lista.get(i).getFecha_n();
            object[8] = lista.get(i).getLugar_n();
            object[9] = lista.get(i).getDireccion();
            object[10] = lista.get(i).getTelefono();
            object[11] = lista.get(i).getEmail();
            object[12] = lista.get(i).getSalario();
            object[13] = lista.get(i).getActivo();
            object[14] = lista.get(i).getClave();
            modelo.addRow(object);
        }

        return modelo;
    }

    public boolean guardar(String id, String nombre_1, String nombre_2, String apellido_1, String apellido_2, String sexo, String fecha_n, String direccion, String telefono, String email, int salario, String activo, String clave) {
        String tipo = "cc";
        String lugar_n = "Villavisexo";
        e.setId(Integer.parseInt(id));
        e.setTipo(tipo);
        e.setNombre_1(nombre_1);
        e.setNombre_2(nombre_2);
        e.setApellido_1(apellido_1);
        e.setApellido_2(apellido_2);
        e.setSexo(sexo);
        e.setFecha_n(fecha_n);
        e.setLugar_n(lugar_n);
        e.setDireccion(direccion);
        e.setTelefono(telefono);
        e.setEmail(email);
        e.setSalario(salario);
        e.setActivo(activo);
        e.setClave(clave);
        int response = dao.save(e);
        if (response == 1) {
            return true;
        } else {
            return false;
        }
    }
}
