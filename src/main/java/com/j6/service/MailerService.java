package com.j6.service;

import javax.mail.MessagingException;

import com.j6.entity.MailInfo;


public interface MailerService {
	
	void send(MailInfo mail) throws MessagingException;
	
	void send(String to, String subject, String body) throws MessagingException;
	

	void queue(MailInfo mail);

	void queue(String to, String subject, String body);
}
