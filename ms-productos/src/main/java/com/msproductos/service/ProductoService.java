package com.msproductos.service;

import java.util.List;

import com.persistence.entity.Producto;
import com.persistence.request.ProductoRequest;


public interface ProductoService {
	
	Producto guardar(ProductoRequest request);
	Producto buscar(int id);
	Producto actualizar(ProductoRequest request);
	String eliminar(int id);
	List<Producto> mostrarTodos();

}
