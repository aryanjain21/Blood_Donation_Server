package com.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController 
{
	@GetMapping
	public String testMe()
	{
		System.out.println("In test me testing the test");
		return "Hello world";
	}
}
