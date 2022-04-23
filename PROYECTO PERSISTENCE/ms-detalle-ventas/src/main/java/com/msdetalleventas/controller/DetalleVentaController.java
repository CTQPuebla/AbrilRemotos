package com.msdetalleventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msdetalleventas.service.DetalleVentaService;
import com.persistence.entity.DetalleVenta;
import com.persistence.request.DetalleVentaRequest;

@RestController
@RequestMapping("api/detalle-ventas")
public class DetalleVentaController {
	
	@Autowired
	DetalleVentaService srv;

	// http://localhost:8085/api/detalle-ventas/mostrar-todos/
	@GetMapping("mostrar-todos")
	public List<DetalleVenta> listar() {
		return srv.mostrarTodos();
	}

	// http://localhost:8085/api/detalle-ventas/guardar/
	@PostMapping("guardar")
	public DetalleVenta guardar(@RequestBody DetalleVentaRequest e) {
		return srv.guardar(e);
	}

	// http://localhost:8085/api/detalle-ventas/actualizar/
	@PutMapping("actualizar")
	public DetalleVenta actualizar(@RequestBody DetalleVentaRequest e) {
		return srv.actualizar(e);
	}

	// http://localhost:8085/api/detalle-ventas/buscar-por-id/
	@GetMapping("buscar-por-id/{id}")
	public DetalleVenta buscar(@PathVariable int id) {
		return srv.buscar(id);
	}

	// http://localhost:8085/api/detalle-ventas/eliminar/?
	@DeleteMapping("eliminar/{id}")
	public String eliminar(@PathVariable int id) {
		return srv.eliminar(id);
	}

}