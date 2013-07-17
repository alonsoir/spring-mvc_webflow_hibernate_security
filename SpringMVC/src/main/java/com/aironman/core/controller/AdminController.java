package com.aironman.core.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aironman.core.pojos.DatosAbogado;
import com.aironman.core.pojos.DatosAdmin;
import com.aironman.core.pojos.DatosDemandaAdmin;
import com.aironman.core.pojos.ServiceResponse;
import com.aironman.core.service.DespachoService;

@Controller
public class AdminController {

	private static final Logger LOG = LoggerFactory
			.getLogger(AdminController.class);

	@Autowired
	private DespachoService despachoService;

	private List<DatosAbogado> listaDatosAbogados;

	private List<DatosDemandaAdmin> listaDatosDemanda;

	/*
	 * @PostConstruct public void init() {
	 * 
	 * LOG.info("INIT method on AdminController.class...");
	 * this.listaDatosAbogados = despachoService.traerAbogadosDisponibles();
	 * LOG.info("listaDatosAbogados: " + (listaDatosAbogados != null ?
	 * listaDatosAbogados.size() : "LISTA NULA!!"));
	 * 
	 * this.listaDatosDemanda = this.despachoService.traerCertificadosAdmin();
	 * LOG.info("listaDatosDemanda: " + (listaDatosDemanda != null ?
	 * listaDatosDemanda.size() : "LISTA NULA!!"));
	 * 
	 * }
	 */

	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public String asignarAbogadoADemanda(@ModelAttribute DatosAdmin datosAdmin,
			ModelMap model) {

		LOG.info("AdminController.asignarAbogadoADemanda...");
		Long idAbogado = datosAdmin.getIdAbogado();
		Long idDemanda = datosAdmin.getIdDemanda();
		LOG.info("AdminController.asignarAbogadoADemanda. idAbogado: "
				+ idAbogado + " idDemanda: " + idDemanda);
		ServiceResponse serviceResponse = despachoService
				.asignarDemandaAAbogado(idAbogado, idDemanda);

		model.addAttribute("serviceResponse", serviceResponse);

		LOG.info("AdminController.asignarAbogadoADemanda. serviceResponse: "
				+ serviceResponse.toString());

		traerDatosAdmin(model);
		return "admin";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(ModelMap model) {

		LOG.info("AdminController.admin...");

		ServiceResponse serviceResponse = new ServiceResponse();
		model.addAttribute("serviceResponse", serviceResponse);

		traerDatosAdmin(model);
		return "admin";

	}

	private void traerDatosAdmin(ModelMap model) {

		model.addAttribute("datosAbogado", new DatosAdmin());

		this.listaDatosAbogados = despachoService.traerAbogadosDisponibles();

		LOG.info("listaDatosAbogados: "
				+ (listaDatosAbogados != null ? listaDatosAbogados.size()
						: "LISTA NULA!!"));
		Map<Long, String> abogadosDisponibles = new LinkedHashMap<Long, String>();

		if (this.listaDatosAbogados != null
				&& this.listaDatosAbogados.size() > 0) {
			for (DatosAbogado abogadoExistente : listaDatosAbogados) {

				abogadosDisponibles.put(
						abogadoExistente.getIdAbogado(),
						abogadoExistente.getNombre() + " "
								+ abogadoExistente.getApellidos() + " "
								+ abogadoExistente.getTlfContacto() + " "
								+ abogadoExistente.getCiudad());
			}
			model.addAttribute("listaDatosAbogados", abogadosDisponibles);
			model.addAttribute("errorlistaDatosAbogados", "false");
		} else
			model.addAttribute("errorlistaDatosAbogados", "true");

		this.listaDatosDemanda = this.despachoService.traerCertificadosAdmin();
		LOG.info("listaDatosDemanda: "
				+ (listaDatosDemanda != null ? listaDatosDemanda.size()
						: "LISTA NULA!!"));
		LOG.info("AdminController.login...");

		if (this.listaDatosDemanda != null && this.listaDatosDemanda.size() > 0) {
			model.addAttribute("listaDatosDemanda", this.listaDatosDemanda);
			model.addAttribute("errorlistaDatosDemanda", "false");
		} else
			model.addAttribute("errorlistaDatosDemanda", "true");

	}
}