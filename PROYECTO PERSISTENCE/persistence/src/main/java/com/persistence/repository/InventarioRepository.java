package com.persistence.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.persistence.entity.Inventario;


@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Integer>{

}
