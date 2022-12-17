package com.nttdata.nttdatatallermvnarr.persistence.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.nttdatatallermvnarr.persistence.Cliente;
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

	@Override
	public List<Contrato> searchByid(Long id) {
		List<Contrato> contratoList = searchAll();
		List<Contrato> resultadoList= new ArrayList<Contrato>();
		for (Contrato c : contratoList) {
			if (c.getCliente().getId().equals(id)) {
				resultadoList.add(c);
			}
		}
		
		return resultadoList;
	}

	@Override
	public void insertContrato(Contrato contrato) {
		insert(contrato);
		
	}
	
	

}
