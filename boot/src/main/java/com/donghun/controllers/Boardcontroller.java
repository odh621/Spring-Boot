package com.donghun.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donghun.Repository.BoardRepository;
import com.donghun.models.Board;

@RestController
public class Boardcontroller {
	
	@Autowired
	BoardRepository boardRepository;
	
	@GetMapping("/")
	public List<Board> getListBoardByTitle() {
		return boardRepository.findByTitle("제목..117");
	}
	

}
