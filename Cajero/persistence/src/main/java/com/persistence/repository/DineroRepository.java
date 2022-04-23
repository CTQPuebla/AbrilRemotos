package com.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.persistence.entity.Dinero;

@Repository
public interface DineroRepository extends JpaRepository<Dinero, Integer>{
	
    //Se hereda la funcionalidad del modulo DataJPA de Spring
	//@Repository - acceso a la db
	//@Entity - molde para traer informacion de la db
	//@Service - entidad donde se resuelve la logica de negocio
	//@Controler -RestControler - se mapean las peticiones

	@Query("SELECT d FROM Dinero d")
	List<Dinero>mostrar();
	
	
	@Query("SELECT d FROM Dinero d WHERE d.dineroId = :id")
	Dinero buscar(@Param("id")int id);
}
