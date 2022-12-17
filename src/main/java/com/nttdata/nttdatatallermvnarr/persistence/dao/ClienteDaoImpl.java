package com.nttdata.nttdatatallermvnarr.persistence.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.nttdatatallermvnarr.persistence.Cliente;

/**
 * DAO
 * 
 * @author Alexandra Rodriguez
 *
 */

public class ClienteDaoImpl extends CommonDaoImpl<Cliente> implements ClienteDaoI {

	public ClienteDaoImpl(Session session) {
		super(session);
	}

	// MÉTODOS DE CONSULTA PROPIOS DE LA TABLA
	@Override
	public List<Cliente> searchByNameAndSurnames(String name, String firstSurname, String secondSurname) {
		List<Cliente> clienteList = searchAll();
		List<Cliente> resultadoList = new ArrayList<Cliente>();
		for (Cliente c : clienteList) {
			if (c.getName().equals(name) && c.getFirstSurname().equals(firstSurname) && c.getSecondSurname().equals(secondSurname)) {
				resultadoList.add(c);
			}
		}
		return resultadoList;
	}

	@Override
	public void insertClient(Cliente cliente) {
		insert(cliente);
	}

}
