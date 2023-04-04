package com.min.blog.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.min.blog.model.User;
import com.min.blog.repository.UserRepository;

@Service
public class PrincipalDetailService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override // 들어온 username이 db에 존재하는지 확인해주는 메서드
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User principal = userRepository.findByUsername(username).orElseThrow(() -> {
			return new UsernameNotFoundException("해당사용자는 없습니다");
		});
		return new PrincipalDetail(principal);
	}

}
