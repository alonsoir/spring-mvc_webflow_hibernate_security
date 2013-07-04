package com.aironman.core.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aironman.core.configuration.CertificadosBean;
import com.aironman.core.configuration.CertificadosPropertiesConfig;

@Controller
public class CertificadosController {

	private static final Logger LOG = LoggerFactory
			.getLogger(CertificadosController.class);

	@Autowired
	private CertificadosPropertiesConfig properties;

	/**
	 * en ppio esto sirve para mostrar un pdf
	 * */
	@RequestMapping(value = "/files/{file_name}", method = RequestMethod.GET)
	@ResponseBody
	public FileSystemResource getFile(@PathVariable("file_name") String fileName) {
		LOG.info("Vamos a mostrar al cliente el pdf generado. fileName: "
				+ fileName);
		CertificadosBean beanProperties = properties
				.getCertificadosProperties();

		LOG.info("beanProperties: " + beanProperties.toString());
		String dirDespliegue = beanProperties.getDIRECTORIO_DESPLIEGUE();
		StringBuilder sb = new StringBuilder();
		sb.append(dirDespliegue);
		sb.append(fileName);
		sb.append(".pdf");
		LOG.info("CertificadosController.getFile. Vamos a devolver por este servlet esto: "
				+ sb.toString());
		return new FileSystemResource(sb.toString());
	}
}