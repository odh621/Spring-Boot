package com.donghun.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donghun.Repository.BoardRepository;
import com.donghun.models.Board;
import com.donghun.services.BoardService;

@RestController
public class Boardcontroller {
	
	@Autowired
	//BoardRepository boardRepository;
	BoardService boardService;
	
	@PatchMapping("/patch") 
	Board patchBoard() {
		return boardService.patchBoard(1L);
	}
	

	
	@GetMapping("/")
	List<Board> listGetAll() {
		return boardService.getFindAll();
	}
	
	@GetMapping("/title")
	List<Board> listGetTitle() {
		return boardService.getFindTitle("제목..177");
	}
	
	@GetMapping("/content")
	List<Board> listGetContent() {
		return boardService.getFindContent("내용..177");
	}
	
	@GetMapping("/writer") 
	List<Board> listGetWriter() {
		return boardService.getFindWirterContaining("05");
	}
	
	
	/*public List<Board> getListBoardByTitle() {
		return boardRepository.findByTitle("제목..117");
	}*/
	

}
