package com.msdinero.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msdinero.service.DineroService;
import com.persistence.entity.Dinero;
import com.persistence.repository.DineroRepository;
import com.persistence.request.DineroRequest;


@Service
public class DineroImplement implements DineroService{

	
	//Inyeccion de dependencias - exponer la funcionalidad de una clase/interface en otra
	@Autowired
	DineroRepository repo;

	@Override
	public Dinero buscar(int id) {
		//Esto devuelve un Optional (Clase envoltorio)
		//Es necesario sacar el objeto del envoltorio con el metodo .get()
		return repo.buscar(id);
	}

	@Override
	public Dinero actualizar(DineroRequest request) {
		
		//Primero busco aquello que quiero actualizar
		Dinero d = repo.buscar(request.getDineroId());
		
		d.setTipo(request.getTipo());
		d.setCantidad(request.getCantidad());
		d.setDenominacion(request.getDenominacion());
		
		repo.save(d);
		
		return d;
	}

	@Override
	public String eliminar(int id) {
		
		repo.deleteById(id);
		
		return "Eliminado";
	}

	@Override
	public List<Dinero> mostrarTodos() {
		
		return repo.mostrar();
	}

	
	

}
