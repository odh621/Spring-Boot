package com.donghun.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donghun.Repository.BoardRepository;
import com.donghun.models.Board;

@Service
public class BoardService {
	
	@Autowired
	BoardRepository boardRepository; // 레포지토리에서 데이터를 가져오는 방법
	
	public Board patchBoard(Long id) {
		// 1. findByID
		Optional<Board> board = boardRepository.findById(id);
		
		// 2. Patch
		if(board.isPresent()) {
			Board patchBoard = board.get();
			patchBoard.setTitle("(patch" + patchBoard.getTitle());
			// 3. 저장
			return boardRepository.save(patchBoard);
			// return을 빼면 포스트맨에서 패치 URL을 간다. 
		} // 보드가 있다면 if에 들어오고
		
		return null; // 없다면 null을 반환한다.
	}
	
	public List<Board> getFindAll() {
		return boardRepository.findAll();
	}
	
	public List<Board> getFindTitle(String title) {
		return boardRepository.findByTitle(title);
	}
	
	public List<Board> getFindContent(String content) {
		return boardRepository.findByContent(content);
	}

	public List<Board> getFindWirterContaining(String writer) {
		return boardRepository.findByWriterContaining(writer);
	}

	
}
