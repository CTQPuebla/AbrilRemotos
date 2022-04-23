package com.msclientes.controller;

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

import com.msclientes.service.ClienteService;
import com.persistence.entity.Cliente;
import com.persistence.request.ClienteRequest;

@RestController
@RequestMapping("api/clientes")
public class ClienteController {
	
	@Autowired
	ClienteService srv;
	
	
	//http://localhost:8090/api/clientes/mostrar-todos/
	@GetMapping("mostrar-todos")
	public List<Cliente> listar(){
		
		return srv.mostrarTodos();
	}
	
	
	//http://localhost:8090/api/clientes/buscar-por-id/?
	@GetMapping("buscar-por-id/{id}")
	public Cliente buscar(@PathVariable int id){
		
		return srv.buscar(id);
	}
	
	
	
	//http://localhost:8090/api/clientes/guardar/
	@PostMapping("guardar")
	public Cliente guardar(@RequestBody ClienteRequest c) {
		
		return srv.guardar(c);
	}
		
	
	//http://localhost:8090/api/clientes/actualizar/
	@PutMapping("actualizar")
	public Cliente actualizar(@RequestBody ClienteRequest c) {
		
		return srv.actualizar(c);
	}

	
	//http://localhost:8090/api/clientes/eliminar/?
	@DeleteMapping("eliminar/{id}")
	public String eliminar(@PathVariable int id){
		
		return srv.eliminar(id);
	}
	
	
}
