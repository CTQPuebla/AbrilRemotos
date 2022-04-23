package com.msefectivo.service;

import java.util.List;

import com.persistencia.entity.Efectivo;
import com.persistencia.request.EfectivoRequest;



public interface EfectivoService {

	Efectivo actualizar(EfectivoRequest request);
	
	Efectivo retiro (EfectivoRequest request);
    
    List<Efectivo> mostrarTodos();
}
