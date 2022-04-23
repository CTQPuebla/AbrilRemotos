package com.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLEADO")
public class Empleado {

	public Empleado() {
	}
	
	public Empleado(String s) {
		this.nombre = s;
	}

	public Empleado(int id) {

		this.empleadoId = id;

	}

	public Empleado(int empleadoId, String nombre, int antiguedad, String sexo, String estadoCivil, Date fechaNac,
			int cargoId) {
		this.empleadoId = empleadoId;
		this.nombre = nombre;
		this.antiguedad = antiguedad;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.fechaNac = fechaNac;
		this.cargoId = cargoId;
	}

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "eid_auto")
	@SequenceGenerator(name = "eid_auto", sequenceName = "EMPLEADO_SEQ", allocationSize = 1)
	@Column(name = "EMPLEADO_ID", columnDefinition = "NUMBER")
	private int empleadoId;
	
	@Column(name = "NOMBRE", columnDefinition = "NVARCHAR2(15)")
	private String nombre;
	
	@Column(name = "ANTIGUEDAD", columnDefinition = "NUMBER")
	private int antiguedad;
	
	@Column(name = "SEXO", columnDefinition = "CHAR(1)")
	private String sexo;
	
	@Column(name = "ESTADO_CIVIL", columnDefinition = "NVARCHAR2(10)")
	private String estadoCivil;
	
	@Column(name = "FECHA_NAC", columnDefinition = "DATE")
	private Date fechaNac;
	
	@Column(name = "CARGO_ID", columnDefinition = "NUMBER")
	private int cargoId;

	// G & S
	public int getEmpleadoId() {
		return empleadoId;
	}

	public void setEmpleadoId(int empleadoId) {
		this.empleadoId = empleadoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public int getCargoId() {
		return cargoId;
	}

	public void setCargoId(int cargoId) {
		this.cargoId = cargoId;
	}

}