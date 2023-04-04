package com.min.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.min.blog.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board/updateForm/{id}")
	public String update(Model model, @PathVariable int id) {
		model.addAttribute("board",boardService.boardDetail(id));
		return "board/updateForm";
	}
	@GetMapping("/board/{id}")
	public String boardDetail(Model model,@PathVariable int id) {
		model.addAttribute("board",boardService.boardDetail(id));
		return "board/detail";
	}
	@GetMapping("/{category}")
	public String index(@PathVariable String category, Model model,@PageableDefault(size=3,sort = "id",direction = Direction.DESC)Pageable pageable) {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
		model.addAttribute("boards",boardService.findByCategoryContaining(category,pageable));
		return "index";
	}
	@GetMapping("/board/writeForm")
	public String write() {
		return "board/writeForm";
	}
	
}
