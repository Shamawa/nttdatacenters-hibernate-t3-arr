package com.nttdata.nttdatatallermvnarr;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.mapping.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.nttdata.nttdatatallermvnarr.persistence.Cliente;
import com.nttdata.nttdatatallermvnarr.persistence.Contrato;
import com.nttdata.nttdatatallermvnarr.persistence.dao.ClienteDaoImpl;
import com.nttdata.nttdatatallermvnarr.persistence.dao.ContratoDaoImpl;
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
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		SpringApplication.run(NttdatacentersHibernateT1ArrApplication.class, args);

		// Abrimos la sesión con la BBDD.
		Session dataBaseConnection = NTTDataHibernateUtil.getSessionFactory().openSession();

		// Declaramos objetos.
		Cliente cliente1 = new Cliente();
		Contrato contrato1 = new Contrato();
		Contrato contrato2 = new Contrato();
		ArrayList<Contrato> contratoList = new ArrayList<Contrato>();

		// Creamos instancia de ClienteDaoImpl y ContratoDaoImpl.
		ClienteDaoImpl cliente = new ClienteDaoImpl(dataBaseConnection);
		ContratoDaoImpl contrato = new ContratoDaoImpl(dataBaseConnection);

		// Creamos un Cliente.
		cliente1.setId(10L);
		cliente1.setName("Alexandra");
		cliente1.setFirstSurname("Rodriguez");
		cliente1.setSecondSurname("Rodriguez");

		// Creamos los Contratos.
		contrato1.setIdContrato(0L);
		contrato1.setCliente(cliente1);
		contrato1.setFechaVigencia(10);
		contrato1.setFechaCaducidad("08/10/23");
		contrato1.setPrecioMensual(69.4d);

		contrato2.setIdContrato(1L);
		contrato2.setCliente(cliente1);
		contrato2.setFechaVigencia(25);
		contrato2.setFechaCaducidad("18/05/26");
		contrato2.setPrecioMensual(52.9d);

		contratoList.add(contrato1);
		contratoList.add(contrato2);

		// Añadimos los contratos al Cliente.
		cliente1.setContratosList(contratoList);

		// Insertamos el Cliente.
		cliente.insertClient(cliente1);

		// Insertamos los Contratos.
		contrato.insert(contrato1);
		contrato.insert(contrato2);

		// Buscamos los Clientes por nombres y apellidos que coincidan con los
		// suministrados por parámetros
		// y los imprimimos por pantalla.
		ArrayList<Cliente> clienteList = new ArrayList<Cliente>();
		clienteList = (ArrayList<Cliente>) cliente.searchByNameAndSurnames("Alex", "Rodriguez", "Rodriguez");
		for (Cliente c : clienteList) {
			System.out.println(c.getName());
		}

		// Buscamos los Contratos por id de Cliente y los imprimimos por pantalla.
		ArrayList<Contrato> contratosList = new ArrayList<Contrato>();
		contratosList = (ArrayList<Contrato>) contrato.searchByid(10L);
		for (Contrato c : contratosList) {
			System.out.println(c.getIdContrato() + " " + c.getCliente().getName());
		}

	}

}
