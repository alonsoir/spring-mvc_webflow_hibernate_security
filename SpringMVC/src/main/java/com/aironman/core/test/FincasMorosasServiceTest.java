package com.aironman.core.test;

import java.math.BigDecimal;

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
import com.aironman.core.pojos.Moroso;
import com.aironman.core.pojos.ServiceResponse;
import com.aironman.core.pojos.ViviendasConDeudas;
import com.aironman.core.pojos.ViviendasConDeudas.TIPOVIVIENDA;
import com.aironman.core.service.ComunidadService;
import com.aironman.core.service.FincasMorosasService;
import com.aironman.core.service.MorosasService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml",
		"classpath:spring/hibernateContext.xml" })
public class FincasMorosasServiceTest {

	private static final Logger LOG = LoggerFactory
			.getLogger(FincasMorosasServiceTest.class);

	@Autowired
	private FincasMorosasService fincasService;

	@Autowired
	private ComunidadService comunidadService;

	@Autowired
	private MorosasService morososService;

	@After
	public void tearDown() throws Exception {

	}

	/**
	 * 
	 ServiceResponse addViviendasConDeudas(ViviendasConDeudas value,
	 * ComunidadVecinos com, Moroso mom);
	 * 
	 * */
	@Test
	public void testaddViviendasConDeudas() {

		String tlffijo = "924233930";
		String nifcif = null;// = "80068096O";
		String tlfmovil = null;// = "667999999";
		Moroso mom = morososService.getMorosoByCriterion(nifcif, tlffijo,
				tlfmovil);

		String direccion = "DIRECCION2";
		ComunidadVecinos com = comunidadService
				.getComunidadVecinosByDireccion(direccion);

		ViviendasConDeudas value = new ViviendasConDeudas();
		value.setDireccionViviendaDeudora("DIRECCION_VIVIENDA_DEUDORA");
		value.setTextoLibreViviendasConDeudas("TEXTO LIBRE!!");
		BigDecimal montante = new BigDecimal("1000000");
		value.setMontante(montante);
		ViviendasConDeudas.TIPOVIVIENDA tipo = TIPOVIVIENDA.APARTAMENTO;
		value.setTipo(tipo);

		ServiceResponse response = fincasService.addViviendasConDeudas(value,
				com.getIdComunidad(), mom.getIdMoroso());

		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getMensaje());
		Assert.assertTrue(response.getEstado());

		ViviendasConDeudas value1 = new ViviendasConDeudas();
		value1.setDireccionViviendaDeudora("DIRECCION_VIVIENDA_DEUDORA_modificada");
		value1.setTextoLibreViviendasConDeudas("TEXTO LIBRE!!");
		montante = new BigDecimal("1000000");
		value1.setMontante(montante);
		tipo = TIPOVIVIENDA.ATICO;
		value1.setTipo(tipo);
		value1.setIdDeuda(response.getIdGenerado());

		response = fincasService.addViviendasConDeudas(value1,
				com.getIdComunidad(), mom.getIdMoroso());

		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getMensaje());
		Assert.assertTrue(response.getEstado());

	}
}
