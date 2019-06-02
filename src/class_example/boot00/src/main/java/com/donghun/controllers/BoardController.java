package com.donghun.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.donghun.models.Board;
import com.donghun.repositories.BoardRepository;
import com.donghun.services.BoardService;

@RestController
public class BoardController {

	@Autowired
	BoardService boardService;

	@GetMapping("/")
	public List<Board> list() {
		return boardService.list();
	}
	
	@PostMapping("/")
	public Board insert() {
		return boardService.save();
		
	}
	
	@PatchMapping("/")
	public Board patch(@PathVariable(value="ID") Long bno) {
		return boardService.patch(bno);
	}
	
	@PutMapping("/")
	public Board put(@PathVariable(value="ID") Long bno) {
		return boardService.put(bno);
	}
	
	@DeleteMapping("/")
	public String delete(@PathVariable(value="ID") Long bno) {
		return boardService.delete(bno);
	}
	
}