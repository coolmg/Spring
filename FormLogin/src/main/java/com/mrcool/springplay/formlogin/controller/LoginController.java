/*
 * Copyright 2021-2021 MrCool.
 *
 */

package com.mrcool.springplay.formlogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Class name.
 *
 * @author Mahendra Gadila.
 * @since 1.2.0
 */
@Controller
public class LoginController {

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/login")
	String login() {
		return "login";
	}

}
