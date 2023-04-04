package com.min.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.min.blog.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {// integer --user테이블의 pk의 타입을 말함
	Optional<User> findByUsername(String username);
}
