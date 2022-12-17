package com.nttdata.nttdatatallermvnarr.persistence.dao;

import java.util.List;

import com.nttdata.nttdatatallermvnarr.persistence.Cliente;
import com.nttdata.nttdatatallermvnarr.persistence.Contrato;

/**
 * DAO Contrato
 * 
 * @author Alexandra Rodriguez
 *
 */
public interface ContratoDaoI extends CommonDaoI<Contrato> {

	// MÉTODOS DE CONSULTA PROPIOS DE LA TABLA

	/**
	 * Busca los Contratos de un ID de Cliente
	 * 
	 * @param id del Cliente
	 * @return La lista de Contratos del Cliente
	 */
	public List<Contrato> searchByid(final Long id);

	/**
	 * Inserta un Contrato.
	 * 
	 * @param Contrato
	 */
	public void insertContrato(Contrato Contrato);

}
