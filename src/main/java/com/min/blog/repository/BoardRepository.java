package com.min.blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.min.blog.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {// integer --user테이블의 pk의 타입을 말함

	Page<Board> findByCategoryContaining(String category, Pageable pageable);
}
