package com.yourmart.productmanagementportal.service.impl;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.TimerTask;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.yourmart.productmanagementportal.enums.EnumConstants.ProductStatusEnums;
import com.yourmart.productmanagementportal.model.Product;
import com.yourmart.productmanagementportal.repository.ProductRepository;
import com.yourmart.productmanagementportal.service.MailSendingService;

@Service
public class MailSendingServiceImpl extends TimerTask implements MailSendingService{

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private JavaMailSender javaMailSender;
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void run() {
		LOGGER.info("msg");
		ProductStatusEnums status = ProductStatusEnums.NEW;
		ProductStatusEnums status1 = ProductStatusEnums.REVIEW;
		List<Product> list = productRepository.find(status, status1);
		LOGGER.info("size=" + list.size());
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter("D:\\\\product-list.txt");
			PrintWriter writer = new PrintWriter(fileWriter);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			if (list.size() > 0) {
				for (Product p : list) {
					LOGGER.info("code:::" + p.getCode());
					LocalDate creationDate = LocalDate.parse(p.getCreationDate(), formatter);
					LocalDate currentDate = LocalDate.now();
					if (ChronoUnit.DAYS.between(creationDate, currentDate) == 0) {
						writer.printf("Product id %s and status is %s.", String.valueOf(p.getCode()),
								p.getStatus().toString());
					}
				}
			} else {
				writer.printf("No products left");
			}
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sendMail() throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        helper.setTo("15ucs061@lnmiit.ac.in");
        helper.setText("How are you?");
        helper.setSubject("Hi");
        ClassPathResource file = new ClassPathResource("product-list.txt");
        helper.addAttachment("product-list.txt",file);
        javaMailSender.send(message);
	}
	
}
