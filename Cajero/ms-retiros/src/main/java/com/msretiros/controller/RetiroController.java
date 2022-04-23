package com.msretiros.controller;

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

import com.msretiros.service.RetiroService;
import com.persistence.entity.Informacion;
import com.persistence.entity.Respuesta;
import com.persistence.entity.Retiro;
import com.persistence.request.RetiroRequest;

@RestController
@RequestMapping("cajero/retiro")
public class RetiroController {
	
	@Autowired
	RetiroService srv;
	
	
	//http://localhost:8092/cajero/retiro/mostrar-todos/
	@GetMapping("mostrar-todos")
	public List<Retiro> listar(){
		
		return srv.mostrarTodos();
	}

	
	//http://localhost:8092/cajero/retiro/buscar-por-id/?
	@GetMapping("buscar-por-id/{id}")
	public Retiro buscar(@PathVariable int id){
		
		return srv.buscar(id);
	}
	
	
	//http://localhost:8092/cajero/retiro/guardar/
	@PostMapping("guardar")
	public Retiro guardar(@RequestBody RetiroRequest r) {
		
		return srv.guardar(r);
	}
	
	
	//http://localhost:8092/cajero/retiro/actualizar/
	@PutMapping("actualizar")
	public Retiro actualizar(@RequestBody RetiroRequest r) {
		
		return srv.actualizar(r);
	}
	
	
	//http://localhost:8092/cajero/retiro/eliminar/?
	@DeleteMapping("eliminar/{id}")
	public String eliminar(@PathVariable int id){
		
		return srv.eliminar(id);
	}
	
	
	//http://localhost:8092/cajero/retiro/?
	//@GetMapping("retiro/{cantidadRetiro}")
	//public List<Informacion> info(@PathVariable double cantidadRetiro){
		
		//return srv.infoOperacion(cantidadRetiro);
	///}
	
	
	//http://localhost:8092/cajero/retiro/?
	@GetMapping("retiro/{cantidadRetiro}")
	public Respuesta res(@PathVariable double cantidadRetiro){
		
		Respuesta r = srv.respuesta(cantidadRetiro);
		
		return r;
	}
}
