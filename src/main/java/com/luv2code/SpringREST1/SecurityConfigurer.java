package com.luv2code.SpringREST1;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//Testing password encoding
		//auth.userDetailsService(userDetailsService);
		//End Testing password encoding
		
		//password is: password for all users : refer to https://www.browserling.com/tools/bcrypt for encrypting password
		auth.userDetailsService(userDetailsService).passwordEncoder(encodePWD());
		
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
	//	http.authorizeRequests()
	//	.antMatchers("/admin").hasRole("ADMIN")
	//	.antMatchers("/user").hasAnyRole("ADMIN","USER")
	//	.antMatchers("/").permitAll()
	//	.and().formLogin();
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/api/customers").hasRole("USER")
		.antMatchers(HttpMethod.GET, "/api/customers/**").hasRole("USER")
		.antMatchers(HttpMethod.POST, "/api/customers").hasAnyRole("MANAGER", "ADMIN")
		.antMatchers(HttpMethod.POST, "/api/customers/**").hasAnyRole("MANAGER", "ADMIN")
		.antMatchers(HttpMethod.PUT, "/api/customers").hasAnyRole("MANAGER", "ADMIN")
		.antMatchers(HttpMethod.PUT, "/api/customers/**").hasAnyRole("MANAGER", "ADMIN")
		.antMatchers(HttpMethod.DELETE, "/api/customers/**").hasRole("ADMIN")
		.and()
		.httpBasic()
		.and()
		.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}
	
	//Testing password encoding
	//@SuppressWarnings("deprecation")
	//@Bean
	//public PasswordEncoder getPasswordEncoder() {
		
	//	return NoOpPasswordEncoder.getInstance();
	//}
	//End Testing password encoding
	
	
	
	//password is: "password" for all users : refer to https://www.browserling.com/tools/bcrypt for encrypting password
	
	@Bean
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	

}














