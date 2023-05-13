package com.bridgelabz.user.Utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
	
	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	SimpleMailMessage mailMessage;
	
	@Value("${spring.mail.username}")
	String sender;
	
	public void sendMail(String toEmail,String subject,String messageBody) {
		mailMessage.setFrom(sender);
		mailMessage.setTo(toEmail);
		mailMessage.setText(messageBody);
		mailMessage.setSubject(subject);
		mailSender.send(mailMessage);
		
	}

}
