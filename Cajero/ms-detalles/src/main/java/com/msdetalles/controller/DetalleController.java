package com.msdetalles.controller;

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

import com.msdetalles.service.DetalleService;
import com.persistence.entity.Detalle;
import com.persistence.request.DetalleRequest;

@RestController
@RequestMapping("cajero/detalles")
public class DetalleController {
	
	@Autowired
	DetalleService srv;
	
	//http://localhost:8090/cajero/detalles/mostrar-todos/
	@GetMapping("mostrar-todos")
	public List<Detalle> listar(){
		
		return srv.mostrarTodos();
	}

	
	//http://localhost:8090/cajero/detalles/buscar-por-id/?
	@GetMapping("buscar-por-id/{id}")
	public Detalle buscar(@PathVariable int id){
		
		return srv.buscar(id);
	}
	
	
	//http://localhost:8090/cajero/detalles/guardar/
	@PostMapping("guardar")
	public Detalle guardar(@RequestBody DetalleRequest d) {
		
		return srv.guardar(d);
	}
	
	
	//http://localhost:8090/cajero/detalles/actualizar/
	@PutMapping("actualizar")
	public Detalle actualizar(@RequestBody DetalleRequest d) {
		
		return srv.actualizar(d);
	}

	
	//http://localhost:8090/api/detalles/eliminar/?
	@DeleteMapping("eliminar/{id}")
	public String eliminar(@PathVariable int id){
		
		return srv.eliminar(id);
	}
	
}
