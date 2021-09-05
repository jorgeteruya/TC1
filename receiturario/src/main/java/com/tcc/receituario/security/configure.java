package com.tcc.receituario.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class configure {
	
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		
		//TODO: Trocar exemplo 'user1'para input to front
	    auth.inMemoryAuthentication()
	        .withUser("user1").password(passwordEncoder().encode("user1Pass")).roles("USER")
	        .and()
	        .withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER")
	        .and()
	        .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
	}
	
	@Bean 
	public PasswordEncoder passwordEncoder() { 
	    return new BCryptPasswordEncoder(); 
	}

}
