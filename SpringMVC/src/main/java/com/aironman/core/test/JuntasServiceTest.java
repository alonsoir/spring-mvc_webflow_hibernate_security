package com.aironman.core.test;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aironman.core.pojos.JuntasOrdinarias;
import com.aironman.core.pojos.ServiceResponse;
import com.aironman.core.service.JuntasOrdinariasService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml",
		"classpath:spring/hibernateContext.xml" })
public class JuntasServiceTest {

	private static final Logger LOG = LoggerFactory
			.getLogger(JuntasServiceTest.class);

	@Autowired
	private JuntasOrdinariasService juntasService;

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testaddJuntasOrdinarias() {

		JuntasOrdinarias value = new JuntasOrdinarias();
		value.setFechaCelebracion("06/07/2013");
		value.setTextoLibre("TEXTO LIBRE");

		JuntasOrdinarias value1 = new JuntasOrdinarias();
		value1.setFechaCelebracion("06/07/2013");
		value1.setTextoLibre("TEXTO LIBRE MOFICADO");

		ServiceResponse retorno = null;
		ServiceResponse retorno1 = null;
		try {
			retorno = juntasService.addJuntasOrdinarias(value);
			value1.setIdJunta(retorno.getIdGenerado());
			retorno1 = juntasService.addJuntasOrdinarias(value1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOG.info("ERROR al crear la junta de vecinos", e);
			e.printStackTrace();
			Assert.assertNotNull(null);
		}
		Assert.assertNotNull(retorno);
		Assert.assertNotNull(retorno1);
		Assert.assertTrue(retorno.getEstado());
		Assert.assertTrue(retorno1.getEstado());
	}

	@Test
	public void getJuntasOrdinariasByFecha() {

		String fecha = "06/07/2013";
		try {
			List<JuntasOrdinarias> lista = juntasService
					.getJuntasOrdinariasByFecha(fecha);
			Assert.assertNotNull(lista);
			Assert.assertTrue(lista.size() > 0);

			for (JuntasOrdinarias junta : lista) {
				Assert.assertNotNull(junta);
				Assert.assertEquals("06/07/2013", junta.getFechaCelebracion());

			}

		} catch (Exception e) {
			LOG.info("ERROR al traer la junta de vecinos por fecha", e);
			e.printStackTrace();
			Assert.assertNotNull(null);
		}
	}

}
