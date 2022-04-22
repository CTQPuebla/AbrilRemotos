package com.msinventarios.controller;

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

import com.msinventarios.service.InventarioService;
import com.persistence.entity.Inventario;
import com.persistence.request.InventarioRequest;


@RestController
@RequestMapping("api/inventarios")
public class InventarioController {
	
	@Autowired
	InventarioService srv;
	
	//http://localhost:8090/api/inventarios/mostrar-todos/
	@GetMapping("mostrar-todos")
	public List<Inventario> listar(){
		
		return srv.mostrarTodos();
	}
	
	
	//http://localhost:8090/api/inventarios/buscar-por-id/?
	@GetMapping("buscar-por-id/{id}")
	public Inventario buscar(@PathVariable int id){
		
		return srv.buscar(id);
	}

	
	
	//http://localhost:8090/api/inventarios/guardar/
	@PostMapping("guardar")
	public Inventario guardar(@RequestBody InventarioRequest i) {
		
		return srv.guardar(i);
	}
	
	
	
	//http://localhost:8090/api/inventarios/actualizar/
	@PutMapping("actualizar")
	public Inventario actualizar(@RequestBody InventarioRequest i) {
		
		return srv.actualizar(i);
	}
	
	
	
	//http://localhost:8090/api/inventarios/eliminar/?
	@DeleteMapping("eliminar/{id}")
	public String eliminar(@PathVariable int id){
		
		return srv.eliminar(id);
	}
	
	
}
