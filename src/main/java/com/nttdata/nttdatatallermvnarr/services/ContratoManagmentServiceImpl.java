package com.nttdata.nttdatatallermvnarr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nttdata.nttdatatallermvnarr.persistence.Cliente;
import com.nttdata.nttdatatallermvnarr.persistence.Contrato;
import com.nttdata.nttdatatallermvnarr.persistence.ContratoRepositoryI;

/**
 * Servicio de gestión de la Contratos.
 * 
 * @author Alexandra Rodríguez
 *
 */

public class ContratoManagmentServiceImpl implements ContratoManagmentServiceI {

	/** Repositorio: T_CONTRATOS */
	@Autowired
	private ContratoRepositoryI contratoRepo;

	/**
	 * Método para añadir una persona comprobando que no esté ya en la BBDD
	 */
	@Override
	public void addContrato(Contrato newContrato) {

		// Validación de integridad.
		if (newContrato != null && newContrato.getIdContrato() == null) {
			// Insercción.
			contratoRepo.save(newContrato);
		}
	}

	/**
	 * Método que retorna todos los contratos
	 */
	@Override
	public List<Contrato> getAllContrato() {
		return contratoRepo.findAll();
	}

	/**
	 * Elimina un contrato
	 */
	@Override
	public void deleteContrato(final Contrato deleteContrato) {
		// Validación de integridad.
		if (deleteContrato != null) {
			// Eliminación.
			contratoRepo.delete(deleteContrato);
		}
	}

	/**
	 * Devuelve la Id de un Contrato
	 */
	@Override
	public Contrato getContratoById(final Long contratoId) {
		return contratoRepo.getReferenceById(contratoId);
	}

}
