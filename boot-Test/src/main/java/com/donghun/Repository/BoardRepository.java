package com.donghun.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.donghun.models.Board;

@Repository
public interface BoardRepository extends CrudRepository<Board, Long> {
	
	List<Board> findByTitle(String title);
	List<Board> findAll();
	List<Board> findByWriterContaining(String writer);

}
