package com.msinventarios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msinventarios.service.InventarioService;
import com.persistence.entity.Inventario;
import com.persistence.entity.Producto;
import com.persistence.repository.InventarioRepository;
import com.persistence.repository.ProductoRepository;
import com.persistence.request.InventarioRequest;

@Service
public class InventarioImplement implements InventarioService{
	
	//Inyeccion de dependencias - exponer la funcionalidad de una clase/interface en otra
	@Autowired
	InventarioRepository repo;
	
	@Autowired
	ProductoRepository productorepo;

	@Override
	public Inventario guardar(InventarioRequest request) {
		//Para persistir una venta, debo tener al objeto cliente(existente en la db) ya listo
		Producto producto = productorepo.buscarActivo(request.getProducto().getProductoId()); //5
				
		
		Inventario i = new Inventario();
		
		//i.setInventarioId(request.getInventarioId());
		i.setProducto(producto);
		i.setStock(request.getStock());
		i.setFecha_res(request.getFecha_res());
		
		repo.save(i);
		
		return i;
	}

	@Override
	public Inventario buscar(int id) {
		//Esto devuelve un Optional (Clase envoltorio)
		//Es necesario sacar el objeto del envoltorio con el metodo .get()
		return repo.findById(id).get();
	}

	@Override
	public Inventario actualizar(InventarioRequest request) {
		//Primero busco aquello que quiero actualizar
		Inventario i = repo.findById(request.getInventarioId()).get();
		
		i.setInventarioId(request.getInventarioId());
		i.setProducto(request.getProducto());
		i.setStock(request.getStock());
		i.setFecha_res(request.getFecha_res());
		
		repo.save(i);
				
		return i;
	}

	@Override
	public String eliminar(int id) {
		//Puedo llamar al metodo findById si necesito hacer una eliminacion fisica
		
		//Eliminacion fisica
		repo.deleteById(id);
		return "Eliminado";
	}

	@Override
	public List<Inventario> mostrarTodos() {
		return repo.findAll();
	}

}
