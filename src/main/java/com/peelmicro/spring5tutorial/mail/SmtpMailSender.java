package com.peelmicro.spring5tutorial.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

//import org.springframework.beans.factory.annotation.Qualifier;

//@Component
//@Component("smtp")
//@Qualifier("smtpMail")
//@Component
public class SmtpMailSender implements MailSender {

	private static Log log = LogFactory.getLog(SmtpMailSender.class);

	private JavaMailSender javaMailSender;

	public SmtpMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Override
	public void send(String to, String subject, String body) throws MessagingException {
		
//		log.info("Sending SMTP mail to "+to);
//		log.info("with subject "+subject);
//		log.info("with body "+body);
		log.info("Sending SMTP mail in thread " + Thread.currentThread().getName());

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;

		helper = new MimeMessageHelper(message, true); // true indicates
		// multipart message
		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText(body, true); // true indicates html

		// continue using helper for more functionalities
		// like adding attachments, etc.

		javaMailSender.send(message);
	}
	
}
