package com.nttdata.nttdatatallermvnarr.persistence.dao;

import java.util.List;

/**
 * 
 * DAO Generico
 * 
 * 
 * @author Alexandra Rodriguez
 * 
 */

public interface CommonDaoI<Cliente> {

	// METODOS CRUD COMUNES
	
	/**
	 * Inserta un registro en BBDD.
	 * 
	 * @param paramT
	 */
	public void insert(final Cliente cliente);

	/**
	 * Actualiza un registro en BBDD.
	 * 
	 * @param paramT
	 */
	public void update(final Cliente cliente);
	
	/**
	 * Elimina un registro en BBDD.
	 * 
	 * @param paramT
	 */
	public void delete(final Cliente cliente);
	
	/**
	 * Localiza un registro por ID en BBDD.
	 * 
	 * @param paramT
	 */
	public Cliente searchById(final Long id);

	/**
	 * Busqueda de todos los registros en BBDD.
	 * 
	 * @return List<T>
	 */
	public List<Cliente> searchAll();

}
