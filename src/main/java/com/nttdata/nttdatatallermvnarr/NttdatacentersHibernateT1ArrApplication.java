package com.nttdata.nttdatatallermvnarr;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.mapping.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.nttdata.nttdatatallermvnarr.persistence.Cliente;
import com.nttdata.nttdatatallermvnarr.persistence.dao.ClienteDaoImpl;
import com.nttdata.nttdatatallermvnarr.utils.NTTDataHibernateUtil;

/**
 * Taller 1 - Hibernate: Actividad que crea un servicio de consulta de cliente
 * por nombre y apellidos. Implementacion del patron DAO con la definicion de
 * metodos CRUD y mapeo de datos.
 * 
 * @author Alexandra Rodríguez
 *
 */

@SpringBootApplication
public class NttdatacentersHibernateT1ArrApplication {
	/**
	 * Metodo principal
	 * @param args
	 */

	public static void main(String[] args) {
		SpringApplication.run(NttdatacentersHibernateT1ArrApplication.class, args);
		
		// Abrimos la sesión con la BBDD.
		Session dataBaseConnection = NTTDataHibernateUtil.getSessionFactory().openSession();
		
		// Creamos instancia de ClienteDaoImpl.
		ClienteDaoImpl cliente = new ClienteDaoImpl(dataBaseConnection);
		
		// Creamos un Cliente.
		Cliente cliente1 = new Cliente();
		cliente1.setName("Alexandra");
		cliente1.setFirstSurname("Rodriguez");
		cliente1.setSecondSurname("Rodriguez");
		
		// Insertamos el Cliente.
		cliente.insertClient(cliente1);
		
		// Buscamos los Clientes por nombres y apellidos que coincidan con los suministrados por parámetros
		// y los imprimimos por pantalla.
		ArrayList<Cliente> clienteList = new ArrayList<Cliente>();
		clienteList = (ArrayList<Cliente>) cliente.searchByNameAndSurnames("Alex", "Rodriguez", "Rodriguez");
		for (Cliente c : clienteList) {
			System.out.println(c.getName());
		}

	}

}
