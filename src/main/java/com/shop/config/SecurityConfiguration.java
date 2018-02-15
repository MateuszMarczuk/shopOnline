package com.shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Mateusz Marczuk
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 15.02.2018.
 */

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
//        authenticationProvider(). to w przypadku bazy
            .withUser("user").password("password").roles("USER").and()
            .withUser("demo").password("test").roles("ADMIN");
    }


    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .authorizeRequests()
            .antMatchers("**/login").hasRole("ADMIN")
//            .antMatchers("**/rest/**")
            .anyRequest()
            .fullyAuthenticated()
            .and().httpBasic();
        httpSecurity.csrf().disable();
    }


}
