package com.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.persistence.entity.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	//Se hereda la funcionalidad del modulo DataJPA de Spring
		//@Repository - acceso a la db
		//@Entity - molde para traer informacion de la db
		//@Service - entidad donde se resuelve la logica de negocio
		//@Controler -RestControler - se mapean las peticiones
		
		@Query("SELECT c FROM Cliente c WHERE c.status=1")
		List<Cliente>mostrarActivos();
		
		
		@Query("SELECT c FROM Cliente c WHERE c.status=1 AND c.clienteId = :id")
		Cliente buscarActivo(@Param("id")int id);
	

}
