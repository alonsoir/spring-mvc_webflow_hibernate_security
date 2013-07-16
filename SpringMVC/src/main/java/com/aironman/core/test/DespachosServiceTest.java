package com.aironman.core.test;

import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aironman.core.pojos.DatosAbogado;
import com.aironman.core.pojos.DatosDemandaAdmin;
import com.aironman.core.pojos.InfoCertificadoDeuda;
import com.aironman.core.pojos.ServiceResponse;
import com.aironman.core.service.DespachoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml",
		"classpath:spring/hibernateContext.xml" })
public class DespachosServiceTest {

	private static final Logger LOG = LoggerFactory
			.getLogger(DespachosServiceTest.class);

	@Autowired
	private DespachoService despachoService;

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testgenerarCertificadoYCrearDemanda() {
		Long idDeuda = 1l;
		String username = "alonsoir";
		ServiceResponse serviceResponse = despachoService
				.generarCertificadoYCrearDemanda(idDeuda, username);
		Assert.assertNotNull(serviceResponse.getMensaje());
		Assert.assertTrue(serviceResponse.getEstado());
	}

	@Test
	public void testtraerInfoParaCertificado() {
		// esto esta fallando ahora!!
		Long idDeuda = 1l;
		String username = "alonsoir";
		InfoCertificadoDeuda info = despachoService.traerInfoParaCertificado(
				idDeuda, username); //
		LOG.info(info.toString());
		Assert.assertNotNull(info);
	}

	@Test
	public void testtraerCertificadosAdmin() {
		// esto esta fallando ahora!!
		List<DatosDemandaAdmin> lista = despachoService
				.traerCertificadosAdmin();
		Assert.assertNotNull(lista);
		Assert.assertTrue(lista.size() > 0);
	}

	@Test
	public void testtraerAbogadosDisponibles() {

		List<DatosAbogado> lista = despachoService.traerAbogadosDisponibles();
		Assert.assertNotNull(lista);
		Assert.assertTrue(lista.size() > 0);
	}
}
