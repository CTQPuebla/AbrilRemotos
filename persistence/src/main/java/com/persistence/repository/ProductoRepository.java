package com.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.persistence.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	
		//Se hereda la funcionalidad del modulo DataJPA de Spring
		//@Repository - acceso a la db
		//@Entity - molde para traer informacion de la db
		//@Service - entidad donde se resuelve la logica de negocio
		//@Controler -RestControler - se mapean las peticiones
		
		@Query("SELECT p FROM Producto p WHERE p.status=1")
		List<Producto>mostrarActivos();
		
		
		@Query("SELECT p FROM Producto p WHERE p.status=1 AND p.productoId = :id")
		Producto buscarActivo(@Param("id")int id);

}
