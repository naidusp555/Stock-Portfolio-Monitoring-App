package com.bridgelabz.stockportfoliomonitoringapp.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.bridgelabz.stockportfoliomonitoringapp.service.MailService;

@Service
public class MailServiceImpl implements MailService {
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendSimpleEmail(String toEmail, String subject, String body){
		SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("naidusp555@gmail.com");  // must match spring.mail.username
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);

        javaMailSender.send(message);
        System.out.println("Email sent successfully to " + toEmail);
	}
}
