package com.donghun.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.donghun.models.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {
	 //List<Board> findByTitle(final String title);
	 List<Board> findAll();
	 List<Board> findByTitle(String title);
	 List<Board> findByContent(String content);
	 List<Board> findByWriterContaining(String writer); // Like 구문
}
