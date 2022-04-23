package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entity.Cargo;
import com.general.Metodos;

public class CargoDAO implements Metodos {

	// Carga las clases definidas en el persistence
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Tables");
	// Carga todas las operaciones (insert, delete, update etc)
	EntityManager em = emf.createEntityManager();
	// Objeto comodin
	Cargo c = null;

	@Override
	public String guardar(Object ob) {
		// Castear el objeto generico a algo especifico
		c = (Cargo) ob;
		String resultado = null;
		// inicia la transaccion
		em.getTransaction().begin();
		try {
			// aqui se realiza el guardado o persistencia
			em.persist(c);
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
		Cargo cardb = em.find(Cargo.class, c.getCargoId());
		String r = null;
		em.getTransaction().begin();
		try {
			cardb.setDescripcion(c.getDescripcion());
			cardb.setSueldo(c.getSueldo());
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
		c = em.find(Cargo.class, id);
		return c;
	}

	@Override
	public String eliminar(int id) {
		String r = null;

		c = em.find(Cargo.class, id);
		em.getTransaction().begin();
		try {
			em.remove(c); // Elimina
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
	public List<Cargo> mostrarTodos() {
			//List<Cargo> ls = null;// List<Cargo>
		List <Cargo>ls = em.createQuery("from Cargo", Cargo.class).getResultList();
		
		return ls;
	}

	@Override
	public List<Cargo> buscar(String s) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
