package com.aironman.core.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:certificados.properties")
public class CertificadosPropertiesConfig {

	@Autowired
	Environment env;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public CertificadosBean getCertificadosProperties() {
		CertificadosBean cert = new CertificadosBean();
		cert.setDIRECTORIO_DESPLIEGUE(env.getProperty("DIRECTORIO_DESPLIEGUE"));
		cert.setRUTA_PLANTILLA(env.getProperty("RUTA_PLANTILLA"));

		cert.setRUTA_CONEXION_DB(env.getProperty("RUTA_CONEXION_DB"));
		cert.setUSUARIO_DB(env.getProperty("USUARIO_DB"));
		cert.setPASS_DB(env.getProperty("PASS_DB"));
		return cert;
	}
}
