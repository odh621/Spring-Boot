package com.donghun.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donghun.services.*;
import com.donghun.services.*;
import com.donghun.modles.*;

@RestController
public class MemoController {
	
	@Autowired
	MemoService memoService;
	
	@GetMapping("/")
	public List<Memo> list() {
		return memoService.list();
	}
	
	@PostMapping("/")
	public Memo insert() {
		return memoService.save();
	}
	
	@PatchMapping("/csss")
	public Memo patch() {
		return memoService.patch(1); 
	}
	
	@GetMapping("/content")
	public List<Memo> listGetContent() {
		return memoService.getFindContent("내용..177");
	}
	
	@GetMapping("/user")
	public List<Memo> listGetUser() {
		return memoService.getFindUserContaining("01");	
	}
	
	

}
