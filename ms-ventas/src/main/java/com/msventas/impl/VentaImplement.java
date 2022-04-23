package com.msventas.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.msventas.service.VentaService;
import com.persistence.entity.Venta;
import com.persistence.repository.ClienteRepository;
import com.persistence.repository.VentaRepository;
import com.persistence.request.VentaRequest;

@Service
public class VentaImplement implements VentaService {

	// inyeccion de dependencias - exponer la funcionalidad de una clase/interface
	// en otra
	@Autowired
	VentaRepository repo;
	
	@Autowired
	ClienteRepository clirepo;

	// principio hollywood: no me llames yo te busco despues

	@Override
	public Venta guardar(VentaRequest request) {
		
		//Primero se buscar al cliente en la BD
		
		clirepo.buscarActivo(request.getCliente().getClienteId());

		Venta v = new Venta();
		v.setVentaId(request.getVentaId());
		v.setCliente(request.getCliente());
		v.setFechaVenta(request.getFechaVenta());
		repo.save(v);
		return v;
	}

	@Override
	public Venta buscar(int id) {
		// Esto devuelve un Optional (clase envoltorio)
		// Es necesario sacar el objeto del envoltorio con el metodo .get()

		return repo.findById(id).get();
	}
	
	@Override
	public Venta actualizar(VentaRequest request) {
		clirepo.buscarActivo(request.getCliente().getClienteId());
		
		Venta v = repo.findById(request.getVentaId()).get();

		v.setVentaId(request.getVentaId());
		v.setCliente(request.getCliente());
		v.setFechaVenta(request.getFechaVenta());
		repo.save(v);

		return v;
	}

	@Override
	public String eliminar(int id) {
		repo.deleteById(id);
		return "Eliminado";
	}

	@Override
	public List<Venta> mostrarTodos() {
		// TODO Auto-generated method stub
		return repo.findAll();
		
	}
}
