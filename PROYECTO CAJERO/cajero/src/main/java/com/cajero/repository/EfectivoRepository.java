package com.cajero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cajero.entity.Efectivo;

@Repository
public interface EfectivoRepository extends JpaRepository<Efectivo, Integer> {

	@Transactional
	@Modifying
	@Query("update Efectivo e set e.existencia = ?1 where e.id = ?2")
	void upd(Integer exist, Integer Id);

	@Query("select e from Efectivo e where e.Id=:id")
	Efectivo buscarId(@Param("id") int id);
}