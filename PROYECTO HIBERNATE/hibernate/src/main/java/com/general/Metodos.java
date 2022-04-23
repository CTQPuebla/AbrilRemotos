package com.general;

import java.util.List;

import com.entity.Empleado;
import com.entity.Cargo;

//Es un contrato de operaciones o de funcionalidad
public interface Metodos {

	// Que se tiene que hacer

	// Metodos 100% abstractos, porque dice que voy a hacer pero no tiene una logica
	// definida
	// Object es la clase madre de todas las clases en Java
	Object guardar(Object o);

	Object actualizar(Object o);

	Object buscar(int id);
	
	List buscar(String nom);

	Object eliminar(int id);

	List mostrarTodos();

}