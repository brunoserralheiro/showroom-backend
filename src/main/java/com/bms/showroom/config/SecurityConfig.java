/**
 * 
 */
package com.bms.showroom.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.bms.showroom.model.service.CustomUserDetailsService;

/**
 * @author Bruno Serralheiro
 *
 */
@Configuration
@EnableGlobalAuthentication
public class SecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		
		.headers()
		.httpStrictTransportSecurity()
		.disable();
		
//		.maxAgeInSeconds(0)
//		.includeSubDomains(true);
		
		
		http
		.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.defaultSuccessUrl("/api/welcome");
	}
	
	  @Override protected void configure(AuthenticationManagerBuilder auth) throws
	  Exception {
	  auth.userDetailsService(userDetailsService());
	  
		  
		  
//	  auth 
//	  		.inMemoryAuthentication()
//	  		.withUser("bruno")
//	  		.password(passwordEncoder().encode("pass"))
//	  		.authorities(Collections.emptyList());
	  		
	  
	  
	  }
	  
	  
	  
//	  @Bean
//	  protected BCryptPasswordEncoder passwordEncoder() {
//	  
//	  return new BCryptPasswordEncoder(); 
//	  }
//	  
	  @Bean
	  public UserDetailsService userDetailsService() {
		  return  customUserDetailsService;
	  }
	 

}
