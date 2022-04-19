package com.msproductos.controller;

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


import com.msproductos.service.ProductoService;
import com.persistence.entity.Producto;
import com.persistence.request.ProductoRequest;

@RestController
@RequestMapping("api/productos")
public class ProductoController {
	
	@Autowired
	ProductoService srv;
	
	//http://localhost:8090/api/productos/mostrar-todos/
	@GetMapping("mostrar-todos")
	public List<Producto> listar(){
		
		return srv.mostrarTodos();
	}
	

	
	//http://localhost:8090/api/producto/buscar-por-id/?
	@GetMapping("buscar-por-id/{id}")
	public Producto buscar(@PathVariable int id){
		
		return srv.buscar(id);
	}
	
	
	//http://localhost:8090/api/productos/guardar/
	@PostMapping("guardar")
	public Producto guardar(@RequestBody ProductoRequest p) {
		
		return srv.guardar(p);
	}
	
	
	//http://localhost:8090/api/productos/actualizar/
	@PutMapping("actualizar")
	public Producto actualizar(@RequestBody ProductoRequest p) {
		
		return srv.actualizar(p);
	}
	
	
	//http://localhost:8090/api/productos/eliminar/?
	@DeleteMapping("eliminar/{id}")
	public String eliminar(@PathVariable int id){
		
		return srv.eliminar(id);
	}
	
	
}
