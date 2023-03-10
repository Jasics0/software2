/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unillanos.software2.controller;


import com.unillanos.software2.controller.transfer.dto.EmpleadoDTO;
import com.unillanos.software2.model.dao.EmpleadoDAO;
import org.apache.commons.io.IOUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author oguev
 */
public class Controlador {

    private final EmpleadoDAO dao = new EmpleadoDAO();
    private final EmpleadoDTO e = new EmpleadoDTO();

    private byte[] getBytes(String ruta) {
        File file = new File(ruta);
        try {
            FileInputStream fl = new FileInputStream(file);

            //save file in /tmp

            byte[] arr = new byte[(int) file.length()];

            fl.read(arr);
            fl.close();

            IOUtils.write(arr, new FileOutputStream("src/main/resources/images/"+ UUID.randomUUID().toString().replace("-", "") + ".jpg"));
            return arr;
        } catch (Exception a) {
            a.printStackTrace();
            System.out.println("No se encontro la imagen");
        }

        return null;

    }


    public DefaultTableModel listar(DefaultTableModel modelo, int d) {
        List<EmpleadoDTO> lista = dao.listar().get(d);
        Object[] object = new Object[16];

        for (EmpleadoDTO empleadoDTO : lista) {
            object[0] = empleadoDTO.getId();
            object[1] = empleadoDTO.getTipo();
            object[2] = empleadoDTO.getNombre_1();
            object[3] = empleadoDTO.getNombre_2();
            object[4] = empleadoDTO.getApellido_1();
            object[5] = empleadoDTO.getApellido_2();
            object[6] = empleadoDTO.getSexo();
            object[7] = empleadoDTO.getFecha_n();
            object[8] = empleadoDTO.getLugar_n();
            object[9] = empleadoDTO.getDireccion();
            object[10] = empleadoDTO.getTelefono();
            object[11] = empleadoDTO.getEmail();
            object[12] = empleadoDTO.getSalario();
            object[13] = empleadoDTO.getActivo();
            object[14] = empleadoDTO.getClave();
            try {
                byte[] bi = empleadoDTO.getRetrato();
                BufferedImage image;
                InputStream in = new ByteArrayInputStream(bi);
                image = ImageIO.read(in);
                ImageIcon imgi = new ImageIcon(image.getScaledInstance(40, 60, 0));
                object[15] = new JLabel(imgi);

            } catch (Exception ex) {
                object[15] = new JLabel("No imagen");
            }
            modelo.addRow(object);
        }
        return modelo;
    }

    public boolean guardar(String id, String nombre_1, String nombre_2, String apellido_1, String apellido_2, String sexo, Date fecha_n, String lugar_n, String direccion, String telefono, String email, int salario, String clave, String activo, String ruta) {
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
        e.setRetrato((ruta != null && !ruta.equals("")) ? getBytes(ruta) : null);
        int response = dao.save(e);
        return response == 1;
    }

    public boolean actualizar(String id, String nombre_1, String nombre_2, String apellido_1, String apellido_2, String sexo, Date fecha_n, String lugar_n, String direccion, String telefono, String email, int salario, String clave, String activo) {
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
        int response = dao.update(e);
        return response == 1;
    }

    public boolean eliminar(int id) {
        int response = dao.delete(id);
        return response == 1;
    }

    public String cantidadPagaEmpleado(int id, int d) throws SQLException {
        return dao.cantidadPagaEmpleado(id).get(d);
    }
}
