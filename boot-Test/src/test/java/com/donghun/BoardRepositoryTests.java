/*
package com.donghun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.donghun.Repository.*;
import com.donghun.models.Board;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTests {
	
	@Autowired
	private BoardRepository boardRepository;
	
	// Create
	@Test
	public void testInert() {
		Board board = new Board();
		board.setTitle("게시물 제목");
		board.setContent("게시물 내용 넣기...");
		board.setWriter("user00");
		
		boardRepository.save(board);
	}
	
	//Read
	@Test
	public void testRead() {
		boardRepository.findById(1L).ifPresent((board) -> {System.out.println(board);});
	}
	
	//Update
	@Test
	public void testUpdate() {
		Board board = boardRepository.findById(1L).get();
		board.setTitle("수정한다");
		boardRepository.save(board);	
	}

}
*/