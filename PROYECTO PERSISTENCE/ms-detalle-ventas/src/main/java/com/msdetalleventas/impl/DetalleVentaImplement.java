package com.msdetalleventas.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.msdetalleventas.service.DetalleVentaService;
import com.persistence.entity.DetalleVenta;
import com.persistence.entity.Venta;
import com.persistence.repository.DetalleVentaRepository;
import com.persistence.repository.ProductoRepository;
import com.persistence.repository.VentaRepository;
import com.persistence.request.DetalleVentaRequest;

@Service
public class DetalleVentaImplement implements DetalleVentaService {

	// inyeccion de dependencias - exponer la funcionalidad de una clase/interface
	// en otra
	@Autowired
	DetalleVentaRepository repo;
	
	@Autowired
	VentaRepository vtarepo;
	
	@Autowired
	ProductoRepository prodrepo;
	RestTemplate plantilla=new RestTemplate();
	// principio hollywood: no me llames yo te busco despues

	@Override
	public DetalleVenta guardar(DetalleVentaRequest request) {
		
		String url = "http://localhost:8085/api/ventas/buscar-por-id/"+vtarepo.findById(request.getVenta().getVentaId());
		vtarepo=(VentaRepository) plantilla.getForObject(url, Venta.class);
		
		//vtarepo.findById(request.getVenta().getVentaId());
		prodrepo.buscarActivo(request.getProducto().getProductoId());
		DetalleVenta dtv = new DetalleVenta();
		dtv.setVenta(request.getVenta());
		dtv.setProducto(request.getProducto());
		dtv.setCantidad(request.getCantidad());
		repo.save(dtv);
		return dtv;
	}

//	@Override
//	public Empleado buscar(int id) {
//		// Esto devuelve un Optional (clase envoltorio)
//		// Es necesario sacar el objeto del envoltorio con el metodo .get()
//
//		return repo.findById(id).get();
//	}
	
	@Override
	public DetalleVenta buscar(int id) {
		// Esto devuelve un Optional (clase envoltorio)
		// Es necesario sacar el objeto del envoltorio con el metodo .get()

		return repo.findById(id).get();
	}
	
	@Override
	public DetalleVenta actualizar(DetalleVentaRequest request) {
		// primero busco lo que quiero actualizar
		DetalleVenta dtv = repo.findById(request.getDtvId()).get();

		dtv.setVenta(request.getVenta());
		dtv.setProducto(request.getProducto());
		dtv.setCantidad(request.getCantidad());
		repo.save(dtv);
		return dtv;
	}

	@Override
	public String eliminar(int id) {
		// Esto devuelve un Optional (Clase envoltorio)
		repo.deleteById(id);
		// Borrado logico
		return "Eliminado";
	}

	@Override
	public List<DetalleVenta> mostrarTodos() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
}
