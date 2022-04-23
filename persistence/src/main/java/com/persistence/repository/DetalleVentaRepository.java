package com.persistence.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.persistence.entity.DetalleVenta;


@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Integer>{

	//se hereda la funcionalidad del modulo datajpa de spring
	
	//@repository - acceso a la bd
	//@Entity - molde para traer informacion del db
	//@Service - entidad donde se resuelve la logica de negocio
	//@Controller - RestController - se mapean las peticiones
}