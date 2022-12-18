package com.nttdata.nttdatatallermvnarr.persistence.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SharedSessionContract;

import com.nttdata.nttdatatallermvnarr.persistence.Cliente;
import com.nttdata.nttdatatallermvnarr.persistence.Contrato;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

/**
 * DAO
 * 
 * @author Alexandra Rodriguez
 *
 */

public class ClienteDaoImpl extends CommonDaoImpl<Cliente> implements ClienteDaoI {
	
	/** Sesión de conexión a BD */
	private Session session;

	public ClienteDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	// MÉTODOS DE CONSULTA PROPIOS DE LA TABLA
	@Override
	/**
	 * Método busqueda de Cliente por su nombre y apellidos
	 */
	
	// Metodo antiguo  antes de iniciar la consulta con Criteria Builder
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
	
	@Override
	public List<Cliente> searchByNameAndSurnames2(String name, String firstSurname, String secondSurname) {
		// Consulta.
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<Cliente> cquery = cb.createQuery(Cliente.class);
		final Root<Cliente> rootP = cquery.from(Cliente.class);
		final Join<Cliente, Contrato> pJoinT = rootP.join("");

		// Where.
		final Predicate pr1 = cb.like(pJoinT.getParent().<String> get("name"), name);
		final Predicate pr2 = cb.like(pJoinT.<String> get("FirstSurname"), firstSurname);
		final Predicate pr3 = cb.like(pJoinT.<String> get("SecondSurname"), secondSurname);
		

		// Consulta.
		cquery.select(rootP).where(cb.and(pr1, pr2, pr3));

		// Ejecución de consulta.
		final List<Cliente> results = session.createQuery(cquery).getResultList();

		return results;
	}

}
