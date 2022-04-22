package com.persistence.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.persistence.entity.Cliente;
import com.persistence.entity.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer>{
	
		//Se hereda la funcionalidad del modulo DataJPA de Spring
		//@Repository - acceso a la db
		//@Entity - molde para traer informacion de la db
		//@Service - entidad donde se resuelve la logica de negocio
		//@Controler -RestControler - se mapean las peticiones
		
		@Query("SELECT v FROM Venta v WHERE v.ventaId = :id")
		Venta buscar(@Param("id")int id);//lineas nuevas
			

}
