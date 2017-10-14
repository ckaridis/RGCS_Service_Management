package com.rgcs_motors.RGCS_Service_Management;

import com.rgcs_motors.RGCS_Service_Management.security.LoginAuthenticationProvider;
import com.rgcs_motors.RGCS_Service_Management.security.SuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {   //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> OUR SPRING SECURITY CONFIGURATION CLASS

    @Autowired
    private SuccessHandler successHandler;

    @Autowired
    private LoginAuthenticationProvider loginAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {  //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> OUR SECURITY POLICY
        http.authorizeRequests()
                .antMatchers("/admin/**").hasAuthority("Admin")
                .antMatchers("/owner/**").hasAuthority("Owner")
                .antMatchers("/css/**","/js/**","/res/**").permitAll()
                .anyRequest().fullyAuthenticated()
                .and().csrf().disable()
                .formLogin().successHandler(successHandler)
                .loginPage("/loginValidation")
                .permitAll()
                .usernameParameter("email")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(loginAuthenticationProvider);
    }
}
