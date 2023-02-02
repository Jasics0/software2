/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unillanos.software2.model.dao;

import com.unillanos.software2.controller.transfer.dto.EmpleadoDTO;
import com.unillanos.software2.model.database.implementation.EmpleadoRepositoryImpl;
import com.unillanos.software2.model.entities.Empleado;
import com.unillanos.software2.model.util.MapperUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author oguev
 */
public class EmpleadoDAO {

    private final EmpleadoRepositoryImpl empleadoRepository;

    public EmpleadoDAO() {
        this.empleadoRepository = new EmpleadoRepositoryImpl();
    }


    public List<List<EmpleadoDTO>> Listar() {
        List<List<EmpleadoDTO>> response = new ArrayList<>();
        List<EmpleadoDTO> dto = new ArrayList<>();
        List<List<Empleado>> datos = empleadoRepository.findAll();

        for (int i = 0; i < 2; i++) {
            for (Empleado dato : datos.get(i)) {
                dto.add(MapperUtil.entityToDtoEmpleado(dato));
            }
            response.add(dto);
        }


        return response;
    }

    //Save empleado

    public int save(EmpleadoDTO e) {
        return empleadoRepository.save(MapperUtil.dtoToEntityEmpleado(e));
    }

    //Update empleado

    public int update(EmpleadoDTO e) {
        return empleadoRepository.update(MapperUtil.dtoToEntityEmpleado(e));
    }

    //Delete empleado

    public int delete(int id) {
        return empleadoRepository.delete(id);

    }

    public List<String> cantidadPagaEmpleado(int id) {
        return empleadoRepository.cantidadPagaEmpleado(id);
    }
}
