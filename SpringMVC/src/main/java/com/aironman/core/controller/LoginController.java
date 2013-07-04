package com.aironman.core.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	private static final Logger LOG = LoggerFactory
			.getLogger(LoginController.class);

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String printWelcome(ModelMap model, Principal principal) {

		LOG.info("LoginController.printWelcome...");
		String name = principal.getName();
		model.addAttribute("username", name);
		LOG.info("LoginController.printWelcome. username: " + name);
		model.addAttribute("message", "Spring Security Custom Form example");
		return "hello";

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {

		LOG.info("LoginController.login...");

		return "login";

	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {

		model.addAttribute("error", "true");
		return "login";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {

		return "login";

	}

	@RequestMapping(value = "/invalidSession.htm", method = RequestMethod.GET)
	public String invalidSession(ModelMap model) {

		LOG.info("LoginController.invalidSession...");

		return "login";

	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String forbidden(ModelMap model) {

		LOG.info("LoginController.forbidden...");

		return "403";

	}
}