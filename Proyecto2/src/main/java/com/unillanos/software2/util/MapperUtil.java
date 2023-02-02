package com.unillanos.software2.util;

import com.unillanos.software2.controller.transfer.dto.EmpleadoDTO;
import com.unillanos.software2.model.entities.Empleado;

public class MapperUtil {

    public static Empleado dtoToEntityEmpleado(EmpleadoDTO empleadoDTO) {
        Empleado empleado = new Empleado();
        empleado.setId(empleadoDTO.getId());
        empleado.setSalario(empleadoDTO.getSalario());
        empleado.setTipo(empleadoDTO.getTipo());
        empleado.setNombre_1(empleadoDTO.getNombre_1());
        empleado.setNombre_2(empleadoDTO.getNombre_2());
        empleado.setApellido_1(empleadoDTO.getApellido_1());
        empleado.setApellido_2(empleadoDTO.getApellido_2());
        empleado.setSexo(empleadoDTO.getSexo());
        empleado.setLugar_n(empleadoDTO.getLugar_n());
        empleado.setDireccion(empleadoDTO.getDireccion());
        empleado.setTelefono(empleadoDTO.getTelefono());
        empleado.setEmail(empleadoDTO.getEmail());
        empleado.setActivo(empleadoDTO.getActivo());
        empleado.setClave(empleadoDTO.getClave());
        empleado.setFecha_n(empleadoDTO.getFecha_n());
        return empleado;
    }

    public static EmpleadoDTO entityToDtoEmpleado(Empleado empleado) {
        EmpleadoDTO empleadoDTO = new EmpleadoDTO();
        empleadoDTO.setId(empleado.getId());
        empleadoDTO.setSalario(empleado.getSalario());
        empleadoDTO.setTipo(empleado.getTipo());
        empleadoDTO.setNombre_1(empleado.getNombre_1());
        empleadoDTO.setNombre_2(empleado.getNombre_2());
        empleadoDTO.setApellido_1(empleado.getApellido_1());
        empleadoDTO.setApellido_2(empleado.getApellido_2());
        empleadoDTO.setSexo(empleado.getSexo());
        empleadoDTO.setLugar_n(empleado.getLugar_n());
        empleadoDTO.setDireccion(empleado.getDireccion());
        empleadoDTO.setTelefono(empleado.getTelefono());
        empleadoDTO.setEmail(empleado.getEmail());
        empleadoDTO.setActivo(empleado.getActivo());
        empleadoDTO.setClave(empleado.getClave());
        empleadoDTO.setFecha_n(empleado.getFecha_n());
        return empleadoDTO;
    }

}
