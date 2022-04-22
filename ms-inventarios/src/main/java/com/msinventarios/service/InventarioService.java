package com.msinventarios.service;

import java.util.List;

import com.persistence.entity.Inventario;
import com.persistence.request.InventarioRequest;



public interface InventarioService {
	
	Inventario guardar(InventarioRequest request);
	Inventario buscar(int id);
	Inventario actualizar(InventarioRequest request);
	String eliminar(int id);
	List<Inventario> mostrarTodos();

}
