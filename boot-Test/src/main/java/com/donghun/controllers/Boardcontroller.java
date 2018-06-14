package com.donghun.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donghun.models.Board;
import com.donghun.services.BoardService;

@Controller // view를 보낼 때, 컨트롤러에서 뷰 html에서 데이터만 보낸다는 뜻, html을 안 보내고 텍스트로 보낼수 있다.
            // restcontroller 안 써주면 얘가 html 형식으로 보내야 하느데, 안바꿔준다
public class Boardcontroller {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/")
	List<Board> listGetAll() {
		return boardService.getFindAll();
	}
	
	@GetMapping("/title")
	List<Board> listGetTitle() {
		return boardService.getFindTitle("제목...177");
	}
	
	@GetMapping("/writer")
	List<Board> listGetWriter() {
		return boardService.getFindWriterContaining("05");
	}

}
