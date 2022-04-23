package com.msventas.controller;

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

import com.msventas.service.VentaService;
import com.persistence.entity.Venta;
import com.persistence.request.VentaRequest;

@RestController
@RequestMapping("api/ventas")
public class VentaController {

	@Autowired
	VentaService srv;

	// http://localhost:8085/api/ventas/mostrar-todos/
	@GetMapping("mostrar-todos")
	public List<Venta> listar() {
		return srv.mostrarTodos();
	}

	// http://localhost:8085/api/ventas/guardar/
	@PostMapping("guardar")
	public Venta guardar(@RequestBody VentaRequest v) {
		return srv.guardar(v);
	}

	// http://localhost:8085/api/ventas/actualizar/
	@PutMapping("actualizar")
	public Venta actualizar(@RequestBody VentaRequest v) {
		return srv.actualizar(v);
	}

	// http://localhost:8085/api/ventas/buscar-por-id/
	@GetMapping("buscar-por-id/{id}")
	public Venta buscar(@PathVariable int id) {
		return srv.buscar(id);
	}

	// http://localhost:8085/api/ventas/eliminar/?
	@DeleteMapping("eliminar/{id}")
	public String eliminar(@PathVariable int id) {
		return srv.eliminar(id);
	}
	
	//CONTROLLER MAPEADOS
	

}
