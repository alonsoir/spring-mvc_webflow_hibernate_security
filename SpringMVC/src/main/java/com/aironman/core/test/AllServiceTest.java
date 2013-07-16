package com.aironman.core.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Suite.class)
@Suite.SuiteClasses({ JuntasServiceTest.class,
		ComunidadVecinosServiceTest.class, MorososServiceTest.class,
		FincasMorosasServiceTest.class, CertificadosServiceTest.class,
		CertificadosControllerTest.class, DespachosServiceTest.class })
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml",
		"classpath:spring/hibernateContext.xml" })
public class AllServiceTest {
}
