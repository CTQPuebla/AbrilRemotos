package com.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.persistence.entity.Detalle;

@Repository
public interface DetalleRepository extends JpaRepository<Detalle, Integer>{

	//Se hereda la funcionalidad del modulo DataJPA de Spring
	//@Repository - acceso a la db
	//@Entity - molde para traer informacion de la db
	//@Service - entidad donde se resuelve la logica de negocio
	//@Controler -RestControler - se mapean las peticiones

}
