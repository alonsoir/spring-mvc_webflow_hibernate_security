package com.aironman.core.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aironman.core.pojos.ComunidadVecinos;
import com.aironman.core.pojos.ComunidadVecinos.TIPO_COMUNIDAD;
import com.aironman.core.pojos.JuntasOrdinarias;
import com.aironman.core.pojos.Users;
import com.aironman.core.service.ComunidadService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml",
		"classpath:spring/hibernateContext.xml" })
public class ComunidadVecinosServiceTest {

	private static final Logger LOG = LoggerFactory
			.getLogger(ComunidadVecinosServiceTest.class);

	@Autowired
	private ComunidadService comunidadService;

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testaddComunidadVecinos() {

		JuntasOrdinarias juntas = null;
		String username = "alonsoir";
		Users usuario = new Users();
		usuario.setUserName(username);

		// los dos ya existen
		ComunidadVecinos value = new ComunidadVecinos();
		value.setAdministradorFincas("ADMIN");
		value.setCiudad("CIUDAD");
		value.setCp("06005");
		// direccion y refCatastral son unique en bd
		value.setDireccion("DIRECCION");
		value.setRefCatastral("REFCATASTRALREFCATA");
		value.setNombreComunidad("NOMBRECOMUNIDAD");
		value.setPresidenteCC("PRESIDENTE");

		TIPO_COMUNIDAD tipoParcela = TIPO_COMUNIDAD.RUSTICA;
		value.setTipoParcela(tipoParcela);
		value.setUsuario(usuario);

		boolean retorno = comunidadService.addComunidadVecinos(value, juntas,
				usuario, username);
		Assert.assertTrue(retorno);
		//
		// ComunidadVecinos valueIgual = new ComunidadVecinos();
		// valueIgual.setAdministradorFincas("ADMIN");
		// valueIgual.setCiudad("CIUDAD");
		// valueIgual.setCp("06005");
		// valueIgual.setDireccion("DIRECCION");
		// valueIgual.setNombreComunidad("NOMBRECOMUNIDAD");
		// valueIgual.setPresidenteCC("PRESIDENTE");
		// valueIgual.setRefCatastral("REFCATASTRALREFCATA");
		// tipoParcela = TIPO_COMUNIDAD.RUSTICA;
		// valueIgual.setTipoParcela(tipoParcela);
		// valueIgual.setUsuario(usuario);
		//
		// retorno = comunidadService.addComunidadVecinos(valueIgual, juntas,
		// usuario, username);
		// Assert.assertFalse(retorno);

	}

	@Test
	public void testGetComunidadVecinosByDireccion() {

		ComunidadVecinos comunidad = comunidadService
				.getComunidadVecinosByDireccion("direccion comunidad");
		Assert.assertNotNull(comunidad);
		Assert.assertEquals("direccion comunidad", comunidad.getDireccion());
	}

	@Test
	public void testGetComunidadVecinosByCriterion() {

		String refCatastral = "12312312312312312312";
		String direccion = "direccion comunidad";

		ComunidadVecinos comunidad = comunidadService
				.getComunidadVecinosByCriterion(refCatastral, direccion);
		Assert.assertNotNull(comunidad);
		Assert.assertEquals("direccion comunidad", comunidad.getDireccion());
	}
}
