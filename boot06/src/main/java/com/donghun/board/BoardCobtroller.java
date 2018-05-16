package com.donghun.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/boards/")
public class BoardCobtroller {
	
	@GetMapping("/list")
	public void list() {
		System.out.println("called list()");
	}

}
