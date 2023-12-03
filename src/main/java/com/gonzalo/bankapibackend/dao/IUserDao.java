package com.gonzalo.bankapibackend.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gonzalo.bankapibackend.entitys.User;

public interface IUserDao extends JpaRepository<User, Long>{
	Optional<User> findOneByEmail(String email);
	Optional<User> findOneByUsername(String username);

}
