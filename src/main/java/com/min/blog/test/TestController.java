package com.min.blog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@GetMapping("test/user")
	public String test() {
	return "<h1>연결성공</h1>";
}
}
