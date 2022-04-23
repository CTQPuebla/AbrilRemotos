package com.persistence.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.persistence.entity.Venta;


@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer>{

	//se hereda la funcionalidad del modulo datajpa de spring	
}