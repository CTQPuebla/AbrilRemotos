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


@Entity
@Table(name = "DETALLE_VENTAS")

public class DetalleVenta implements Serializable{
	
	
		private static final long serialVersionUID = 1L;
	
	// Atributos
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dvid_auto")
		@SequenceGenerator(name = "dvid_auto", sequenceName = "D_VENTAS_SEQ",allocationSize = 1)
		@Column(name = "DTV_ID", columnDefinition = "NUMBER")
		private int dtvId;
		
		@ManyToOne
		@JoinColumn(name = "VENTA_ID", updatable = false, nullable = false)
		private Venta venta;
		//@Column(name = "VENTA_ID", columnDefinition = "NUMBER")
		//private int ventaId;
		
		@ManyToOne
		@JoinColumn(name = "PRODUCTO_ID", updatable = false, nullable = false)
		private Producto producto;
		//@Column(name = "PRODUCTO_ID", columnDefinition = "NUMBER")
		//private int productoId;
		
		@Column(name = "CANTIDAD", columnDefinition = "NUMBER")
		private int cantidad;

		public int getDtvId() {
			return dtvId;
		}

		public void setDtvId(int dtvId) {
			this.dtvId = dtvId;
		}

		public Venta getVenta() {
			return venta;
		}

		public void setVenta(Venta venta) {
			this.venta = venta;
		}

		public Producto getProducto() {
			return producto;
		}

		public void setProducto(Producto producto) {
			this.producto = producto;
		}

		public int getCantidad() {
			return cantidad;
		}

		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}

}
