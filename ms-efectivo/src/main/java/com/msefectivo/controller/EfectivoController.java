package com.msefectivo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msefectivo.service.EfectivoService;
import com.cajero.entity.Efectivo;
import com.cajero.request.EfectivoRequest;

@RestController
@RequestMapping("api/efectivo")
public class EfectivoController {

	@Autowired
	EfectivoService srv;

	// http://localhost:8086/api/efectivo/mostrar-todos/
	@GetMapping("mostrar-todos")
	public List<Efectivo> listar() {
		return srv.mostrarTodos();
	}

	// http://localhost:8086/api/efectivo/guardar/
	@PostMapping("guardar")
	public Efectivo guardar(@RequestBody EfectivoRequest c) {
		return srv.guardar(c);
	}

	// http://localhost:8086/api/efectivo/actualizar/
	@PutMapping("actualizar")
	public Efectivo actualizar(@RequestBody EfectivoRequest c) {
		return srv.actualizar(c);
	}

	// http://localhost:8086/api/efectivo/buscar-por-id/
	@GetMapping("buscar-por-id/{id}")
	public Efectivo buscar(@PathVariable int id) {
		return srv.buscar(id);
	}

	// http://localhost:8086/api/efectivo/eliminar/?
	@DeleteMapping("eliminar/{id}")
	public String eliminar(@PathVariable int id) {
		return srv.eliminar(id);
	}
	
	@RequestMapping("retirar")
	public List<String> retirar(@RequestParam("monto") double r) {
        return srv.retirar(r);
    }
	
	// http://localhost:8086/api/efectivo/llenar-cajero
	@GetMapping("llenar-cajero")
	public String llenarCajero() {
		return srv.rellenarCajero();
	}
	
}