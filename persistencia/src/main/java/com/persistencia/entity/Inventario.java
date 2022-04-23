package com.persistencia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



@Entity
@Table(name = "INVENTARIO")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,
property="@inventarioId", scope = Inventario.class)
public class Inventario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "INVENTARIO_ID", columnDefinition = "NUMBER")
	private int InventarioId;
	@Column(name = "CANTIDAD", columnDefinition = "NUMBER")
	private int cantidad;
	@Column(name = "EFECTIVO_ID", columnDefinition = "NUMBER")
	private int efectivoId;
	public int getInventarioId() {
		return InventarioId;
	}
	public void setInventarioId(int inventarioId) {
		InventarioId = inventarioId;
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
