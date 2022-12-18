package com.nttdata.nttdatatallermvnarr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.nttdatatallermvnarr.persistence.Contrato;
import com.nttdata.nttdatatallermvnarr.services.ContratoManagmentServiceI;


public class HomeRestControllerContrato {
	@RestController
	@RequestMapping("/controllerapi")
	public class HomeRestController {

		/** Servicio de gestión de clientes */
		@Autowired
		private ContratoManagmentServiceI managmentService;

		/**
		 * Retorna Listado de Contratos
		 * 
		 * @return
		 */
		@GetMapping // "Recibimos Información"
		public List<Contrato> showAllContrato() {
			return managmentService.getAllContrato();

		}

		/**
		 * Añade nuevo Contrato
		 * 
		 * @param newContrato
		 */
		@PostMapping // Enviamos información
		public void addNuevoCliente(final @RequestBody Contrato newContrato) {
			managmentService.addContrato(newContrato);

		}

		/**
		 * Búsqueda de contrato por Id
		 * 
		 * @param requestCliente
		 * @return ContratoID
		 */
		@GetMapping("/findContrato")
		public Contrato searchBy(final @RequestBody Contrato requestCliente) {
			return managmentService.getContratoById(requestCliente.getIdContrato());
		}

	}

}
