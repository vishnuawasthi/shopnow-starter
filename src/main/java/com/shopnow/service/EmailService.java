package com.shopnow.service;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
/**
 * This is an email service which send email when ever required.
 * 
 * @author Vishnu Awasthi
 *
 */
public interface EmailService {

	/**
	 * This method is responsible to send the email
	 * 
	 * @param from
	 *            , The Email Id from which email(s) will be sent
	 * 
	 * @param subject
	 *            , Subject of the email
	 * 
	 * @param toList
	 *            , To Email Ids list
	 * 
	 * @param ccList
	 *            , CC Email Ids list
	 * 
	 * @param bccList
	 *            , BCC Email Ids list
	 * 
	 * @param emailBody
	 *            , Body of the email
	 * 
	 */
	public abstract void sendEmail(String from, String subject, Set<String> toList,
			Set<String> ccList, Set<String> bccList, String emailBody);

	@Service
	public class EmailServiceImpl implements EmailService {

		@Autowired
		private JavaMailSenderImpl mailSender;

		private String[] toArray;
		
		private String[] ccArray;
		
		private String[] bccArray;
		
		@Override
		public void sendEmail(String from, String subject, Set<String> toList, Set<String> ccList,
				Set<String> bccList, String emailBody) {
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

			simpleMailMessage.setFrom(from);

			simpleMailMessage.setSubject(subject);
			
			simpleMailMessage.setText(emailBody);

			if (!CollectionUtils.isEmpty(toList)) {
				
				Object[] objctList = new ArrayList<String>(toList).toArray();
				toArray = new String[new ArrayList<String>(toList).toArray().length];
				for (int index = 0; index < objctList.length; index++) {
					toArray[index] = (String) objctList[index];
				}
				simpleMailMessage.setTo(toArray);
			}
			if (!CollectionUtils.isEmpty(ccList)) {
				
				Object[] objctList = new ArrayList<String>(ccList).toArray();
				toArray = new String[new ArrayList<String>(ccList).toArray().length];
				for (int index = 0; index < objctList.length; index++) {
					ccArray[index] = (String) objctList[index];
				}
				simpleMailMessage.setCc(ccArray);
			}
			if (!CollectionUtils.isEmpty(bccList)) {
				
				Object[] objctList = new ArrayList<String>(bccList).toArray();
				toArray = new String[new ArrayList<String>(bccList).toArray().length];
				for (int index = 0; index < objctList.length; index++) {
					bccArray[index] = (String) objctList[index];
				}
				
				simpleMailMessage.setBcc(bccArray);
			}

			mailSender.send(simpleMailMessage);
		}

	}
}
