package com.persistence.request;

import java.time.LocalDate;

import com.persistence.entity.Cliente;

public class VentaRequest {

	int ventaId;
	Cliente cliente;
	LocalDate fechaVenta;

	public VentaRequest(int id) {

		this.ventaId = id;
	}

	public VentaRequest(int ventaId, Cliente cliente, LocalDate fechaVenta) {

		this.ventaId = ventaId;
		this.cliente = cliente;
		this.fechaVenta = fechaVenta;
	}

	public int getVentaId() {
		return ventaId;
	}

	public void setVentaId(int ventaId) {
		this.ventaId = ventaId;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

}
