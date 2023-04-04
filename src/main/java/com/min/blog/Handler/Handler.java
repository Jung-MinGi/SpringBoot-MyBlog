package com.min.blog.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.min.blog.dto.ResponseDto;

@RestController
public class Handler {
	@ExceptionHandler(Exception.class)
public ResponseDto<String> exceptionHandler(Exception e) {
	return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage());
}
}
