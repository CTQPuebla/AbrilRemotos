package com.msdinero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msdinero.service.DineroService;
import com.persistence.entity.Dinero;
import com.persistence.request.DineroRequest;

@RestController
@RequestMapping("cajero/dinero")
public class DineroController {
	
	@Autowired
	DineroService srv;
	
	//http://localhost:8091/cajero/dinero/mostrar-todos/
	@GetMapping("mostrar-todos")
	public List<Dinero> listar(){
		
		return srv.mostrarTodos();
	}

	
	//http://localhost:8091/cajero/dinero/buscar-por-id/?
	@GetMapping("buscar-por-id/{id}")
	public Dinero buscar(@PathVariable int id){
		
		return srv.buscar(id);
	}
	
	
	
	//http://localhost:8091/cajero/dinero/actualizar/
	@PutMapping("actualizar")
	public Dinero actualizar(@RequestBody DineroRequest d) {
		
		return srv.actualizar(d);
	}
	
	
	//http://localhost:8091/cajero/dinero/eliminar/?
	@DeleteMapping("eliminar/{id}")
	public String eliminar(@PathVariable int id){
		
		return srv.eliminar(id);
	}
	
}
