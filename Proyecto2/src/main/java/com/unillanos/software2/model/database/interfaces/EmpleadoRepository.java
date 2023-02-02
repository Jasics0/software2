package com.unillanos.software2.model.database.interfaces;

import com.unillanos.software2.model.entities.Empleado;

import java.util.List;

public interface EmpleadoRepository {
    List<List<Empleado>> findAll();

    int save(Empleado empleado);

    int delete(int id);

    int update(Empleado empleado);

    List<String> cantidadPagaEmpleado(int id);
}
