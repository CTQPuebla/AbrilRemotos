package com.msdinero.service;

import java.util.List;

import com.persistence.entity.Dinero;
import com.persistence.request.DineroRequest;

public interface DineroService {
	
	
	//Dinero guardar(DineroRequest request);
	Dinero buscar(int id);
	Dinero actualizar(DineroRequest request);
	String eliminar(int id);
	List<Dinero> mostrarTodos();
	//List<Informacion>infoOperacion();

}
