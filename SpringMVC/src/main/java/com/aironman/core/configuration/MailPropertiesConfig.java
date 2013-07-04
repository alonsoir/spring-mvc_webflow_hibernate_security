package com.aironman.core.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:mail.properties")
public class MailPropertiesConfig {

	@Autowired
	Environment env;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public MailBean getMailProperties() {
		MailBean mailBean = new MailBean();
		mailBean.setUserMail(env.getProperty("userMail"));
		mailBean.setPassMail(env.getProperty("passMail"));
		mailBean.setEmailTo(env.getProperty("emailTo"));
		return mailBean;
	}
}
