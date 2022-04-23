package com.persistencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.persistencia.entity.Inventario;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Integer>{

}
