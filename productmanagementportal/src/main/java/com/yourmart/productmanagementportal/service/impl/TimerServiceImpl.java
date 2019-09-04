package com.yourmart.productmanagementportal.service.impl;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.stereotype.Service;

import com.yourmart.productmanagementportal.service.TimerService;

@Service
public class TimerServiceImpl implements TimerService{

	@Override
	public void timer() {
		Runnable runnableLambdaToReadDataFile = () -> {
			Timer timer = new Timer();
			TimerTask timerTask = new MailSendingServiceImpl();
			try {
				long delay = 1000L;
			    long period = 1000L * 60L * 60L * 24L;
				timer.scheduleAtFixedRate(timerTask, delay, period);
			} catch (Exception ex) {
				System.out.println(ex);
			}
		};
		Thread thread1 = new Thread(runnableLambdaToReadDataFile);
		thread1.start();
	}
	
}
