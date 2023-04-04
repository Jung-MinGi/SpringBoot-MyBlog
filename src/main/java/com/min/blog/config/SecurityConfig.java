package com.min.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.min.blog.config.auth.PrincipalDetailService;


//빈등록이란 스프링 컨테이너(ioc)에서 객체를 관리할 수 있게 하는것
@Configuration
public class SecurityConfig {
	
	@Bean
	public BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}
	@Autowired
	private PrincipalDetailService principalDetailService;
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(principalDetailService).passwordEncoder(encode());
	}

	@Bean
	SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http
  		.csrf().disable()
  		.authorizeRequests()
    	.antMatchers("/auth/**","/","/js/**","/css/**","/image/**")
    	.permitAll()
    	.anyRequest()
    	.authenticated()
    	.and()
    	.formLogin()
    	.loginPage("/auth/loginForm")
    	.loginProcessingUrl("/auth/loginProc")
    	.defaultSuccessUrl("/");//이 주소로 요청이 오면 스프링 시큐리티가 로그인 요청 가로챔
  return http.build();
 }
}