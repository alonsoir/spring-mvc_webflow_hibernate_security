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

import com.aironman.core.pojos.ComunidadVecinos;
import com.aironman.core.pojos.ComunidadVecinos.TIPO_COMUNIDAD;
import com.aironman.core.pojos.JuntasOrdinarias;
import com.aironman.core.pojos.ServiceResponse;
import com.aironman.core.pojos.Users;
import com.aironman.core.service.ComunidadService;
import com.aironman.core.service.JuntasOrdinariasService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml",
		"classpath:spring/hibernateContext.xml" })
public class ComunidadVecinosServiceTest {

	private static final Logger LOG = LoggerFactory
			.getLogger(ComunidadVecinosServiceTest.class);

	@Autowired
	private ComunidadService comunidadService;

	@Autowired
	private JuntasOrdinariasService juntasService;

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testaddComunidadVecinos() {

		String fecha = "06/07/2013";

		JuntasOrdinarias junta = new JuntasOrdinarias();
		junta.setFechaCelebracion(fecha);
		junta.setTextoLibre("TEXTO LIBRE");
		juntasService.addJuntasOrdinarias(junta);

		List<JuntasOrdinarias> listaJuntas = juntasService
				.getJuntasOrdinariasByFecha(fecha);
		JuntasOrdinarias juntaLeida = listaJuntas.get(0);

		// UNA COMUNIDAD NUEVA
		ComunidadVecinos com2 = new ComunidadVecinos();
		com2.setAdministradorFincas("ADMIN1");
		com2.setCiudad("CIUDAD1");
		com2.setCp("06006");
		// direccion y refCatastral son unique en bd
		com2.setDireccion("OTRADIRECCION");
		com2.setRefCatastral("OTRAREFERENCATASTRAL");
		com2.setNombreComunidad("NOMBRECOMUNIDAD1");
		com2.setPresidenteCC("PRESIDENTE1");

		TIPO_COMUNIDAD tipoParcela = TIPO_COMUNIDAD.URBANA;
		com2.setTipoParcela(tipoParcela);
		Users usuario = new Users();
		String username = "alonsoir";
		usuario.setUserName(username);
		com2.setUsuario(usuario);

		ServiceResponse retorno = comunidadService.addComunidadVecinos(com2,
				juntaLeida.getIdJunta(), username);
		Assert.assertTrue(retorno.getEstado());

		// los dos ya existen
		ComunidadVecinos com1 = new ComunidadVecinos();
		com1.setAdministradorFincas("ADMIN2");
		com1.setCiudad("CIUDAD2");
		com1.setCp("06002");
		// direccion y refCatastral son unique en bd
		com1.setDireccion("DIRECCION2");
		com1.setRefCatastral("REFCATASTRALREFCATA");
		com1.setNombreComunidad("NOMBRECOMUNIDAD1");
		com1.setPresidenteCC("PRESIDENTE1");

		tipoParcela = TIPO_COMUNIDAD.RUSTICA;
		com1.setTipoParcela(tipoParcela);
		usuario.setUserName(username);
		com1.setUsuario(usuario);

		ServiceResponse retorno1 = comunidadService.addComunidadVecinos(com1,
				juntaLeida.getIdJunta(), username);
		Assert.assertTrue(retorno1.getEstado());

	}

	@Test
	public void testGetComunidadVecinosByDireccion() {

		ComunidadVecinos comunidad = comunidadService
				.getComunidadVecinosByDireccion("OTRADIRECCION");
		Assert.assertNotNull(comunidad);
		Assert.assertEquals("OTRADIRECCION", comunidad.getDireccion());
	}

	@Test
	public void testGetComunidadVecinosByCriterion() {

		String refCatastral = "OTRAREFERENCATASTRAL";
		String direccion = null;// = "OTRADIRECCION";

		ComunidadVecinos comunidad = comunidadService
				.getComunidadVecinosByCriterion(refCatastral, direccion);
		Assert.assertNotNull(comunidad);
		Assert.assertEquals("OTRADIRECCION", comunidad.getDireccion());
		Assert.assertEquals("OTRAREFERENCATASTRAL", comunidad.getRefCatastral());
	}
}
