package com.msefectivo.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cajero.entity.Efectivo;
import com.cajero.repository.EfectivoRepository;
import com.cajero.request.EfectivoRequest;
import com.msefectivo.service.EfectivoService;

@Service
public class EfectivoImplement implements EfectivoService {

	// inyeccion de dependencias - exponer la funcionalidad de una clase/interface
	// en otra
	@Autowired
	EfectivoRepository repo;

	@Override
	public Efectivo guardar(EfectivoRequest request) {

		Efectivo e = new Efectivo();
		e.setTipo(request.getTipo());
		e.setDenominacion(request.getDenominacion());
		e.setExistencia(request.getExistencia());
		repo.save(e);
		return e;
	}

	@Override
	public Efectivo buscar(int id) {
		return repo.buscarId(id);
	}

	@Override
	public Efectivo actualizar(EfectivoRequest request) {
		// primero busco lo que quiero actualizar
		Efectivo e = repo.buscarId(request.getId());
		// Empleado e = repo.findById(request.getEmpleadoId()).get();
		e.setTipo(request.getTipo());
		e.setDenominacion(request.getDenominacion());
		e.setExistencia(request.getExistencia());
		repo.save(e);

		return e;
	}

	@Override
	public String eliminar(int id) {
		return "Eliminado";
	}

	@Override
	public List<Efectivo> mostrarTodos() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<String> retirar(double r) {
		String res = null;
		String out=null;
		int t=0;
		double ef=checkEfectivo();
		List<Efectivo> billetes = mostrarTodos();
		List<String> resp = new ArrayList<String>();
		int cont = 0;
		if (r <= ef ) {
			System.out.println("Su retiro de $ " + r + " se hara de la siguiente manera:");
			resp.add("Su retiro de $ " + r + " se hara de la siguiente manera:");
			for (int i = 0; i < billetes.size(); i++) {
				int id = billetes.get(i).getId();
				double denom = billetes.get(i).getDenominacion();
				String tipo = billetes.get(i).getTipo();
				int exist = billetes.get(i).getExistencia();
				while (r >= denom && cont < exist) {
					r = r - denom;
					cont++;
				}
				if (cont != 0) {
					res = +cont + " " + tipo + " de $" + denom;
					resp.add(res);
					t=exist-cont;
					Efectivo e = repo.buscarId(id);
					e.setExistencia(t);
					repo.saveAndFlush(e);
					System.out.println(res);
					cont = 0;
				} else {
					cont = 0;
				}
				
			}
			
		}
		else 
		{
			out="No hay suficiente efectivo:";
			System.out.println(out);
			resp.add(out);
		}
		resp.add("Efectivo disponible: $"+checkEfectivo());
		return resp;
	}

	@Override
	public String rellenarCajero() {
		List<Efectivo> e=mostrarTodos();
		int denom []={2,5,10,20,30,40,50,100,200,300,100};
		int l=denom.length;
		int cn=0;
		for (int i = 0; i<l; i++)
		{
			int id=e.get(cn).getId();
			int exist=denom[cn];
			Efectivo b=repo.buscarId(id);
			b.setExistencia(exist);
			repo.save(b);
			cn++;
		}
		return "Cajero Lleno! "+checkEfectivo();
	}

	@Override
	public double checkEfectivo() {
		List<Efectivo> b = mostrarTodos();
		int cn=0;
		double efe=0;
		double denom=0;
		int exist=0;
		//int id=cn+1;
		int rep=(int) repo.count();
		for (int i = 0; i < rep; i++) {
			int id=b.get(cn).getId();
			//Efectivo c=repo.buscarId(id);
			denom = b.get(cn).getDenominacion();
			exist = b.get(cn).getExistencia();
			efe=efe+(denom*exist);
			cn++;
		}
		System.out.println("Efectivo: $"+efe);
		return efe;
	}

}