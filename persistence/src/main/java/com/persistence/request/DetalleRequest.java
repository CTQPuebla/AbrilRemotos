package com.persistence.request;

import com.persistence.entity.Venta;

public class DetalleRequest {
	
	int dtvId;
	Venta venta;
	int productoId;
	int cantidad;

public DetalleRequest(int id) {
		
		this.dtvId = id;
	}



public DetalleRequest(int dtvId, Venta venta, int productoId, int cantidad) {

	this.dtvId = dtvId;
	this.venta = venta;
	this.productoId = productoId;
	this.cantidad = cantidad;
}



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
