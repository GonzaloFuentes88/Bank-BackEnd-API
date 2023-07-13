package com.gonzalo.challenge.techforb.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gonzalo.challenge.techforb.entitys.User;

public interface IUserDao extends JpaRepository<User, Long>{
	Optional<User> findOneByEmail(String email);
	Optional<User> findOneByUsername(String username);

}
