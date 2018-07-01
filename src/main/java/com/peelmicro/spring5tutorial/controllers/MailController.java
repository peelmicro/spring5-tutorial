package com.peelmicro.spring5tutorial.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peelmicro.spring5tutorial.mail.MailSender;

@RestController
public class MailController {
	
	//@Autowired
	private MailSender mailSender;
	
//	public MailController(MailSender mailSender) {
//		this.mailSender = mailSender;
//	}
	
//	public MailController(MailSender smtpMailSender) {
//		this.mailSender = smtpMailSender;
//	}
	
//	public MailController(MailSender smtp) {
//		this.mailSender = smtp;
//	}	

//	public MailController(@Qualifier("smtpMail") MailSender smtp) {
//		this.mailSender = smtp;
//	}	
	
	public MailController(@Qualifier("smtpMailSender") MailSender smtp) {
		this.mailSender = smtp;
	}		
	@RequestMapping("/mail")
    public String mail() {
    	
    	mailSender.send("mail@example.com", "A test mail", "Body of the test mail");
    	
        return "Mail Sent!";
    }
}
