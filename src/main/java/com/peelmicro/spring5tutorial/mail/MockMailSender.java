package com.peelmicro.spring5tutorial.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

//@Component
//@Primary
public class MockMailSender implements MailSender {

	private static Log log = LogFactory.getLog(MockMailSender.class);
	
	@Override
	public void send(String to, String subject, String body) {
		
		log.info("Sending MOCK mail to "+to);
		log.info("with subject "+subject);
		log.info("with body "+body);
	}
	
	

}
