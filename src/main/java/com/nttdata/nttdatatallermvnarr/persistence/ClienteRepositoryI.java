package com.nttdata.nttdatatallermvnarr.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * REPOSITORIO CLIENTES
 * @author Alexandra Rodríguez
 *
 */
@Repository
public interface ClienteRepositoryI extends JpaRepository <Cliente, Long > {
	
	
	/**
	 * Busqueda de Cliente por nombre, primer y segundo apellido
	 * @param name
	 * @return Cliente o Lista de Clientes
	 */
	public List<Cliente> findByNameAndSurnames(final String name, String firstSurname, String secondSurname);
	
	
	
	

}
