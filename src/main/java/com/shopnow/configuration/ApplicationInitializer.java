/**
 * 
 */
package com.shopnow.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author Vishnu Awasthi
 *
 */
public class ApplicationInitializer implements WebApplicationInitializer {
	
	private static final String CONFIG_LOCATION = "com.shopnow.configuration";
	
	private static final String MAPPING_URL = "/*";
	
	public void onStartup(ServletContext servletContext)throws ServletException {
		
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
												context.register(WebApplicationConfiguration.class);
												context.setServletContext(servletContext);
												context.setConfigLocation(CONFIG_LOCATION);
												servletContext.addListener(new ContextLoaderListener(context));
			
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(context));
												 dispatcher.setLoadOnStartup(1);
												 dispatcher.addMapping(MAPPING_URL);
														
	}
	
}
