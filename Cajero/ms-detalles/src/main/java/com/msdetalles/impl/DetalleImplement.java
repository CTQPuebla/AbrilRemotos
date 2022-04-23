package com.msdetalles.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.msdetalles.service.DetalleService;
import com.persistence.entity.Detalle;
import com.persistence.entity.Retiro;
import com.persistence.repository.DetalleRepository;
import com.persistence.request.DetalleRequest;

@Service
public class DetalleImplement implements DetalleService{
	
	//Inyeccion de dependencias - exponer la funcionalidad de una clase/interface en otra
	@Autowired
	DetalleRepository repo;
	
	RestTemplate plantilla = new RestTemplate();//
	

	@Override
	public Detalle guardar(DetalleRequest request) {
		//Para persistir una venta, debo tener al objeto cliente(existente en la db) ya listo
		//Venta venta = ventarepo.buscar(request.getVenta().getVentaId());
		int retiroId = request.getRetiro().getRetiroId();
		String url = "http://localhost:8092/cajero/retiro/buscar-por-id/"+retiroId;
		Retiro retiro = plantilla.getForObject(url, Retiro.class);

		Detalle d = new Detalle();
		
		//d.setDtvId(request.getDtvId());
		d.setRetiro(retiro);
		d.setTipo(request.getTipo());
		d.setCantidad(request.getCantidad());
		d.setDenominacion(request.getDenominacion());
		
		repo.save(d);
		
		return d;
	}

	@Override
	public Detalle buscar(int id) {
		//Esto devuelve un Optional (Clase envoltorio)
		//Es necesario sacar el objeto del envoltorio con el metodo .get()
		return repo.findById(id).get();
	}

	@Override
	public Detalle actualizar(DetalleRequest request) {
		//Primero busco aquello que quiero actualizar
		Detalle d = repo.findById(request.getDtrId()).get();
		
		d.setRetiro(request.getRetiro());
		d.setTipo(request.getTipo());
		d.setCantidad(request.getCantidad());
		d.setDenominacion(request.getDenominacion());
		
		repo.save(d);
		
		return d;
	}

	@Override
	public String eliminar(int id) {
		//Puedo llamar al metodo findById si necesito hacer una eliminacion fisica
		//Eliminacion fisica
		repo.deleteById(id);
		return "Eliminado";
	}

	@Override
	public List<Detalle> mostrarTodos() {
		return repo.findAll();
	}

}
