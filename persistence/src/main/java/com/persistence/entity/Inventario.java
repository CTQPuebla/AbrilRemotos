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
@Table(name = "INVENTARIO")
public class Inventario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invid_auto")
	@SequenceGenerator(name = "invid_auto", sequenceName = "INVENTARIO_SEQ", initialValue = 7, allocationSize = 1)

	@Column(name = "INVENTARIO_ID", columnDefinition = "NUMBER")
	private int inventarioId;
	
	@OneToOne
	@JoinColumn(name = "PRODUCTO_ID", updatable=false, nullable=false)
	private Producto producto;
	
	@Column(name = "STOCK", columnDefinition = "NUMBER")
	private int stock;
	@Column(name = "FECHA_RESURTIDO", columnDefinition = "DATE")
	private LocalDate fechaResurtido;

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

	public LocalDate getFechaResurtido() {
		return fechaResurtido;
	}

	public void setFechaResurtido(LocalDate fechaResurtido) {
		this.fechaResurtido = fechaResurtido;
	}

}
