package com.msretiros.service;

import java.util.List;

import com.persistence.entity.Informacion;
import com.persistence.entity.Respuesta;

//import org.apache.commons.lang3.tuple.Pair;

import com.persistence.entity.Retiro;
import com.persistence.request.RetiroRequest;

public interface RetiroService {
	
	//Pair<Retiro ,String>callPairFunction(float cantidadRetiro);
	//Retiro retiro(float cantidadRetiro);
	List<Informacion>infoOperacion(double cantidadRetiro);
	Respuesta respuesta(double cantidadRetiro);
	Retiro guardar(RetiroRequest request);
	Retiro buscar(int id);
	Retiro actualizar(RetiroRequest request);
	String eliminar(int id);
	List<Retiro> mostrarTodos();

}
