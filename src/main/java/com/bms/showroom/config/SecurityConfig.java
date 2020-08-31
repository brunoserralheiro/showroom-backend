/**
 * 
 */
package com.bms.showroom.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Bruno Serralheiro
 *
 */
@Configuration
@EnableGlobalAuthentication
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
			.defaultSuccessUrl("/api/welcome");
	}
	
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * 
	 * auth .inMemoryAuthentication(); // .passwordEncoder(passwordEncoder())
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * private BCryptPasswordEncoder passwordEncoder() {
	 * 
	 * return new BCryptPasswordEncoder(); }
	 */
	

}
