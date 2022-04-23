package com.msretiros.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msretiros.service.RetiroService;
import com.persistence.entity.Detalle;
import com.persistence.entity.Dinero;
import com.persistence.entity.Informacion;
import com.persistence.entity.Respuesta;
import com.persistence.entity.Retiro;
import com.persistence.repository.DetalleRepository;
import com.persistence.repository.DineroRepository;
import com.persistence.repository.RetiroRepository;
import com.persistence.request.RetiroRequest;

@Service
public class RetiroImplement implements RetiroService{
	
	//Inyeccion de dependencias - exponer la funcionalidad de una clase/interface en otra
		@Autowired
		RetiroRepository repo;
		
		@Autowired
		DineroRepository dinerorepo;
		
		@Autowired
		DetalleRepository detallerepo;

		@Override
		public Retiro guardar(RetiroRequest request) {
			
			Retiro r = new Retiro();
			
			r.setCantidadRetiro(request.getCantidadRetiro());
			r.setDineroCajero(request.getDineroCajero());
			r.setFecha(request.getFecha());
			
			repo.save(r);
			
			return r;
		}

		@Override
		public Retiro buscar(int id) {
			//Esto devuelve un Optional (Clase envoltorio)
			//Es necesario sacar el objeto del envoltorio con el metodo .get()
			return repo.buscar(id);
		}

		@Override
		public Retiro actualizar(RetiroRequest request) {
			
			//Primero busco aquello que quiero actualizar
			Retiro r = repo.buscar(request.getRetiroId());
			
			r.setCantidadRetiro(request.getCantidadRetiro());
			r.setDineroCajero(request.getDineroCajero());
			r.setFecha(request.getFecha());
			
			repo.save(r);
			
			return r;
		}

		@Override
		public String eliminar(int id) {
			
			repo.deleteById(id);
			return "Eliminado";
		}

		@Override
		public List<Retiro> mostrarTodos() {
		
			return repo.mostrarTodos();
		}

		
		
		@Override
		public List<Informacion> infoOperacion(double cantidadRetiro) {
			
			double saldo, cantidadRetiro2 = cantidadRetiro;
			int cantidad = 0;
			List<Dinero> listaOb = dinerorepo.mostrar();
			List<Retiro> listaRet = new ArrayList<Retiro>();
			listaRet = repo.mostrarTodos();
			List<Informacion> listainfo = new ArrayList<Informacion>();
			
			//NOTA: Por alguna extraña razon, cuando declaro 2 objetos de un mismo tipo marca error
			//pero si solo existe 1 solo objeto de la clase en cuestion no hay ningun problema
			
			int tamaño = listaOb.size();
			int tamañoRet = listaRet.size();
			
			
			String respuesta;
			System.out.println("El ultimo id es"+ tamañoRet);
			Retiro ultimo = repo.ultimoRetiro(tamañoRet);
			//Retiro ultimo = listaRet.get(tamañoRet);
			System.out.println("El objeto es"+ ultimo);
			saldo = ultimo.getDineroCajero();		
			
			
				
			for(int i=1;i<=tamaño;i=i+1) {
				
				//tengo que hacer esta declaracion dentro del for para que realmente pueda trabajar con un 
				//nuevo objeto, porque si no, solo itera sobre el mismo objeto y nunca cambia de informacion
				Informacion info = new Informacion(); 
				
				//Primero busco aquello con lo que voy a trabajar
				Dinero dinero = new Dinero();
				dinero	= dinerorepo.buscar(i);
				
				
					while (cantidadRetiro>= dinero.getDenominacion() && dinero.getCantidad()>0) {
						//se decrementa la cantidad en la db
						dinero.setCantidad(dinero.getCantidad()-1);
						cantidad = cantidad + 1; //cantidad que se le dara al cliente	
						cantidadRetiro = cantidadRetiro - dinero.getDenominacion();
						System.out.println(cantidad+"la cantidad y denominacion"+ dinero.getDenominacion());
					
					}
					dinerorepo.save(dinero); //guardo cambios en la db	
					if (cantidad>0) {
						//establezco datos del objeto
						info.setCantidad(cantidad);
						info.setDenominacion(dinero.getDenominacion());
						listainfo.add(info); //agrego el objeto a la lista
						
						
						//envio datos a la funcion guardar detalle
						guardardetalle(cantidad,dinero.getTipo(),dinero.getDenominacion());
						
						cantidad = 0; //reseteo variable cantidad
					}
					
				
				
			}
				double saldoNuevo = saldo - cantidadRetiro2;							
				
				//se guarda el registro de retiro
				guardar(cantidadRetiro2,saldoNuevo);
			
			
			return listainfo;
		}

		

		public Void guardar(double cantidadRetiro2, double saldoNuevo) {
				//guardamos el nuevo registro de retiro
				Retiro r = new Retiro();
				
				r.setCantidadRetiro(cantidadRetiro2);
				r.setDineroCajero(saldoNuevo); //se guarda en la db el nuevo saldo
				r.setFecha(Calendar.getInstance());
				
				repo.save(r);
				return null;
				}
		
		public Void guardardetalle(int cantidad, String tipo, double denominacion) {
			
			List<Retiro> listaRet = new ArrayList<Retiro>();
			listaRet = repo.mostrarTodos();
			int tamañoRet = listaRet.size();
			Retiro retiro = repo.ultimoRetiro(tamañoRet);
			
			//guardamos el nuevo registro de detalle
			Detalle d = new Detalle();
			
			d.setRetiro(retiro);
			d.setTipo(tipo); //se guarda en la db el nuevo saldo
			d.setCantidad(cantidad);
			d.setDenominacion(denominacion);
			
			detallerepo.save(d);
			return null;
		}
		
		public Respuesta respuesta(double cantidadRetiro){
			
			List<Informacion> lista = infoOperacion(cantidadRetiro);
			
			String mensaje;
			List<Retiro> listaRet = repo.mostrarTodos();
			int tamañoRet = listaRet.size();
			Retiro ultimo = repo.ultimoRetiro(tamañoRet);
			double saldo = ultimo.getDineroCajero();	
			
			if (cantidadRetiro > saldo) {
				
				mensaje = "El saldo del cajero no es suficiente para proporcionarle la cantidad que desea,"
						+ "por favor intente con una cantidad menor";
			}
			
			else if(saldo == 0) {
				
				mensaje = "Lo sentimos por el momento el cajero no cuenta  con efectivo";
			}
			
			else{
				mensaje = "Retiro exitoso, las denominaciones que "
						+ "se le proporcionarán son las siguientes:";
			}
			
			Respuesta r = new Respuesta();
			r.setInfo(lista);
			r.setMensaje(mensaje);
			
			return r;
		}
		
		
		
		

}
