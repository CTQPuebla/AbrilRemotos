package com.msempleados.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msempleados.service.EmpleadoService;
import com.persistence.entity.Empleado;
import com.persistence.repository.EmpleadoRepository;
import com.persistence.request.EmpleadoRequest;

@Service
public class EmpleadoImplement implements EmpleadoService{

	//Inyeccion de dependencias - exponer la funcionalidad de una clase/interface en otra
	@Autowired
	EmpleadoRepository repo;
	
	
	//No me llames, yo te busco despues(principio hollywood)
	
	
	@Override
	public Empleado guardar(EmpleadoRequest request) {
		
		Empleado e = new Empleado();
		
		e.setNombre(request.getNombre());
		e.setAntiguedad(request.getAntiguedad());
		e.setSexo(request.getSexo());
		e.setEstadoCivil(request.getEstadoCivil());
		e.setFechaNac(request.getFechaNac());
		e.setCargoId(request.getCargoId());
		
		//Operacion que no necesita un valor del request
		e.setStatus(1);
		
		
		repo.save(e);
		
		return e;
	}

	@Override
	public Empleado buscar(int id) {
		//Esto devuelve un Optional (Clase envoltorio)
		//Es necesario sacar el objeto del envoltorio con el metodo .get()
		return repo.buscarActivo(id);
	}

	@Override
	public Empleado actualizar(EmpleadoRequest request) {
		
		//Primero busco aquello que quiero actualizar
		Empleado e = repo.buscarActivo(request.getEmpleadoId());
		
		e.setNombre(request.getNombre());
		e.setAntiguedad(request.getAntiguedad());
		e.setSexo(request.getSexo());
		e.setEstadoCivil(request.getEstadoCivil());
		e.setFechaNac(request.getFechaNac());
		e.setCargoId(request.getCargoId());
		
		
		repo.save(e);
		
		return e;
	}

	@Override
	public String eliminar(int id) {
		
		//Puedo llamar al metodo findById si necesito hacer una eliminacion fisica
		//repo.deleteById(id);
		
		Empleado e = repo.findById(id).get();
		e.setStatus(0);
		repo.save(e);
		return "Eliminado";
	}

	@Override
	public List<Empleado> mostrarTodos() {
		
		return repo.mostrarActivos();
	}
	
	

}
