package com.yourmart.productmanagementportal.service;

import javax.mail.MessagingException;

public interface MailSendingService {

	void run();

	void sendMail() throws MessagingException;

}