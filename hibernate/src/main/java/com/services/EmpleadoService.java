package com.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.EmpleadoDAO;
//import com.dto.EmpleadoDTO;
import com.entity.Empleado;
import com.general.Status;

@Path("empleados/")
public class EmpleadoService {
	//Esta clase contendra los endpoints que le daran salida a la funcionalidad
	
	Empleado e = null;
	EmpleadoDAO dao = null;
	//EmpleadoDTO edto = null;
	
	
	//Cada metodo necesita su propio PATH
	
	
	//http://localhost:8085/hibernate/hibernate/empleados/mostrar GET
	@Path("mostrar")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Empleado>mostrarEmpleados(){
		
		dao = new EmpleadoDAO();
		List <Empleado> list = dao.mostrarTodos();
		return list;
	}
	
	
	//http://localhost:8085/hibernate/hibernate/empleados/guardar POST
	@Path ("guardar")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Status guardar(Empleado e) {
		
		Status s = new Status();
		s.setOb(e);
		
		dao = new EmpleadoDAO();
		
		String resp = (String)dao.guardar(e);
		
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
	//http://localhost:8085/hibernate/hibernate/empleados/actualizar POST
	@Path ("actualizar")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Status actualizar(Empleado e) {
		
		Status s = new Status();
		s.setOb(e);
		dao = new EmpleadoDAO();
		
		String res=(String) dao.actualizar(e);
		
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
	//http://localhost:8085/hibernate/hibernate/empleados/eliminar/1
	@Path ("eliminar/{id}")
	@GET	
	@Produces({MediaType.APPLICATION_JSON})
	public Status eliminar(@PathParam("id")int id){
		
		Status s= new Status();
		dao = new EmpleadoDAO();
		s.setOb(e);
		
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
	
	
	//http://localhost:8085/hibernate/hibernate/empleados/buscar-por-id/2 GET
	@Path ("buscar-por-id/{id}")
	@GET	
	@Produces({MediaType.APPLICATION_JSON})
	public Empleado buscar(@PathParam("id")int id) {
		dao= new EmpleadoDAO();
		e =(Empleado) dao.buscar(id);
		System.out.println("OK");
			
		return e;
	}
	
	//http://localhost:8085/hibernate/hibernate/empleados/buscar-por-nom/2 GET
	@Path("buscar-por-nom/{nom}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Empleado> buscarNombre(@PathParam("nom")String s){		
				
			dao = new EmpleadoDAO();
			List<Empleado> list= dao.buscar(s);
			return list;
		}

//-------------------------------------------------------------------------------------------
//	//http://localhost:8085/jdbc-web/jdbc-web/empleados/empleado-cargo-info/1
//	//GET
//	@Path("empleado-cargo-info/{id}")
//	@GET
//	@Produces({MediaType.APPLICATION_JSON})
//	public EmpleadoDTO empleadoCargoInfo(@PathParam("id")int id) {
//		dao = new EmpleadoDAO();
//		edto=dao.mostrarEmpleadoCargo(id);
//		return edto;
//	}
//------------------------------------------------------------------------------------------
	
}