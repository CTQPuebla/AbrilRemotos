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
	
	
	//@Column(name="CLIENTE_ID", columnDefinition="NUMBER")
	//int clienteId;
	@ManyToOne
	@JoinColumn(name="CLIENTE_ID", updatable = false, nullable= false)
	private Cliente cliente;
	
	@Column(name="FECHA_VENTA", columnDefinition="DATE")
	LocalDate fechaVenta;
	
	//Atributo relacional
	@OneToMany(mappedBy ="venta", cascade =CascadeType.ALL)
	private List<Detalle> detalle;

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
	

	
	
	

}
