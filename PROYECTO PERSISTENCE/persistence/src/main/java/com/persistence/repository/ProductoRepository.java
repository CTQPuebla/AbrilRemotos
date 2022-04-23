package com.persistence.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.persistence.entity.Producto;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

	//se hereda la funcionalidad del modulo datajpa de spring
	
	//@repository - acceso a la bd
	//@Entity - molde para traer informacion del db
	//@Service - entidad donde se resuelve la logica de negocio
	//@Controller - RestController - se mapean las peticiones
	
	
	@Query("select p from Producto p where p.status=1")
	List <Producto> mostrarActivos();
	
	@Query("select p from Producto p where p.status=1 and p.productoId=:id")
	Producto buscarActivo(@Param("id")int id);
}