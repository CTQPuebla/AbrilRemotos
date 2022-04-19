package com.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//persistence

@Entity
@Table(name="DETALLE_VENTAS")
public class Detalle implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="d_id_auto")
	@SequenceGenerator(name="d_id_auto", sequenceName="DETALLE_SEQ", allocationSize = 1, initialValue=1)
	
	
	@Column(name="DTV_ID", columnDefinition="NUMBER")
	int dtvId;
	
	@Column(name="VENTA_ID", columnDefinition="NUMBER")
	int ventaId;
	
	@Column(name="PRODUCTO_ID", columnDefinition="NUMBER")
	int productoId;
	
	@Column(name="CANTIDAD", columnDefinition="NUMBER")
	int cantidad;

	public int getDtvId() {
		return dtvId;
	}

	public void setDtvId(int dtvId) {
		this.dtvId = dtvId;
	}

	public int getVentaId() {
		return ventaId;
	}

	public void setVentaId(int ventaId) {
		this.ventaId = ventaId;
	}

	public int getProductoId() {
		return productoId;
	}

	public void setProductoId(int productoId) {
		this.productoId = productoId;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	

}
