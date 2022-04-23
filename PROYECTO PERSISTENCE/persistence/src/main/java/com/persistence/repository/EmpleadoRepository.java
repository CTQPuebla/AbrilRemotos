package com.persistence.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.persistence.entity.Empleado;
import com.persistence.entity.Producto;


@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{

	//se hereda la funcionalidad del modulo datajpa de spring
	
	//@repository - acceso a la bd
	//@Entity - molde para traer informacion del db
	//@Service - entidad donde se resuelve la logica de negocio
	//@Controller - RestController - se mapean las peticiones
	
	
	@Query("select e from Empleado e where e.status=1")
	List <Producto> mostrarActivos();
	
	@Query("select e from Empleado e where e.status=1 and e.empleadoId=:id")
	Empleado buscarActivo(@Param("id")int id);
}