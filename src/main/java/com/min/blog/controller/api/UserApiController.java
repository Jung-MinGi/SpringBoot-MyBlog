package com.min.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.min.blog.config.auth.PrincipalDetail;
import com.min.blog.dto.ResponseDto;
import com.min.blog.dto.user.JoinDto;
import com.min.blog.dto.user.UpdateDto;
import com.min.blog.service.UserService;

//ajax사용하는이유--1.요청에대한 응답을 html파일이 아닌 data(json)를 받기위해2.비동기 통신 
//클라이언트에 대한 요청으로 html파일을 넘겨주지말고 데이터를 넘겨주는형식으로 서버를 구성해야 앱에서도 적용될 수 있음  (확장성이 좋아짐)
@RestController
public class UserApiController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> register(@RequestBody JoinDto joinDto) {
		System.out.println(joinDto.toString());
		userService.register(joinDto);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	@PutMapping("/api/user")
	public ResponseDto<Integer> update(@AuthenticationPrincipal PrincipalDetail principal
			,@RequestBody UpdateDto updateDto) {
		userService.update(principal,updateDto);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
}
