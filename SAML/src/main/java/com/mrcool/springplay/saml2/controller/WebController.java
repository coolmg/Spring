/*
 * Copyright 2021-2021 MrCool.
 *
 */

package com.mrcool.springplay.saml2.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticatedPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Class name.
 *
 * @author Mahendra Gadila.
 * @since 1.0.0
 */
@Controller
public class WebController {

	@GetMapping("/")
	public String index(Model model, @AuthenticationPrincipal Saml2AuthenticatedPrincipal principal) {
		String emailAddress = principal.getFirstAttribute("emailAddress");
		model.addAttribute("emailAddress", emailAddress);
		model.addAttribute("userAttributes", principal.getAttributes());
		return "index";
	}

}
