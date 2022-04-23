package com.msempleados.service;

import java.util.List;

import com.persistence.entity.Empleado;
import com.persistence.request.EmpleadoRequest;

public interface EmpleadoService {
	
	Empleado guardar(EmpleadoRequest request);
	Empleado buscar(int id);
	Empleado actualizar(EmpleadoRequest request);
	String eliminar(int id);
	List<Empleado> mostrarTodos();

}
