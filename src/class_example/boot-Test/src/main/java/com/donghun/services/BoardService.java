package com.donghun.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donghun.Repository.BoardRepository;
import com.donghun.models.Board;

@Service
public class BoardService {
	
	@Autowired
	BoardRepository repo;
	
	public List<Board> getFindAll() {
		return repo.findAll();
	}
	
	public List<Board> getFindTitle(String title) {
		return repo.findByTitle(title);
	}
	
	public List<Board> getFindWriterContaining(String writer) {
		return repo.findByWriterContaining(writer);
	}

}
