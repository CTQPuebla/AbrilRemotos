package com.persistence.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLEADOS")
public class Empleado implements Serializable{
	
	
		private static final long serialVersionUID = 1L;
	
	// Atributos
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "eid_auto")
		@SequenceGenerator(name = "eid_auto", sequenceName = "EMPLEADOS_SEQ",initialValue=7, allocationSize = 1)
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
		private LocalDate fechaNac;
		
		@Column(name = "CARGO_ID", columnDefinition = "NUMBER")
		private int cargoId;
		
		@Column(name = "STATUS", columnDefinition = "NUMBER")
		private int status;

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

		public LocalDate getFechaNac() {
			return fechaNac;
		}

		public void setFechaNac(LocalDate date) {
			this.fechaNac = date;
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
