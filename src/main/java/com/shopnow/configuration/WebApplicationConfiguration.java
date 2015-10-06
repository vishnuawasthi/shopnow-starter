package com.shopnow.configuration;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.shopnow.filter.RequestInterceptor;
import com.shopnow.security.configuration.SecurityConfiguration;
@EnableSpringDataWebSupport 
@EnableWebMvc
@Configuration
@Import(value ={
					SecurityConfiguration.class,
					JPAConfiguration.class,
					EmailConfiguration.class,
					/*RabbitMQConfiguration.class,
					RabbitMQIntegrationConfiguration.class*/
					})
@PropertySource(
		value = {		"classpath:database.properties",
						"classpath:web.properties"
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
						"com.shopnow.rabbitmq"
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
	public InternalResourceViewResolver jspViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
													viewResolver.setPrefix("/WEB-INF/jsp/");
													viewResolver.setSuffix(".jsp");
													viewResolver.setViewClass(JstlView.class);
													viewResolver.setContentType("text/html");
													return viewResolver;
	}

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getMultipartResolver() {
		return new CommonsMultipartResolver();
	}

	@Bean(name = "messageSource")
	public ReloadableResourceBundleMessageSource getMessageSource() {
		ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
														 resource.setBasename("classpath:messages");
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

}
