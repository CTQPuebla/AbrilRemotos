package com.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.persistence.entity.Retiro;

@Repository
public interface RetiroRepository extends JpaRepository<Retiro, Integer>{

	//Se hereda la funcionalidad del modulo DataJPA de Spring
	//@Repository - acceso a la db
	//@Entity - molde para traer informacion de la db
	//@Service - entidad donde se resuelve la logica de negocio
	//@Controler -RestControler - se mapean las peticiones

	@Query("SELECT r FROM Retiro r")
	List<Retiro>mostrarTodos();
	
	
	@Query("SELECT r FROM Retiro r WHERE r.retiroId = :id")
	Retiro buscar(@Param("id")int id);
	
	
	@Query("SELECT r FROM Retiro r WHERE r.retiroId = :id")
	Retiro ultimoRetiro(@Param("id")int id);
	//@Query("SELECT MAX(retiroId) from Retiro")
	//Retiro ultimoRetiro();
	//lenguaje jpql diferente a sql nativo
}
