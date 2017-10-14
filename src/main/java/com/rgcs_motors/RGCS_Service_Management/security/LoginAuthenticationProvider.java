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

        User user = null;  //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> CALL OUR LOGINSERVICE TO FETCH USER FROM DB
        try {
            user = loginService.login(email, password);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("User not found");
            throw new InvalidCredentialsException("User not found!");
        }
        Authentication auth = null;

        if (user != null){   //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> CREATE AUTHORITY FROM FETCHED USER'S ROLE

            String role = user.getType();
            Set<GrantedAuthority> grantedAuths = new HashSet<>();
            grantedAuths.add(new SimpleGrantedAuthority(role.trim()));
            auth = new UsernamePasswordAuthenticationToken(email, password, grantedAuths);
        }
        else
        {
            Set<GrantedAuthority> grantedAuths = new HashSet<>();
            grantedAuths.add(new SimpleGrantedAuthority("ghost"));
            auth = new UsernamePasswordAuthenticationToken(email, password, grantedAuths);
        }
        return auth;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}