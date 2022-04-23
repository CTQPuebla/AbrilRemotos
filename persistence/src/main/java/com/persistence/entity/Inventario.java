package com.persistence.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="INVENTARIO")
public class Inventario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="i_id_auto")
	@SequenceGenerator(name="i_id_auto", sequenceName="INVENTARIO_SEQ", allocationSize = 1)
	

	@Column(name="INVENTARIO_ID", columnDefinition="NUMBER")
	int inventarioId;
	
	@OneToOne
	@JoinColumn(name="PRODUCTO_ID", columnDefinition="NUMBER")
	Producto producto;
	
	@Column(name="STOCK", columnDefinition="NUMBER")
	int stock;
	
	@Column(name="FECHA_RESURTIDO", columnDefinition="DATE")
	LocalDate fecha_res;
	

	public int getInventarioId() {
		return inventarioId;
	}

	public void setInventarioId(int inventarioId) {
		this.inventarioId = inventarioId;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public LocalDate getFecha_res() {
		return fecha_res;
	}

	public void setFecha_res(LocalDate fecha_res) {
		this.fecha_res = fecha_res;
	}
	
	
	
	
}
