package com.nttdata.nttdatatallermvnarr.services;

import java.util.List;

import com.nttdata.nttdatatallermvnarr.persistence.Cliente;

/**
 * Servicio de Gestión de Clientes
 * 
 * @author Alexandra Rodríguez
 *
 */

public interface ManagmentServiceI {
	/**
	 * Método para crear nuevo cliente
	 * 
	 * @param newCliente
	 */

	public void addCliente(final Cliente newCliente);

	/**
	 * Método que nos devuelve una lista de Clientes
	 * 
	 * @return List <Cliente>
	 */
	public List<Cliente> getAllCliente();

	/**
	 * Método para borrar un cliente
	 * 
	 * @param deleteCliente
	 */
	public void deleteCliente(final Cliente deleteCliente);

	/**
	 * 
	 * @param Id
	 * @return Cliente
	 */
	public Cliente getClienteById(final Long Id);

}
