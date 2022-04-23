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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "PRODUCTOS")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@productoId", scope = Producto.class)

public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pid_auto")
	@SequenceGenerator(name = "pid_auto", sequenceName = "PRODUCTOS_SEQ", initialValue = 1, allocationSize = 1)
	@Column(name = "PRODUCTO_ID", columnDefinition = "NUMBER")
	private int productoId;
	@Column(name = "NOMBRE", columnDefinition = "NVARCHAR2(20)")
	private String nombre;

	@Column(name = "PRESENTACION", columnDefinition = "NVARCHAR2(20)")
	private String presentacion;

	@Column(name = "PRECIO", columnDefinition = "NUMBER(5,2)")
	private int precio;

	@Column(name = "FECHA_CAD", columnDefinition = "DATE")
	private LocalDate fechaCad;

	@Column(name = "MARCA", columnDefinition = "NVARCHAR2(15)")
	private String marca;

	@Column(name = "STATUS", columnDefinition = "NUMBER")
	private int status;

	@OneToOne(mappedBy = "producto", cascade=CascadeType.ALL)
	private Inventario inventario;
	
	// Atributo relacional
	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
	private List<DetalleVenta> detalleventa;

	public int getProductoId() {
		return productoId;
	}

	public void setProductoId(int productoId) {
		this.productoId = productoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public LocalDate getFechaCad() {
		return fechaCad;
	}

	public void setFechaCad(LocalDate fechaCad) {
		this.fechaCad = fechaCad;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	public List<DetalleVenta> getDetalleventa() {
		return detalleventa;
	}

	public void setDetalleventa(List<DetalleVenta> detalleventa) {
		this.detalleventa = detalleventa;
	}


}
