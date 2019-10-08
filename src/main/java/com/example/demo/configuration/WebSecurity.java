package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{

	@Autowired
	@Qualifier("userService")
	private UserService userDetailsService; 
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests() //desactica la autorización
	.antMatchers("/login").permitAll() //permitimos el acceso a /login a cualquiera
	.anyRequest().authenticated() //cualquier otra peticion requiere autenticación
	.and()
	// Las peticiones /login pasaran previamente por este filtro 
	.addFilterBefore(new LoginFilter("/login", authenticationManager()),
			UsernamePasswordAuthenticationFilter.class)
	
	// Las demás peticiones pasarán por este filtro para validar el token
	.addFilterBefore(new JwtFilter(),
			UsernamePasswordAuthenticationFilter.class);
	}
	
}	
