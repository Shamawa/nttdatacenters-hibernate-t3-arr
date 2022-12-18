package com.nttdata.nttdatatallermvnarr.services;

import java.util.List;

import com.nttdata.nttdatatallermvnarr.persistence.Cliente;
import com.nttdata.nttdatatallermvnarr.persistence.Contrato;

/**
 * Servicio de Gestión de Contratos
 * 
 * @author Alexandra Rodríguez
 *
 */
public interface ContratoManagmentServiceI {

	/**
	 * Método para crear nuevo contrato
	 * 
	 * @param newContrato
	 */
	public void addContrato(final Contrato newContrato);

	/**
	 * Método que nos devuelve una lista de Contratos
	 * 
	 * @return List <Contratos>
	 */
	public List<Contrato> getAllContrato();

	/**
	 * Método para borrar un Contrato
	 * 
	 * @param deleteContrato
	 */
	public void deleteContrato(final Contrato deleteContrato);

	/**
	 * 
	 * @param contratoId
	 * @return
	 */
	public Contrato getContratoById(final Long contratoId);



}
