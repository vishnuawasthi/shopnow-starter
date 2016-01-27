package com.shopnow.rest.support;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Customize rest client which is able to make GET, and POST request calls to the rest services.
 * @author Vishnu Awasthi, Valuelabs LLP
 *
 */
@Component
public class ShopnowRestClient <T> {
	 private RestTemplate restTemplate ;
	  
	  private ResponseEntity<String> result = null;
	  
	  private  final String API_KEY ="api-key";

	  /**
	   * This method makes an GET call to the specified request 
	   * @param requestURL , URL of the requested resource
	   * @param requestBodyMap , Request parameters, All the request parameters should be kept in the form of entry as (key,Value) 
	   * @return json response
	   */
	  public String get(String requestURL,  Map<String, ?> requestBodyMap) {
		restTemplate = getRestTemplate();
		result = restTemplate.getForEntity(requestURL, String.class, requestBodyMap);
		if (result != null) {
		return   result.getBody();
		}
		return null;
	  }

	  /**
	   * This method makes an POST call to the specified request
	   * 
	   * @param requestURL , URL of the requested resource
	   *         
	   * @param requestBody , This is json string data , Which we are intended to post
	   *         
	   * @return json response
	   */

	  public String post(String requestURL,  String requestBody) {
		restTemplate = getRestTemplate();
		result = restTemplate.postForEntity(requestURL, new HttpEntity<String>(requestBody, getHeaders()), String.class);
		if (result != null) {
		  return result.getBody();
		}
		return null;
	  }

	  private RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setMessageConverters(getMessageConverters());
		return restTemplate;
	  }

	  private List<HttpMessageConverter<?>> getMessageConverters() {
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		messageConverters.add(new StringHttpMessageConverter());
		messageConverters.add(new FormHttpMessageConverter());
		messageConverters.add(new MappingJackson2HttpMessageConverter());
		return messageConverters;
	  }

	  /**
	   * Feel free to add any request header if needed
	   * @return
	   */
	  private HttpHeaders getHeaders() {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		requestHeaders.setAccept(Collections.singletonList(new MediaType("application", "json")));
		return requestHeaders;
	  }
	  
	  public T  jsonToObject(String content,Class clazz) {
		  ObjectMapper mapper = getMapper();
		//T result =   (T) mapper.convertValue(json, clazz);
		  T result =null;
		try {
			result = (T) mapper.readValue(content, clazz);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return result;
	  }
	  
	  private   ObjectMapper getMapper() {
		  ObjectMapper mapper = new ObjectMapper();
		  mapper.writerWithDefaultPrettyPrinter();
		  mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		  return mapper;
	  }

}
