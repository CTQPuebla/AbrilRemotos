package com.persistencia.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.persistencia.entity.Efectivo;

@Transactional
@Repository
public interface EfectivoRepository extends JpaRepository<Efectivo, Integer>{
   
    @Modifying
	@Query(value ="UPDATE EFECTIVO  set CANTIDAD = ? WHERE EFECTIVO_ID = ?", nativeQuery = true)
	 void retiro(Integer cantidad,Integer id); 
	
	@Query("SELECT e FROM Efectivo e WHERE e.efectivoId = :id")
	Efectivo buscarActivo(@Param("id")int id);
	
	    
}
