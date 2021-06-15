/*
 * Copyright 2021-2021 MrCool.
 *
 */

package com.mrcool.springplay.formlogin.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Class name.
 *
 * @author Mahendra Gadila.
 * @since 1.0.0
 */
public class FormAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getPrincipal().toString(); // (1)
		String password = authentication.getCredentials().toString(); // (1)

		UserDetails userDetails = User.withUsername(username).password(password).build();
		return new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(),
				userDetails.getAuthorities()); // (4)
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return false;
	}

}
