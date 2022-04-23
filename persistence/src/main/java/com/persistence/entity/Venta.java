package com.persistence.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "VENTAS")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@ventaId", scope = Venta.class)
public class Venta implements Serializable {

	// ManyToOne

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vid_auto")
	@SequenceGenerator(name = "vid_auto", sequenceName = "VENTAS_SEQ", allocationSize = 1)
	@Column(name = "VENTA_ID", columnDefinition = "NUMBER")
	private int ventaId;

	@ManyToOne
	@JoinColumn(name = "CLIENTE_ID", updatable = false, nullable = false)
	private Cliente cliente;

	@Column(name = "FECHA_VENTA", columnDefinition = "DATE")
	private LocalDate fechaVenta;
	
	// Atributo relacional
		@OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
		private List<DetalleVenta> detalleventa;

	public int getVentaId() {
		return ventaId;
	}

	public void setVentaId(int ventaId) {
		this.ventaId = ventaId;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public List<DetalleVenta> getDetalleventa() {
		return detalleventa;
	}

	public void setDetalleventa(List<DetalleVenta> detalleventa) {
		this.detalleventa = detalleventa;
	}

}