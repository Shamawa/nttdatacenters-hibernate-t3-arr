package com.nttdata.nttdatatallermvnarr.persistence.dao;

import java.util.List;

import com.nttdata.nttdatatallermvnarr.persistence.Cliente;

/**
 * DAO Cliente
 * 
 * @author Alexandra Rodriguez
 *
 */

public interface ClienteDaoI extends CommonDaoI<Cliente> {

	// MÉTODOS DE CONSULTA PROPIOS DE LA TABLA
	/**
	 * Obtiene clientes por nombre y apellidos.
	 * 
	 * @param name
	 * @param firstSurname
	 * @param secondSurname
	 * @return List<Cliente>
	 */
	public List<Cliente> searchByNameAndSurnames(final String name, final String firstSurname, final String secondSurname);
	
	public void insertClient(Cliente cliente);

}
