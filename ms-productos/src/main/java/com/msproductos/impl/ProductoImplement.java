package com.msproductos.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msproductos.service.ProductoService;
import com.persistence.entity.Producto;
import com.persistence.repository.ProductoRepository;
import com.persistence.request.ProductoRequest;

@Service
public class ProductoImplement implements ProductoService{
	
	//Inyeccion de dependencias - exponer la funcionalidad de una clase/interface en otra
	@Autowired
	ProductoRepository repo;
	

	@Override
	public Producto guardar(ProductoRequest request) {
		
		Producto p = new Producto();
		
		p.setNombre(request.getNombre());
		p.setPresentacion(request.getPresentacion());
		p.setPrecio(request.getPrecio());
		p.setFechaCad(request.getFechaCad());
		p.setMarca(request.getMarca());
		
		
		//Operacion que no necesita un valor del request
		p.setStatus(1);
		
		
		repo.save(p);
		
		return p;
	}

	@Override
	public Producto buscar(int id) {
		//Esto devuelve un Optional (Clase envoltorio)
		//Es necesario sacar el objeto del envoltorio con el metodo .get()
		return repo.buscarActivo(id);
	}

	@Override
	public Producto actualizar(ProductoRequest request) {
		//Primero busco aquello que quiero actualizar
		Producto p = repo.buscarActivo(request.getProductoId());
		
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
		//Puedo llamar al metodo findById si necesito hacer una eliminacion fisica
		//repo.deleteById(id);
		
		Producto p = repo.findById(id).get();
		p.setStatus(0);
		repo.save(p);
		return "Eliminado";
	}

	@Override
	public List<Producto> mostrarTodos() {
		
	    return repo.mostrarActivos();
	}

}
