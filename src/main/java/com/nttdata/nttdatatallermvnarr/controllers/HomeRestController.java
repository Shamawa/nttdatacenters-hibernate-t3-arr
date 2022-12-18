package com.nttdata.nttdatatallermvnarr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.nttdatatallermvnarr.persistence.Cliente;
import com.nttdata.nttdatatallermvnarr.persistence.Contrato;
import com.nttdata.nttdatatallermvnarr.services.ManagmentServiceI;

@RestController
@RequestMapping("/api")
public class HomeRestController {

	/** Servicio de gestión de clientes */
	@Autowired
	private ManagmentServiceI managmentService;

	/**
	 * Retorna Listado de Clientes
	 * 
	 * @return
	 */
	@GetMapping // "Recibimos Información"
	public List<Cliente> showAllClientes() {
		return managmentService.getAllCliente();

	}

	/**
	 * Añade nuevo Cliente
	 * 
	 * @param newCliente
	 */
	@PostMapping // Enviamos información
	public void addNuevoCliente(final @RequestBody Cliente newCliente) {
		managmentService.addCliente(newCliente);

	}

	/**
	 * Búsqueda de cliente por Id
	 * 
	 * @param requestCliente
	 * @return Cliente
	 */
	@GetMapping("/findCliente")
	public Cliente searchBy(final @RequestBody Cliente requestCliente) {
		return managmentService.getClienteById(requestCliente.getId());
	}

}
