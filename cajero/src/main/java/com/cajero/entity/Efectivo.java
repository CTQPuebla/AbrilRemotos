package com.cajero.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "EFECTIVO")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@Id", scope = Efectivo.class)
public class Efectivo implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "eid_auto")
	@SequenceGenerator(name = "eid_auto", sequenceName = "EFE_SEQ", allocationSize = 1)
	@Column(name = "ID", columnDefinition = "NUMBER")
	private int Id;
	@Column(name = "TIPO", columnDefinition = "NVARCHAR2(15)")
	private String tipo;
	@Column(name = "DENOMINACION", columnDefinition = "NUMBER(6,2)")
	private double denominacion;
	@Column(name = "EXISTENCIA", columnDefinition = "NUMBER")
	private int existencia;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(double d) {
		this.denominacion = d;
	}

	public int getExistencia() {
		return existencia;
	}

	public void setExistencia(int existencia) {
		this.existencia = existencia;
	}

}
