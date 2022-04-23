package com.msempleados.controller;

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

import com.msempleados.service.EmpleadoService;
import com.persistence.entity.Empleado;
import com.persistence.request.EmpleadoRequest;

@RestController
@RequestMapping("api/empleados")
public class EmpleadoController {

	@Autowired
	EmpleadoService srv;

	// http://localhost:8085/api/empleados/mostrar-todos/
	@GetMapping("mostrar-todos")
	public List<Empleado> listar() {
		return srv.mostrarTodos();
	}

	// http://localhost:8085/api/empleados/guardar/
	@PostMapping("guardar")
	public Empleado guardar(@RequestBody EmpleadoRequest e) {
		return srv.guardar(e);
	}

	// http://localhost:8085/api/empleados/actualizar/
	@PutMapping("actualizar")
	public Empleado actualizar(@RequestBody EmpleadoRequest e) {
		return srv.actualizar(e);
	}

	// http://localhost:8085/api/empleados/buscar-por-id/
	@GetMapping("buscar-por-id/{id}")
	public Empleado buscar(@PathVariable int id) {
		return srv.buscar(id);
	}

	// http://localhost:8085/api/empleados/eliminar/?
	@DeleteMapping("eliminar/{id}")
	public String eliminar(@PathVariable int id) {
		return srv.eliminar(id);
	}

}
