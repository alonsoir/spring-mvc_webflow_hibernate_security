package com.aironman.core.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
		"classpath:spring/mvc-dispatcher-servlet.xml",
		"classpath:spring/applicationContext.xml",
		"classpath:spring/hibernateContext.xml" })
public class AdminControllerTest {

	private static final Logger LOG = LoggerFactory
			.getLogger(AdminControllerTest.class);

	@Autowired
	WebApplicationContext wac;
	@Autowired
	MockHttpSession session;
	@Autowired
	MockHttpServletRequest request;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testadmin() {

		LOG.info("testadmin...");
		// User user = new User("USERNAME", "pass", null);
		//
		// session.setAttribute("sessionParm", user);
		try {
			this.mockMvc.perform(get("/admin")).andExpect(status().isOk());
			LOG.info("testadmin executed!");
		} catch (Exception e1) {
			LOG.error("ERROR!", e1);
			e1.printStackTrace();
		}

	}
}
