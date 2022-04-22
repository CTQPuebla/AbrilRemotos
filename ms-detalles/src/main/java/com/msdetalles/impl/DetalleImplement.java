package com.msdetalles.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.msdetalles.service.DetalleService;
import com.persistence.entity.Detalle;
import com.persistence.entity.Venta;
import com.persistence.repository.DetalleRepository;
import com.persistence.repository.VentaRepository;
import com.persistence.request.DetalleRequest;

@Service
public class DetalleImplement implements DetalleService{
	
	//Inyeccion de dependencias - exponer la funcionalidad de una clase/interface en otra
	@Autowired
	DetalleRepository repo;
	
	@Autowired
	VentaRepository ventarepo;
	
	RestTemplate plantilla = new RestTemplate();//

	@Override
	public Detalle guardar(DetalleRequest request) {
		
		//Para persistir una venta, debo tener al objeto cliente(existente en la db) ya listo
		//Venta venta = ventarepo.buscar(request.getVenta().getVentaId());
		int ventaId = request.getVenta().getVentaId();
		String url = "http://localhost:8095/api/ventas/buscar-por-id/"+ventaId;
		Venta venta = plantilla.getForObject(url, Venta.class);

		Detalle d = new Detalle();
		
		//d.setDtvId(request.getDtvId());
		d.setVenta(venta);
		d.setProductoId(request.getProductoId());
		d.setCantidad(request.getCantidad());
		
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
		Detalle d = repo.findById(request.getDtvId()).get();
		
		d.setDtvId(request.getDtvId());
		d.setVenta(request.getVenta());
		d.setProductoId(request.getProductoId());
		d.setCantidad(request.getCantidad());
		
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
