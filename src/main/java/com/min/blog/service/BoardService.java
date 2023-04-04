package com.min.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.min.blog.dto.board.BoardDto;
import com.min.blog.dto.board.UpdateDto;
import com.min.blog.model.Board;
import com.min.blog.model.User;
import com.min.blog.repository.BoardRepository;

@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;

	@Transactional
	public void delete(int id) {
		boardRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Board boardDetail(int id) {
		return boardRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("해당 글이 없습니다");
		});
	}

	@Transactional(readOnly = true)
	public Page<Board> findByCategoryContaining(String category,Pageable pageable) {
		Page<Board> page = boardRepository.findByCategoryContaining(category,pageable);
		return page;
	}

	@Transactional
	public void register(BoardDto boardDto, User user) {
		Board board = new Board();
		board.setTitle(boardDto.getTitle());
		board.setContent(boardDto.getContent());
		board.setCategory(boardDto.getCategory());
		board.setUser(user);
		boardRepository.save(board);
	}

	@Transactional
	public void update(UpdateDto updateDto) {
		// 수정하기전에 해당 글을 가져와서 영속화 먼저 시킴 그럼 트랜잭션이 끝나면
		// (jpa가 알아서 entity변경을 감지해서 수정시킴)->더티체킹
		Board board = boardRepository.findById(updateDto.getId()).orElseThrow(() -> {
			return new IllegalArgumentException("해당 글이 없습니다");
		});
		board.setTitle(updateDto.getTitle());
		board.setContent(updateDto.getContent());
	}
}
