package com.min.blog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.min.blog.config.auth.PrincipalDetail;
import com.min.blog.dto.user.JoinDto;
import com.min.blog.dto.user.UpdateDto;
import com.min.blog.model.RoleType;
import com.min.blog.model.User;
import com.min.blog.repository.UserRepository;

@Service // 서비스 존재이유1.트랜잭션 관리2.서비스의 의미 때문
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Transactional
	public void register(JoinDto joinDto) {
		User user = new User();
		user.setUsername(joinDto.getUsername());
		user.setPassword(encoder.encode(joinDto.getPassword()));
		user.setEmail(joinDto.getEmail());
		user.setRole(RoleType.USER);
		System.out.println("email "+user.getEmail());
		userRepository.save(user);
	}
	@Transactional
	public void update(PrincipalDetail principal,UpdateDto updateDto) {
		User user = userRepository.findById(updateDto.getId())
				.orElseThrow(()->{
					 return new IllegalArgumentException("해당 유저가 없습니다");
				 });
		String passowrd = encoder.encode(updateDto.getPassword());
		user.setPassword(passowrd);
		user.setEmail(updateDto.getEmail());
		principal.setUser(user);
		//principal.getUser().setEmail(updateDto.getEmail());
		//principal.getUser().setPassword(passowrd);
	}
}
