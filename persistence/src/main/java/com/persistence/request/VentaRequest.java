package com.persistence.request;


import java.util.Calendar;

public class VentaRequest {

	int ventaId;
	int clienteId;
	Calendar fechaVenta;
	
	
public VentaRequest(int id) {
		
		this.ventaId = id;
	}


public VentaRequest(int ventaId, int clienteId, Calendar fechaVenta) {
	
	this.ventaId = ventaId;
	this.clienteId = clienteId;
	this.fechaVenta = fechaVenta;
}


public int getVentaId() {
	return ventaId;
}


public void setVentaId(int ventaId) {
	this.ventaId = ventaId;
}


public int getClienteId() {
	return clienteId;
}


public void setClienteId(int clienteId) {
	this.clienteId = clienteId;
}


public Calendar getFechaVenta() {
	return fechaVenta;
}


public void setFechaVenta(Calendar fechaVenta) {
	this.fechaVenta = fechaVenta;
}
	
	

}
