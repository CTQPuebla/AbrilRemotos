package com.persistence.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.persistence.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	//se hereda la funcionalidad del modulo datajpa de spring
	
	//@repository - acceso a la bd
	//@Entity - molde para traer informacion del db
	//@Service - entidad donde se resuelve la logica de negocio
	//@Controller - RestController - se mapean las peticiones
	
	
	@Query("select c from Cliente c where c.status=1")
	List <Cliente> mostrarActivos();
	
	@Query("select c from Cliente c where c.status=1 and c.clienteId=:id")
	Cliente buscarActivo(@Param("id")int id);
}