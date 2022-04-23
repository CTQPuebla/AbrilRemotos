package com.persistence.request;

import java.util.Calendar;

public class RetiroRequest {
	
	int retiroId;
	double cantidadRetiro;
	double dineroCajero;
	Calendar fecha;

	public RetiroRequest() {
			
		}
	
	public RetiroRequest(double cantidadRetiro) {
		
		this.cantidadRetiro = cantidadRetiro;
	}

	
	public RetiroRequest(int id) {
			
			this.retiroId = id;
		}


	public RetiroRequest(int retiroId, double cantidadRetiro, double dineroCajero, Calendar fecha) {
		
		this.retiroId = retiroId;
		this.cantidadRetiro = cantidadRetiro;
		this.dineroCajero = dineroCajero;
		this.fecha = fecha;
	}


	public int getRetiroId() {
		return retiroId;
	}


	public void setRetiroId(int retiroId) {
		this.retiroId = retiroId;
	}


	public double getCantidadRetiro() {
		return cantidadRetiro;
	}


	public void setCantidadRetiro(double cantidadRetiro) {
		this.cantidadRetiro = cantidadRetiro;
	}


	public double getDineroCajero() {
		return dineroCajero;
	}


	public void setDineroCajero(double dineroCajero) {
		this.dineroCajero = dineroCajero;
	}


	public Calendar getFecha() {
		return fecha;
	}


	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	

	
	
	
}
