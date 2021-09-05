package com.tcc.receituario.security;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

import com.tcc.receituario.config.SecurityConfig;

public class Initializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		
		AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
        root.register(SecurityConfig.class);

        ServletContext sc = null;
        
		sc.addListener(new ContextLoaderListener(root));

        sc.addFilter("securityFilter", new DelegatingFilterProxy("springSecurityFilterChain"))
          .addMappingForUrlPatterns(null, false, "/*");
		
	}

}
