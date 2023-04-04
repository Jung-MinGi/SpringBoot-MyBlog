package com.min.blog.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class JoinDto {
	public String username;
	public String password;
	public String email;
}
