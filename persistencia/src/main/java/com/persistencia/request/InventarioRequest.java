package com.persistencia.request;

public class InventarioRequest {

	
	
	private int inventarioId;
	private int cantidad;
	private int efectivoId;
	
	
	public InventarioRequest(int inventarioId, int cantidad, int efectivoId) {
		super();
		this.inventarioId = inventarioId;
		this.cantidad = cantidad;
		this.efectivoId = efectivoId;
	}
	public int getInventarioId() {
		return inventarioId;
	}
	public void setInventarioId(int inventarioId) {
		this.inventarioId = inventarioId;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getEfectivoId() {
		return efectivoId;
	}
	public void setEfectivoId(int efectivoId) {
		this.efectivoId = efectivoId;
	}
	
	
}
