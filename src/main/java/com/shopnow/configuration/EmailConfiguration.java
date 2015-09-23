package com.shopnow.configuration;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class EmailConfiguration {

	@Bean
	public JavaMailSenderImpl getJavaMailSenderImpl() {
		System.out.println(" getJavaMailSenderImpl() - start");
		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		javaMailSenderImpl.setPort(25);
		javaMailSenderImpl.setHost("mx.valuelabs.net");
		javaMailSenderImpl.setUsername("vishnu.awasthi");
		javaMailSenderImpl.setPassword("vp95893639");
		javaMailSenderImpl.setDefaultEncoding("UTF-8");
		System.out.println(" getJavaMailSenderImpl() - end");
		return javaMailSenderImpl;
	}
	/*@Bean
	public SimpleMailMessage simpleMailMessage() {
		System.out.println("simpleMailMessage() - start");
		SimpleMailMessage templateMessage = new SimpleMailMessage();
		templateMessage.setFrom("vishnu.awasthi@valuelabs.net");
		//templateMessage.setTo("vishnu.awasthi@valuelabs.com");
		System.out.println("simpleMailMessage() - end");
		return templateMessage;
	}*/

	private Properties getJavaGmailMailProperties() {
		System.out.println("getJavaMailProperties() - start");
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.user", "vishnuawasthi121@gmail.com");
		props.put("mail.smtp.password", "vpa95893639");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		System.out.println("getJavaMailProperties() - end");
		return props;
	}
}
