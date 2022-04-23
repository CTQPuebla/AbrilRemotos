package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.query.Query;

import com.entity.Empleado;
import com.general.Metodos;

public class EmpleadoDAO implements Metodos {

	// Carga las clases definidas en el persistence
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Tables");
	// Carga todas las operaciones (insert, delete, update etc)
	EntityManager em = emf.createEntityManager();
	// Objeto comodin
	Empleado e = null;

	@Override
	public String guardar(Object ob) {
		// Castear el objeto generico a algo especifico
		e = (Empleado) ob;
		String resultado = null;
		// inicia la transaccion
		em.getTransaction().begin();
		try {
			// aqui se realiza el guardado o persistencia
			em.persist(e);
			em.getTransaction().commit();
			resultado = "1";
			System.out.print("Insertado");
		} catch (Exception ex) {
			// Deshace los cambios
			em.getTransaction().rollback();
			System.out.print("No se pudo insertar");
			resultado = ex.getMessage();
		}
		return resultado;
	}

	@Override
	public Object actualizar(Object o) {

		// Objeto que contiene la informacion que existe en la BD
		e = (Empleado) o;
		Empleado emdb = em.find(Empleado.class, e.getEmpleadoId());
		String r = null;
		em.getTransaction().begin();
		try {
			emdb.setNombre(e.getNombre());
			emdb.setAntiguedad(e.getAntiguedad());
			emdb.setSexo(e.getSexo());
			emdb.setEstadoCivil(e.getEstadoCivil());
			emdb.setFechaNac(e.getFechaNac());
			emdb.setCargoId(e.getCargoId());
			em.getTransaction().commit();
			r="1";
		} catch (Exception ex) {
			em.getTransaction().rollback();
			System.out.print("No se pudo editar");
			r = ex.getMessage();
		}

		return r;
	}

	@Override
	public Object buscar(int id) {
		// Forma anterior
		e = em.find(Empleado.class, id);
		return e;
	}
	@Override
	public List<Empleado> buscar(String s) {	

		List <Empleado> ls = em.createQuery("from Empleado e where e.nombre= :nom",
				Empleado.class).setParameter("nom",s).getResultList();
		return ls;
	}
	
	@Override
	public String eliminar(int id) {
		String r = null;

		e = em.find(Empleado.class, id);
		em.getTransaction().begin();
		try {
			em.remove(e); // Elimina
			em.getTransaction().commit();
			System.out.println("Se ha eliminado el registro");
			r = "1";

		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("No se pudo eliminar");
			r = e.getMessage();
		}
		return r;
	}

	@Override
	public List<Empleado> mostrarTodos() {
		List<Empleado> ls = em.createQuery("from Empleado", Empleado.class).getResultList();
		System.out.println(ls.getClass().getTypeName());
		return ls;
	}
	
}