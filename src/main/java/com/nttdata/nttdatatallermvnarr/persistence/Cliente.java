package com.nttdata.nttdatatallermvnarr.persistence;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Tabla de Cliente
 * 
 * @author Alexandra Rodriguez
 *
 */
@Entity
@Table(name = "T_Cliente")
public class Cliente extends AbstractEntity implements Serializable {
	

	/** SERIAL VERSION */
	private static final long serialVersionUID = 1L;

	/** ID */
	private Long id;

	/** Nombre */
	private String name;

	/** Primer Apellido */
	private String firstSurname;

	/** Segundo Apellido */
	private String secondSurname;

	/** DNI */
	private String dni;

	/**
	 * 
	 * @return Id
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PK_CLIENTE_ID")

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 
	 * @return Name
	 */
	@Column(name = "C_NAME", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return First surname
	 */
	@Column(name = "C_FIRSTSURNAME", nullable = false)
	public String getFirstSurname() {
		return firstSurname;
	}

	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	/**
	 * 
	 * @return Second surnameF
	 */
	@Column(name = "C_SECONDSURNAME", nullable = false)
	public String getSecondSurname() {
		return secondSurname;
	}

	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	/**
	 * 
	 * @return DNI
	 */
	@Column(name = "C_DNI", nullable = true, length = 9)
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	// Metodo de busqueda de Nombre y apellidos

}
