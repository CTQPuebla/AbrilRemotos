package com.msclientes.service;

import java.util.List;

import com.persistence.entity.Cliente;
import com.persistence.request.ClienteRequest;

public interface ClienteService {

	Cliente guardar(ClienteRequest request);

	Cliente buscar(int id);

	Cliente actualizar(ClienteRequest request);

	String eliminar(int id);

	List<Cliente> mostrarTodos();

}
