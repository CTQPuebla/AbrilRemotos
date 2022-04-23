package com.msdetalleventas.service;

import java.util.List;

import com.persistence.entity.DetalleVenta;
import com.persistence.request.DetalleVentaRequest;

public interface DetalleVentaService {

	DetalleVenta guardar(DetalleVentaRequest request);

	DetalleVenta buscar(int id);

	DetalleVenta actualizar(DetalleVentaRequest request);

	String eliminar(int id);

	List<DetalleVenta> mostrarTodos();
}
