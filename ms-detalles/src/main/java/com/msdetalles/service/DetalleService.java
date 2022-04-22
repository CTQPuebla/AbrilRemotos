package com.msdetalles.service;

import java.util.List;

import com.persistence.entity.Detalle;
import com.persistence.request.DetalleRequest;


public interface DetalleService {
	
	Detalle guardar(DetalleRequest request);
	Detalle buscar(int id);
	Detalle actualizar(DetalleRequest request);
	String eliminar(int id);
	List<Detalle> mostrarTodos();

}
