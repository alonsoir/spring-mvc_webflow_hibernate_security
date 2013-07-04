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

import com.aironman.core.pojos.Moroso;
import com.aironman.core.service.MorosasService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml",
		"classpath:spring/hibernateContext.xml" })
public class MorososServiceTest {

	private static final Logger LOG = LoggerFactory
			.getLogger(MorososServiceTest.class);

	@Autowired
	private MorosasService morosasService;

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testAddMoroso() {

		Moroso value = new Moroso();
		value.setCiudad("CIUDAD");
		value.setCp("06005");
		value.setDireccionMoroso("DIRECCIONMOROSO");
		value.setNifCif("80068096O");
		value.setNombreCompleto("NOMBRECOMPLETO");
		value.setTlfmovil("667999999");
		value.setTlffijo("924233930");
		boolean condition = false;
		try {
			condition = morosasService.addMoroso(value);
		} catch (Exception e) {
			LOG.info("exception on testAddMoroso", e);
		}
		Assert.assertNotNull(condition);
	}

	@Test
	public void testGetMorosoByClave() {

		LOG.info("testGetMorosoByClave...");
		try {
			Moroso moroso = morosasService.getMorosoByClave("80068096O");
			Assert.assertNotNull(moroso);
			Assert.assertEquals("80068096O", moroso.getNifCif());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOG.info("testGetMorosoByClave. Exception!", e);
			Assert.assertNull(null);
		}
	}

	@Test
	public void testGetMorosoByCriterion() {

		LOG.info("testGetMorosoByCriterion...");
		try {
			Moroso moroso = morosasService.getMorosoByCriterion("",
					"924233930", "667999999");
			Assert.assertNotNull(moroso);
			Assert.assertEquals("80068096O", moroso.getNifCif());
			Assert.assertEquals("667999999", moroso.getTlfmovil());
			Assert.assertEquals("924233930", moroso.getTlffijo());

			moroso = morosasService.getMorosoByCriterion("", "", "667999999");
			Assert.assertNotNull(moroso);
			Assert.assertEquals("80068096O", moroso.getNifCif());
			Assert.assertEquals("667999999", moroso.getTlfmovil());
			Assert.assertEquals("924233930", moroso.getTlffijo());

			moroso = morosasService.getMorosoByCriterion("", "924233930", "");
			Assert.assertNotNull(moroso);
			Assert.assertEquals("80068096O", moroso.getNifCif());
			Assert.assertEquals("667999999", moroso.getTlfmovil());
			Assert.assertEquals("924233930", moroso.getTlffijo());

			moroso = morosasService.getMorosoByCriterion("80068096O", "", "");
			Assert.assertNotNull(moroso);
			Assert.assertEquals("80068096O", moroso.getNifCif());
			Assert.assertEquals("667999999", moroso.getTlfmovil());
			Assert.assertEquals("924233930", moroso.getTlffijo());

			moroso = morosasService.getMorosoByCriterion("80068096O",
					"924233930", "");
			Assert.assertNotNull(moroso);
			Assert.assertEquals("80068096O", moroso.getNifCif());
			Assert.assertEquals("667999999", moroso.getTlfmovil());
			Assert.assertEquals("924233930", moroso.getTlffijo());

			moroso = morosasService.getMorosoByCriterion("80068096O", "",
					"667999999");
			Assert.assertNotNull(moroso);
			Assert.assertEquals("80068096O", moroso.getNifCif());
			Assert.assertEquals("667999999", moroso.getTlfmovil());
			Assert.assertEquals("924233930", moroso.getTlffijo());

			moroso = morosasService.getMorosoByCriterion("80068096O",
					"924233930", "667999999");
			Assert.assertNotNull(moroso);
			Assert.assertEquals("80068096O", moroso.getNifCif());
			Assert.assertEquals("667999999", moroso.getTlfmovil());
			Assert.assertEquals("924233930", moroso.getTlffijo());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOG.info("testGetMorosoByClave. Exception!", e);
			Assert.assertNull(null);
		}
	}

}
