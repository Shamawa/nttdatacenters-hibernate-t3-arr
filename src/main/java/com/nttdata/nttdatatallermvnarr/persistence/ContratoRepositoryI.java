package com.nttdata.nttdatatallermvnarr.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * REPOSITORIO CONTRATOS
 * @author Alexandra Rodríguez
 *
 */
public interface ContratoRepositoryI extends JpaRepository <Contrato, Long > {
	/**
	 * Busqueda de Contrato por nombre y apellidos
	 * @param name
	 * @return Cliente o Lista de Clientes
	 */
	public List<Contrato> searchIdContrato(final Long idContrato, Cliente cliente);
	

}
