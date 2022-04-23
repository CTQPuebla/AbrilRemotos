package com.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.CargoDAO;
//import com.dto.CargoDTO;
//import com.dto.EmpleadoDTO;
import com.entity.Cargo;
import com.general.Status;

@Path("cargos/")
public class CargoService {
	//Esta clase contendra los endpoints que le daran salida a la funcionalidad
	
	Cargo c = null;
	CargoDAO dao = null;
	//CargoDTO edto=null;
	
	
	//Cada metodo necesita su propio PATH
	
	
	//http://localhost:8085/hibernate/hibernate/cargos/mostrar GET
	@Path("mostrar")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Cargo>mostrarCargos(){
		
		dao = new CargoDAO();
		List <Cargo> list = dao.mostrarTodos();
		return list;
	}
	
	//http://localhost:8085/hibernate/hibernate/cargos/guardar POST
	@Path ("guardar")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Status guardar(Cargo c) {
		
		Status s = new Status();
		s.setOb(c);
		
		dao = new CargoDAO();
		
		String resp = (String)dao.guardar(c);
		
		if (resp.equals("1")) {
			s.setMensaje("Guardado exitosamente");
			s.setRespuesta(resp);	
		} else {
			s.setMensaje("No fue posible guardar");
			s.setRespuesta(resp);
		}
		
		return s;
	}
	
	//Endpoint actualizar
	//http://localhost:8085/hibernate/hibernate/cargos/actualizar POST
	@Path ("actualizar")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Status actualizar(Cargo c) {
		
		Status s = new Status();
		s.setOb(c);
		dao = new CargoDAO();
		
		String res=(String) dao.actualizar(c);
		
		if (res.equals("1")) {
			s.setMensaje("Registro actualizado");
			s.setRespuesta(res);
		} else {
			s.setMensaje("No fue posible actualizar");
			s.setRespuesta(res);
		}
		return s;
	}
	
	//Metodo eliminar
	//http://localhost:8085/hibernate/hibernate/cargos/eliminar/1
	@Path ("eliminar/{id}")
	@GET	
	@Produces({MediaType.APPLICATION_JSON})
	public Status eliminar(@PathParam("id")int id){
		
		Status s= new Status();
		dao = new CargoDAO();
		s.setOb(c);
		
		String res =(String) dao.eliminar(id);
		if (res.equals("1")) {
			s.setMensaje("Eliminado exitosamente");
			s.setRespuesta(res);
			
			
		} else {
			s.setMensaje("No fue posible eliminar");
			s.setRespuesta(res);
	
		}
		return s;
	}
	
	//http://localhost:8085/hibernate/hibernate/cargos/buscar-por-id/2 GET
	@Path ("buscar-por-id/{id}")
	@GET	
	@Produces({MediaType.APPLICATION_JSON})
	public Cargo buscar(@PathParam("id")int id) {
		dao= new CargoDAO();
		c =(Cargo) dao.buscar(id);
		System.out.println("OK");
			
		return c;
	}
	
	//ESTOS SON LOS JOINNN-----------------------------------------------
	//http://localhost:8085/jdbc-web/jdbc-web/cargos/empleados-por-cargo/1
	//GET
//	@Path("empleados-por-cargo/{id}")
//	@GET
//	@Produces({MediaType.APPLICATION_JSON})
//	public CargoDTO empleadosPorCargo(@PathParam("id")int id) {
//		dao = new CargoDAO();
//		//CargoDTO dto=(CargoDTO) dao.empleadosPorCargo(id);
//		edto=(CargoDTO) dao.empleadosPorCargo(id);
//		return edto;
//	}
//--------------------------------------------------------------------------
}