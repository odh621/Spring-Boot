package com.donghun;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hellocontroller {
	
	@GetMapping("/hello")
	String helloworld( ) {
		return "Hello World";
	}
	

}
