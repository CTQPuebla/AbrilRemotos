package com.msventas.service;

import java.util.List;

import com.persistence.entity.Venta;
import com.persistence.request.VentaRequest;


public interface VentaService {
	
	Venta guardar(VentaRequest request);
	Venta buscar(int id);
	Venta actualizar(VentaRequest request);
	String eliminar(int id);
	List<Venta> mostrarTodos();

}
