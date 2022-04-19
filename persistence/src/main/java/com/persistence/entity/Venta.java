package com.persistence.entity;

import java.io.Serializable;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//persistence

@Entity
@Table(name="VENTAS")
public class Venta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="v_id_auto")
	@SequenceGenerator(name="v_id_auto", sequenceName="VENTA_SEQ", allocationSize = 1, initialValue=1)
	
	
	@Column(name="VENTA_ID", columnDefinition="NUMBER")
	int ventaId;
	
	
	@Column(name="CLIENTE_ID", columnDefinition="NUMBER")
	int clienteId;
	
	@Column(name="FECHA_VENTA", columnDefinition="DATE")
	Calendar fechaVenta;
	

	public int getVentaId() {
		return ventaId;
	}

	public void setVentaId(int ventaId) {
		this.ventaId = ventaId;
	}

	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}

	public Calendar getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Calendar fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	
	
	

}
