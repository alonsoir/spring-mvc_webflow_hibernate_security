package com.aironman.core.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aironman.core.pojos.DatosAbogado;
import com.aironman.core.pojos.DatosDemandaAdmin;
import com.aironman.core.service.DespachoService;

@Controller
public class AdminController {

	private static final Logger LOG = LoggerFactory
			.getLogger(AdminController.class);

	@Resource
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
	protected Map referenceData(HttpServletRequest request) throws Exception {

		LOG.info("referenceData on AdminController...");

		Map referenceData = new HashMap();

		this.listaDatosAbogados = despachoService.traerAbogadosDisponibles();
		LOG.info("listaDatosAbogados: "
				+ (listaDatosAbogados != null ? listaDatosAbogados.size()
						: "LISTA NULA!!"));

		LOG.info("AdminController.login...");
		Map<Long, String> abogadosDisponibles = new LinkedHashMap<Long, String>();

		if (this.listaDatosAbogados != null
				&& this.listaDatosAbogados.size() > 0) {
			for (DatosAbogado abogadoExistente : listaDatosAbogados) {

				abogadosDisponibles.put(
						abogadoExistente.getIdAbogado(),
						abogadoExistente.getNombre() + " "
								+ abogadoExistente.getApellidos());
				referenceData.put("listaDatosAbogados", abogadosDisponibles);
			}

		}

		return referenceData;
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(ModelMap model) {

		this.listaDatosAbogados = despachoService.traerAbogadosDisponibles();
		LOG.info("listaDatosAbogados: "
				+ (listaDatosAbogados != null ? listaDatosAbogados.size()
						: "LISTA NULA!!"));

		Map referenceData = new HashMap();

		this.listaDatosAbogados = despachoService.traerAbogadosDisponibles();

		LOG.info("listaDatosAbogados: "
				+ (listaDatosAbogados != null ? listaDatosAbogados.size()
						: "LISTA NULA!!"));

		LOG.info("AdminController.login...");
		Map<Long, String> abogadosDisponibles = new LinkedHashMap<Long, String>();

		if (this.listaDatosAbogados != null
				&& this.listaDatosAbogados.size() > 0) {
			for (DatosAbogado abogadoExistente : listaDatosAbogados) {

				abogadosDisponibles.put(
						abogadoExistente.getIdAbogado(),
						abogadoExistente.getNombre() + " "
								+ abogadoExistente.getApellidos());
				referenceData.put("listaDatosAbogados", abogadosDisponibles);
			}
			model.addAttribute("listaDatosAbogados", referenceData);
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

		return "admin";

	}
}