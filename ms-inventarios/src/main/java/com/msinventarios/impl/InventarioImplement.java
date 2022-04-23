package com.msinventarios.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msinventarios.service.InventarioService;
import com.persistence.entity.Inventario;
import com.persistence.repository.InventarioRepository;
import com.persistence.repository.ProductoRepository;
import com.persistence.request.InventarioRequest;

@Service
public class InventarioImplement implements InventarioService {

	// inyeccion de dependencias - exponer la funcionalidad de una clase/interface
	// en otra
	@Autowired
	InventarioRepository repo;
	
	@Autowired
	ProductoRepository prodrepo;

	// principio hollywood: no me llames yo te busco despues

	@Override
	public Inventario guardar(InventarioRequest request) {
		
		//Primero se buscar al cliente en la BD
		
		prodrepo.buscarActivo(request.getProducto().getProductoId());
		Inventario i = new Inventario();
		i.setInventarioId(request.getInventarioId());
		i.setProducto(request.getProducto());
		i.setStock(request.getStock());
		i.setFechaResurtido(request.getFechaResurtido());
		repo.save(i);
		return i;
	}

	@Override
	public Inventario buscar(int id) {
		// Esto devuelve un Optional (clase envoltorio)
		// Es necesario sacar el objeto del envoltorio con el metodo .get()

		return repo.findById(id).get();
	}
	
	@Override
	public Inventario actualizar(InventarioRequest request) {
		prodrepo.buscarActivo(request.getProducto().getProductoId());
		
		Inventario i = new Inventario();
		i.setInventarioId(request.getInventarioId());
		i.setProducto(request.getProducto());
		i.setStock(request.getStock());
		i.setFechaResurtido(request.getFechaResurtido());
		repo.save(i);
		return i;
	}

	@Override
	public String eliminar(int id) {
		repo.deleteById(id);
		return "Eliminado";
	}

	@Override
	public List<Inventario> mostrarTodos() {
		// TODO Auto-generated method stub
		return repo.findAll();
		
	}

}
