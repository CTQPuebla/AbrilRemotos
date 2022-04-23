package com.msefectivo.service;

import java.util.List;

import com.cajero.entity.Efectivo;
import com.cajero.request.EfectivoRequest;

public interface EfectivoService {

	Efectivo guardar(EfectivoRequest request);

	Efectivo buscar(int id);

	Efectivo actualizar(EfectivoRequest request);

	String eliminar(int id);

	List<Efectivo> mostrarTodos();

	List<String> retirar(double r);

	double checkEfectivo();

	String rellenarCajero();

}