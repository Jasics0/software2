/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unillanos.software2.controller;


import com.unillanos.software2.model.Empleado;
import com.unillanos.software2.model.EmpleadoDAO;
import com.unillanos.software2.view.Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oguev
 */
public class Controlador implements ActionListener {
    
    EmpleadoDAO dao= new EmpleadoDAO();
    Empleado e = new Empleado();
    Vista vista = new Vista();
    DefaultTableModel modelo = new DefaultTableModel();
    
    public Controlador(Vista v){
        this.vista=v;
        this.vista.btnlistar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==vista.btnlistar){
            listar(vista.tabla);
        }
    }
     
    
    public void listar(JTable tabla){
        modelo = (DefaultTableModel)tabla.getModel();
        List<Empleado>lista=dao.Listar();
        Object[]object=new Object[15];
        for (int i = 0; i < lista.size(); i++) {
            object[0]=lista.get(i).getId();
            object[1]=lista.get(i).getTipo();
            object[2]=lista.get(i).getNombre_1();
            object[3]=lista.get(i).getNombre_2();
            object[4]=lista.get(i).getApellido_1();
            object[5]=lista.get(i).getApellido_2();
            object[6]=lista.get(i).getSexo();
            object[7]=lista.get(i).getFecha_n();
            object[8]=lista.get(i).getLugar_n();
            object[9]=lista.get(i).getDireccion();
            object[10]=lista.get(i).getTelefono();
            object[11]=lista.get(i).getEmail();
            object[12]=lista.get(i).getSalario();
            object[13]=lista.get(i).getActivo();
            object[14]=lista.get(i).getClave();
            modelo.addRow(object);
        }
        vista.tabla.setModel(modelo);
    }
}
