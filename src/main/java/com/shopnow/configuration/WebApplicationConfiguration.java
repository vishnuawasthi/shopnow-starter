package com.shopnow.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityLayoutViewResolver;

import com.shopnow.filter.RequestInterceptor;
import com.shopnow.security.configuration.SecurityConfiguration;
@EnableSpringDataWebSupport 
@EnableWebMvc
@Configuration
@Import(value ={
					SecurityConfiguration.class,
					JPAConfiguration.class,
					EmailConfiguration.class,
					HibernateConfiguration.class
					/*RabbitMQConfiguration.class,
					RabbitMQIntegrationConfiguration.class*/
					})
@PropertySource(
		value = {		"classpath:database.properties",
						"classpath:web.properties",
						"classpath:payment-gateway.properties"
				}
		)

@ComponentScan({	    "com.shopnow.configuration",
					    "com.shopnow.controller",
						"com.shopnow.rest.controller",
						"com.shopnow.dao",
						"com.shopnow.service",
						"com.shopnow.entity",
						"com.shopnow.assembler",
						"com.shopnow.security.configuration",
						"com.shopnow.security.service",
						"com.shopnow.utils",
						"com.shopnow.form",
						"com.shopnow.rabbitmq",
						"com.shopnow.repository",
						"com.shopnow.rest.support",
						"com.shopnow.mqreceiver"
		})
public class WebApplicationConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new RequestInterceptor());

	}

	/*@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		Map<String, MediaType> mediaTypes = new HashMap<String, MediaType>();
											mediaTypes.put("atom", MediaType.APPLICATION_ATOM_XML);
											mediaTypes.put("html", MediaType.TEXT_HTML);
											mediaTypes.put("json", MediaType.APPLICATION_JSON);
											configurer.mediaTypes(mediaTypes);
	}*/

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
											registry.addResourceHandler("/resources/css/**").addResourceLocations("/resources/css/");
											registry.addResourceHandler("/resources/script/**").addResourceLocations("/resources/script/");
											registry.addResourceHandler("/resources/images/**").addResourceLocations("/resources/images/");
				
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Bean
	public ResourceBundleViewResolver getResourceBundleViewResolver() {
		ResourceBundleViewResolver viewResolver = new ResourceBundleViewResolver();
		viewResolver.setBasename("views");
		viewResolver.setOrder(1);
		return viewResolver;
	}
	
	@Bean
	public InternalResourceViewResolver jspViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
													viewResolver.setPrefix("/WEB-INF/jsp/");
													viewResolver.setSuffix(".jsp");
													viewResolver.setViewClass(JstlView.class);
													viewResolver.setContentType("text/html");
													viewResolver.setOrder(2);
													return viewResolver;
	}

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getMultipartResolver() {
		CommonsMultipartResolver viewResolver= new CommonsMultipartResolver();
		viewResolver.setMaxUploadSize(90000000);
		
		return viewResolver;
	}

	@Bean(name = "messageSource")
	public ReloadableResourceBundleMessageSource getMessageSource() {
		ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
														// resource.setBasename("classpath:messages");
														 resource.setBasenames("classpath:messages");
														 resource.setDefaultEncoding("UTF-8");
														 return resource;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
														return new PropertySourcesPlaceholderConfigurer();
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
													    converters.addAll(getMessageConverters());
	}

	private List<HttpMessageConverter<?>> getMessageConverters() {
		List<HttpMessageConverter<?>> converters =  new ArrayList<HttpMessageConverter<?>>();
													converters.add(new MappingJackson2HttpMessageConverter());
													return converters;
	}
	
	// Velocity Support
	@Bean
	public VelocityLayoutViewResolver velocityViewResolver() {
		VelocityLayoutViewResolver viewResolver = new VelocityLayoutViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/velocity/");
		// URL Key Default is layout
		viewResolver.setLayoutUrl("/WEB-INF/views/layout/layout.vm");
		viewResolver.setSuffix(".vm");
		viewResolver.setOrder(3);
		return viewResolver;
	}

	// This bean is need in order to get the response of velocity template on
	// browser
	@Bean
	public VelocityConfigurer velocityConfig() {
		VelocityConfigurer velocityConfig = new VelocityConfigurer();
		velocityConfig.setResourceLoaderPath("/");
		// velocityConfig.setVelocityEngine( velocityEngine());
		velocityConfig.setPreferFileSystemAccess(true);
		return velocityConfig;
	}

	@Bean
	public VelocityEngineFactoryBean velocityEngineFactoryBean() {
		VelocityEngineFactoryBean velocityEngine = new VelocityEngineFactoryBean();
		Properties velocityProperties = new Properties();
		velocityProperties.setProperty("resource.loader", "class");
		velocityProperties.setProperty("class.resource.loader.class",
				"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		velocityEngine.setVelocityProperties(velocityProperties);
		return velocityEngine;
	}
	
}
