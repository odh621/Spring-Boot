package com.donghun.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.donghun.models.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {
	 List<Board> findByTitle(final String title);

}
