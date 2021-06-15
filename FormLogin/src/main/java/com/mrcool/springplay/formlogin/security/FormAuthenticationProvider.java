/*
 * Copyright 2021-2021 MrCool.
 *
 */

package com.mrcool.springplay.formlogin.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

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

        User user = new User(username, password);
        User user = callAtlassianCrowdRestService(username, password); // (2)
        if (user == null) {                                     // (3)
            throw new AuthenticationCredentialsNotFoundException("could not login");
        }
        return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities()); // (4)
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
