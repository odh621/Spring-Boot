package com.donghun.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donghun.models.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
