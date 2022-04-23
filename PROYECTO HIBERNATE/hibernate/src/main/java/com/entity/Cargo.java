package com.entity;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name = "CARGOS")
public class Cargo {

	public Cargo() {
	}
	
	public Cargo(int id) {
		this.cargoId = id;
	}

	public Cargo(int cargoId, String descripcion, int sueldo) {
		this.cargoId = cargoId;
		this.descripcion = descripcion;
		this.sueldo = sueldo;
	}

	@Id
	@Column(name = "CARGO_ID", columnDefinition = "NUMBER")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cid_auto")
	@SequenceGenerator(name = "cid_auto", sequenceName = "CARGO_SEQ", allocationSize = 1)
	private int cargoId;
	@Column(name = "DESCRIPCION", columnDefinition = "NVARCHAR2(20)")
	private String descripcion;
	@Column(name = "SUELDO", columnDefinition = "NUMBER(5,2)")
	private int sueldo;

	public int getCargoId() {
		return cargoId;
	}

	public void setCargoId(int cargoId) {
		this.cargoId = cargoId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

}
