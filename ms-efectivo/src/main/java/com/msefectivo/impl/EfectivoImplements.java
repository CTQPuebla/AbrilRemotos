package com.msefectivo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.msefectivo.controller.EfectivoController;
import com.msefectivo.service.EfectivoService;
import com.persistencia.entity.Efectivo;
import com.persistencia.repository.EfectivoRepository;
import com.persistencia.request.EfectivoRequest;



@Service
public class EfectivoImplements implements EfectivoService{

	@Autowired
	EfectivoRepository repo;
	
	
	//@Override
	public Efectivo actualizar(EfectivoRequest request) {
		Efectivo e = repo.buscarActivo(request.getEfectivoId());
		e.setDenominacion(request.getDenominacion());
		e.setTipo(request.getTipo());
		e.setCantidad(request.getCantidad());
		repo.save(e);
		return e;
	}

	//@Override
	public List<Efectivo> mostrarTodos() {
		
 
		return repo.findAll();
	}
	
	public void retiro(int cantidad, int id) {
		repo.retiro( cantidad, id);
		
	}

	@Override
	public Efectivo retiro(EfectivoRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
