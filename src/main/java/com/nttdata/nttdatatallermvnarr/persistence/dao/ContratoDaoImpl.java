package com.nttdata.nttdatatallermvnarr.persistence.dao;

import org.hibernate.Session;

import com.nttdata.nttdatatallermvnarr.persistence.Contrato;

/**
 * DAO
 * 
 * @author Alexandra Rodriguez
 *
 */
public class ContratoDaoImpl extends CommonDaoImpl<Contrato> implements ContratoDaoI {

	public ContratoDaoImpl(Session session) {
		super(session);
		
	}

	/**
	 * @return 
	 */
	@Override
	public Contrato searchByid(Long id) {
		Contrato contrato = searchByid(id);
		return contrato;
	}

	@Override
	public void insertContrato(Contrato contrato) {
		insert(contrato);
	}
	
	

}
