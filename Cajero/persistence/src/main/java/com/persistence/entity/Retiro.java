package com.persistence.entity;

import java.io.Serializable;
import java.util.Calendar;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="RETIROS")
public class Retiro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="r_id_auto")
	@SequenceGenerator(name="r_id_auto", sequenceName="RETIRO_SEQ", allocationSize = 1)
	
	
	@Column(name="RETIRO_ID", columnDefinition="NUMBER")
	int retiroId;
	
	@Column(name="CANTIDAD_RETIRO", columnDefinition="NUMBER")
	double cantidadRetiro;
	
	@Column(name="DINERO_CAJERO", columnDefinition="NUMBER")
	double dineroCajero;

	@Column(name="FECHA", columnDefinition="DATE")
	Calendar fecha;

	//Atributo relacional
	//@OneToMany(mappedBy ="retiro", cascade =CascadeType.ALL)
	//private List<Detalle> detalle;

	public int getRetiroId() {
		return retiroId;
	}

	public void setRetiroId(int retiroId) {
		this.retiroId = retiroId;
	}

	public double getCantidadRetiro() {
		return cantidadRetiro;
	}

	public void setCantidadRetiro(double cantidadRetiro) {
		this.cantidadRetiro = cantidadRetiro;
	}

	public double getDineroCajero() {
		return dineroCajero;
	}

	public void setDineroCajero(double dineroCajero) {
		this.dineroCajero = dineroCajero;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	
	
}
