package com.persistence.request;

public class DetalleRequest {
	
	int dtvId;
	int ventaId;
	int productoId;
	int cantidad;

public DetalleRequest(int id) {
		
		this.dtvId = id;
	}

public DetalleRequest(int dtvId, int ventaId, int productoId, int cantidad) {
	
	this.dtvId = dtvId;
	this.ventaId = ventaId;
	this.productoId = productoId;
	this.cantidad = cantidad;
}

public int getDtvId() {
	return dtvId;
}

public void setDtvId(int dtvId) {
	this.dtvId = dtvId;
}

public int getVentaId() {
	return ventaId;
}

public void setVentaId(int ventaId) {
	this.ventaId = ventaId;
}

public int getProductoId() {
	return productoId;
}

public void setProductoId(int productoId) {
	this.productoId = productoId;
}

public int getCantidad() {
	return cantidad;
}

public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}
	


}
