package com.peelmicro.spring5tutorial.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

//	@Value("${app.name}")
//	private String appName;
	
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World ";
    }
//    public String hello() {
//        return "Hello World "+appName;
//    }

}
