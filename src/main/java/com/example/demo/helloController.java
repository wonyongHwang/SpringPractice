package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {

	@Value("${hello.message}")
	private String message;
	
	@GetMapping("hello")
	public String getHello() {
		return "hello " + message; 
	}
}
