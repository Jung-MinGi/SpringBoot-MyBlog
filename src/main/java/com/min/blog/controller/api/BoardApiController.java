package com.min.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.min.blog.config.auth.PrincipalDetail;
import com.min.blog.dto.ResponseDto;
import com.min.blog.dto.board.BoardDto;
import com.min.blog.dto.board.UpdateDto;
import com.min.blog.service.BoardService;

@RestController
public class BoardApiController {
	@Autowired
	private BoardService boardService;
	
	@PostMapping("/api/board")
	public ResponseDto<Integer> 글등록(@AuthenticationPrincipal PrincipalDetail principal,@RequestBody BoardDto boardDto) {
		System.out.println(boardDto.toString());
		boardService.register(boardDto,principal.getUser());
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	@DeleteMapping("/api/board{id}")
	public ResponseDto<Integer> 글삭제(@PathVariable int id) {
		boardService.delete(id);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	@PutMapping("/api/board")
	public ResponseDto<Integer> 글수정(@RequestBody UpdateDto updateDto) {
		boardService.update(updateDto);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
}
