package com.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//persistence

@Entity
@Table(name="DETALLE_RETIROS")
public class Detalle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="d_id_auto")
	@SequenceGenerator(name="d_id_auto", sequenceName="DETALLE_RET_SEQ", allocationSize = 1)
	
	@Column(name="DTR_ID", columnDefinition="NUMBER")
	int dtrId;
	
	@ManyToOne
	@JoinColumn(name="RETIRO_ID", updatable = false, nullable= false)
	private Retiro retiro;
	
	@Column(name="TIPO", columnDefinition="NVARCHAR2(20)")
	String tipo;
	
	@Column(name="CANTIDAD", columnDefinition="NUMBER")
	int cantidad;
	
	@Column(name="DENOMINACION", columnDefinition="NUMBER")
	double denominacion;
	

	public int getDtrId() {
		return dtrId;
	}

	public void setDtrId(int dtrId) {
		this.dtrId = dtrId;
	}

	public Retiro getRetiro() {
		return retiro;
	}

	public void setRetiro(Retiro retiro) {
		this.retiro = retiro;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(double denominacion) {
		this.denominacion = denominacion;
	}

	
	
	
}
