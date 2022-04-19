package com.persistence.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


//persistence

@Entity
@Table(name="EMPLEADO")
public class Empleado implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="e_id_auto")
	@SequenceGenerator(name="e_id_auto", sequenceName="EMPLEADO_SEQ", allocationSize = 1, initialValue=1)
	
	
	@Column(name="EMPLEADO_ID", columnDefinition="NUMBER")
	int empleadoId;
	
	@Column(name="NOMBRE", columnDefinition="NVARCHAR2(15)")
	String nombre;
	
	@Column(name="ANTIGUEDAD", columnDefinition="NUMBER")
	int antiguedad;
	
	@Column(name="SEXO", columnDefinition="CHAR(1)")
	String sexo;
	
	@Column(name="ESTADO_CIVIL", columnDefinition="NVARCHAR2(10)")
	String estadoCivil;
	
	@Column(name="FECHA_NAC", columnDefinition="DATE")
	Date fechaNac;
	
	@Column(name="CARGO_ID", columnDefinition="NUMBER")
	int cargoId;
	
	@Column(name="STATUS", columnDefinition="NUMBER")
	int status;

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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	

	
	
	
	
	

}
