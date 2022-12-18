package com.nttdata.nttdatatallermvnarr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.nttdatatallermvnarr.persistence.Cliente;
import com.nttdata.nttdatatallermvnarr.persistence.ClienteRepositoryI;

/**
 * Servicio de gestión de los Contratos.
 * 
 * @author Alexandra Rodríguez
 *
 */
@Service
public class ManagmentServiceImpl implements ManagmentServiceI {

	/** Repositorio: T_CLIENTE */
	@Autowired
	private ClienteRepositoryI clienteRepo;

	/**
	 * Método para añadir una persona comprobando que no esté ya en la BBDD
	 */
	@Override
	public void addCliente(Cliente newCliente) {

		// Validación de integridad.
		if (newCliente != null && newCliente.getId() == null) {
			// Insercción.
			clienteRepo.save(newCliente);
		}

	}

	/**
	 * Método que retorna todos los clientes
	 */
	@Override
	public List<Cliente> getAllCliente() {
		return clienteRepo.findAll();
	}

	/**
	 * Método para borrar un cliente
	 */
	@Override
	public void deleteCliente(final Cliente deleteCliente) {
		// Validación de integridad.
		if (deleteCliente != null) {
			// Eliminación.
			clienteRepo.delete(deleteCliente);
		}

	}

	@Override
	public Cliente getClienteById(final Long clienteId) {
		return clienteRepo.getReferenceById(clienteId);
	}

}
