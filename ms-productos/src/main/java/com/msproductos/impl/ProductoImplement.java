package com.msproductos.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msproductos.service.ProductoService;
import com.persistence.entity.Producto;
import com.persistence.repository.ProductoRepository;
import com.persistence.request.ProductoRequest;

@Service
public class ProductoImplement implements ProductoService {

	// inyeccion de dependencias - exponer la funcionalidad de una clase/interface
	// en otra
	@Autowired
	ProductoRepository repo;

	// principio hollywood: no me llames yo te busco despues

	@Override
	public Producto guardar(ProductoRequest request) {

		Producto p = new Producto();
		
		p.setNombre(request.getNombre());
		p.setPresentacion(request.getPresentacion());
		p.setPrecio(request.getPrecio());
		p.setFechaCad(request.getFechaCad());
		p.setMarca(request.getMarca());
		// operacion que no necesita un valor del request
		p.setStatus(1);
		repo.save(p);
		return p;
	}

//	@Override
//	public Empleado buscar(int id) {
//		// Esto devuelve un Optional (clase envoltorio)
//		// Es necesario sacar el objeto del envoltorio con el metodo .get()
//
//		return repo.findById(id).get();
//	}
	
	@Override
	public Producto buscar(int id) {
		// Esto devuelve un Optional (clase envoltorio)
		// Es necesario sacar el objeto del envoltorio con el metodo .get()

		return repo.buscarActivo(id);
	}
	
	@Override
	public Producto actualizar(ProductoRequest request) {
		// primero busco lo que quiero actualizar
		Producto p = repo.buscarActivo(request.getProductoId());
		//Producto p = repo.findById(request.getProductoId()).get();
		p.setNombre(request.getNombre());
		p.setPresentacion(request.getPresentacion());
		p.setPrecio(request.getPrecio());
		p.setFechaCad(request.getFechaCad());
		p.setMarca(request.getMarca());
		repo.save(p);
		return p;
	}

	@Override
	public String eliminar(int id) {
		// Esto devuelve un Optional (Clase envoltorio)
		// Borrado logico
		Producto p = repo.findById(id).get();
		p.setStatus(0);
		repo.save(p);
		return "Eliminado";
	}

	@Override
	public List<Producto> mostrarTodos() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
}
