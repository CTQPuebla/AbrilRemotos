package com.msclientes.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msclientes.service.ClienteService;
import com.persistence.entity.Cliente;
import com.persistence.repository.ClienteRepository;
import com.persistence.request.ClienteRequest;

@Service
public class ClienteImplement implements ClienteService{
	
	//Inyeccion de dependencias - exponer la funcionalidad de una clase/interface en otra
	@Autowired
	ClienteRepository repo;

	@Override
	public Cliente guardar(ClienteRequest request) {
		Cliente c = new Cliente();
		
		c.setNombre(request.getNombre());
		c.setTelefono(request.getTelefono());
		c.setCorreo(request.getCorreo());
		//c.setStatus(request.getStatus());
		
		
		//Operacion que no necesita un valor del request
		c.setStatus(1);
		
		
		repo.save(c);
		
		return c;
	}

	@Override
	public Cliente buscar(int id) {
		//Esto devuelve un Optional (Clase envoltorio)
		//Es necesario sacar el objeto del envoltorio con el metodo .get()
		return repo.buscarActivo(id);
	}

	@Override
	public Cliente actualizar(ClienteRequest request) {
		//Primero busco aquello que quiero actualizar
		Cliente c = repo.buscarActivo(request.getClienteId());
		
		c.setNombre(request.getNombre());
		c.setTelefono(request.getTelefono());
		c.setCorreo(request.getCorreo());
		c.setStatus(request.getStatus());
		
		repo.save(c);
		
		return c;
	}

	@Override
	public String eliminar(int id) {
		//Puedo llamar al metodo findById si necesito hacer una eliminacion fisica
		//repo.deleteById(id);
		
		Cliente c = repo.findById(id).get();
		c.setStatus(0);
		repo.save(c);
		return "Eliminado";
	}

	@Override
	public List<Cliente> mostrarTodos() {
		
		return repo.mostrarActivos();
	}

	
}
