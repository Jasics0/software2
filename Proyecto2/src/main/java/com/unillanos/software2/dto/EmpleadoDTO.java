package com.unillanos.software2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDTO {

    private int id, salario;
    private String tipo;

    private String nombre_1;

    private String nombre_2;

    private String apellido_1;

    private String apellido_2;

    private String sexo;

    private String lugar_n;

    private String direccion;

    private String telefono;

    private String email;

    private String activo;

    private String clave;

    private Date fecha_n;

}
