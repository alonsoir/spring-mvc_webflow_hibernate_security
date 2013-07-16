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

import com.aironman.core.pojos.CertificadosServiceResponse;
import com.aironman.core.pojos.DatosDemanda;
import com.aironman.core.service.CertificadosService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml",
		"classpath:spring/hibernateContext.xml" })
public class CertificadosServiceTest {

	private static final Logger LOG = LoggerFactory
			.getLogger(CertificadosServiceTest.class);

	@Autowired
	private CertificadosService certificadosService;

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testGenerarCertificadoCelebracionJunta() {

		String username = "alonsoir";
		Long idDeuda = 1l;
		CertificadosServiceResponse retorno = certificadosService
				.generarCertificadoCelebracionJunta(idDeuda, username);
		LOG.info("testGenerarCertificadoCelebracionJunta: " + retorno);
		Assert.assertNotNull(retorno);
		Assert.assertTrue(retorno.getEstado());
		Assert.assertNotNull(retorno.getMensaje());
		Assert.assertNotNull(retorno.getRutaDoc());
		Assert.assertNotNull(retorno.getRutaHtml());
		Assert.assertNotNull(retorno.getRutaPdf());
	}

	@Test
	public void testTraerCertificados() {

		String username = "alonsoir";
		List<DatosDemanda> lista = certificadosService
				.traerCertificados(username);
		LOG.info("testTraerCertificados: " + lista.size());
		Assert.assertNotNull(lista);
	}

}
