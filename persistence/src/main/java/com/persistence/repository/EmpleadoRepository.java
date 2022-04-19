package com.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.persistence.entity.Empleado;


@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{

	//Se hereda la funcionalidad del modulo DataJPA de Spring
	//@Repository - acceso a la db
	//@Entity - molde para traer informacion de la db
	//@Service - entidad donde se resuelve la logica de negocio
	//@Controler -RestControler - se mapean las peticiones
	
	@Query("SELECT e FROM Empleado e WHERE e.status=1")
	List<Empleado>mostrarActivos();
	
	
	@Query("SELECT e FROM Empleado e WHERE e.status=1 AND e.empleadoId = :id")
	Empleado buscarActivo(@Param("id")int id);
	
	
}
