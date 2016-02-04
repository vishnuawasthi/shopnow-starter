package com.shopnow.rest.controller;

import java.util.UUID;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shopnow.dto.LoginRequestDTO;
import com.shopnow.dto.LoginResponseDTO;


@RestController
//@Controller
public class LoginRestController {

	@RequestMapping(value="/login/test",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO  loginRequestDTO){
		LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
		if("Admin".equals(loginRequestDTO.getUsername())&& "password".equals(loginRequestDTO.getPassword())) {
			loginResponseDTO.setSessionId(UUID.randomUUID().toString());
			loginResponseDTO.setUsername(loginRequestDTO.getUsername());
			return new ResponseEntity<LoginResponseDTO>(loginResponseDTO,HttpStatus.OK);
		}
		return new ResponseEntity<LoginResponseDTO>(HttpStatus.BAD_REQUEST);
	}
	
	
	@RequestMapping(value="/loginxml/test",method=RequestMethod.GET,produces=MediaType.APPLICATION_XML_VALUE)
	public HttpEntity<LoginResponseDTO> loginXml(){
		LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
		//if("Admin".equals(loginRequestDTO.getUsername())&& "password".equals(loginRequestDTO.getPassword())) {
			loginResponseDTO.setSessionId(UUID.randomUUID().toString());
			loginResponseDTO.setUsername("Vishnu");
			return new ResponseEntity<LoginResponseDTO>(loginResponseDTO,HttpStatus.OK);
		//}
		//return new ResponseEntity<LoginResponseDTO>(HttpStatus.BAD_REQUEST);
		
	}
	
	
	
}
