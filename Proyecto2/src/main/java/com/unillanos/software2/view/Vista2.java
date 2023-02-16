package com.unillanos.software2.view;

import org.jdesktop.swingx.JXDatePicker;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Vista2 {
    private JTextField txtid;
    private JTextField txtnombre_1;
    private JTextField txtnombre_2;
    private JTextField txtapellido_1;
    private JTextField txtapellido_2;
    private JComboBox combosex;
    private JTextField txtdireccion;
    private JTextField txttelefono;
    private JTextField txtemail;
    private JTextField txtsalario;
    private JComboBox comboactivo;
    private JTextField txtclave;
    private JTextField txtlugar;
    private JButton btnguardar;
    private JButton btnlistar;
    private JButton btneditar;
    private JButton btneliminar;
    private JTextField txtfuncionM;
    private JTextField txtfuncionO;
    private JButton jButton1;
    private JTable tabla;
    private JTable tablaOracle;
    private JXDatePicker date_n;
    private JPanel jpanelM;
    private JPanel jpanelO;


    //array de strings para tabla con atributos de la clase empleado
    private String[] columnas = {"id", "tipo", "nombre_1", "nombre_2", "apellido_1", "apellido_2", "sexo", "fecha_n", "lugar_n", "direccion", "telefono", "email", "salario", "activo", "clave"};
    private String[] columnasOracle = {"id", "tipo", "nombre_1", "nombre_2", "apellido_1", "apellido_2", "sexo", "fecha_n", "lugar_n", "direccion", "telefono", "email", "salario", "activo", "clave"};

    private void createUIComponents() {
        DefaultTableModel modelo = new DefaultTableModel(0, 15);
        DefaultTableModel modeloOracle = new DefaultTableModel(0, 15);

        modelo.setColumnIdentifiers(columnas);
        modeloOracle.setColumnIdentifiers(columnasOracle);
        tabla = new JTable(modelo);
        tablaOracle = new JTable(modeloOracle);

    }
}
