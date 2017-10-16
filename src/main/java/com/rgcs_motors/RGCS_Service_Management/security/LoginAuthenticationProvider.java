package com.rgcs_motors.RGCS_Service_Management.security;

import com.rgcs_motors.RGCS_Service_Management.domain.User;
import com.rgcs_motors.RGCS_Service_Management.exceptions.InvalidCredentialsException;
import com.rgcs_motors.RGCS_Service_Management.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.Set;

@Component
public class LoginAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private LoginService loginService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String email = authentication.getName().trim();   //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> GET EMAIL AND PASSWORD FROM THE FORM
        String password = authentication.getCredentials().toString().trim();

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>AuthProvider mail is :" + email + " and password is : " + password);

        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> CALL OUR LOGINSERVICE TO FETCH USER FROM DB
        User user = loginService.login(email, password);

        Authentication auth = null;
        Set<GrantedAuthority> grantedAuths = new HashSet<>();

        if (user != null){   //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> CREATE AUTHORITY FROM FETCHED USER'S ROLE

            String role = user.getType();
            grantedAuths.add(new SimpleGrantedAuthority(role.trim()));
            auth = new UsernamePasswordAuthenticationToken(email, password, grantedAuths);
        }
        else
        {
            grantedAuths.add(new SimpleGrantedAuthority("notFound"));
            auth = new UsernamePasswordAuthenticationToken(email, password, grantedAuths);
        }
        return auth;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}