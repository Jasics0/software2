/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unillanos.software2.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * @author oguev
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {
    int id, salario;
    String tipo, nombre_1, nombre_2, apellido_1, apellido_2, sexo, lugar_n, direccion, telefono, email, activo, clave;
    Date fecha_n;

}
