package com.nttdata.nttdatatallermvnarr.persistence;

/**
 * Tabla de Contrato
 * 
 * @author Alexandra Rodriguez
 *
 */

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_Contrato")
public class Contrato extends AbstractEntity implements Serializable {

	/** SERIAL VERSION */
	private static final long serialVersionUID = 1L;

	/** ID */
	private Long idContrato;

	// Fecha de Vigencia y fecha fin de caducidad del contrato seria con Date

	/** Fecha de Vigencia del contrato */
	private int fechaVigencia;

	/** Fecha de caducidad del contrato */
	private String fechaCaducidad;

	/** Precio Mensual */
	private double precioMensual;

	/** Cliente del contrato */
	private Cliente cliente;

	/**
	 * 
	 * @return idContrato
	 */
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "C_PK_ID_CONTRATO", nullable = false)
	public Long getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(Long idContrato) {
		this.idContrato = idContrato;
	}

	/**
	 * 
	 * @return fechaVigencia
	 */
	@Column(name = "C_FECHA_VIGENCIA")
	public int getFechaVigencia() {
		return fechaVigencia;
	}

	public void setFechaVigencia(int fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}

	/**
	 * 
	 * @return fechaVigencia
	 */
	@Column(name = "C_FECHA_CADUCIDAD")
	public String getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	/**
	 * 
	 * @return fechaVigencia
	 */
	@Column(name = "C_PRECIO_MENSUAL")
	public double getPrecioMensual() {
		return precioMensual;
	}

	public void setPrecioMensual(double precioMensual) {
		this.precioMensual = precioMensual;
	}

	/**
	 * 
	 * @return fechaVigencia
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_CLIENTE_ID", referencedColumnName = "FK_CLIENTE_ID")
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}