package com.shopnow.service;

import java.util.List;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

public interface EmailService {
	public abstract void sendEmail(String from,List<String> toList, List<String> ccList , List<String> bccList);

	@Service
	public class EmailServiceImpl implements EmailService{

		@Override
		public void sendEmail(String from, List<String> toList, List<String> ccList,
				List<String> bccList) {
			SimpleMailMessage  simpleMailMessage  = new SimpleMailMessage ();
			simpleMailMessage.setFrom(from);
			
		}
		
	}

}
