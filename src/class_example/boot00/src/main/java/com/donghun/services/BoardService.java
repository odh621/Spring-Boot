package com.donghun.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donghun.models.Board;
import com.donghun.repositories.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	BoardRepository boardRepository;
	
	public List<Board> list() {
		List<Board> boardList = boardRepository.findAll();
		return boardList;
	}
	
	public Board save() {
		Board board = new Board();
		board.setContent("Hello");
		board.setTitle("World");
		board.setWriter("user00");
		Board save = boardRepository.save(board);
		return save;
	}
	
	public Board patch(Long bno) {
		Board board = boardRepository.getOne(bno);
		if (null == board) {
			return null;
		}
		board.setTitle("patch " + String.valueOf(bno) + " Hello");
		Board patch = boardRepository.save(board);
		return patch;
	}
	
	public Board put(Long bno) {
		Board board = boardRepository.getOne(bno);
		if (null == board) {
			return null;
		}
		board.setTitle("put " + String.valueOf(bno) + " Hello");
		Board patch = boardRepository.save(board);
		return patch;
	}
	
	public String delete(Long bno) {
		Board board = boardRepository.getOne(bno);
		if (null == board) {
			return null;
		}
		boardRepository.delete(board);
		return "Delete Done!";		
	}

}
