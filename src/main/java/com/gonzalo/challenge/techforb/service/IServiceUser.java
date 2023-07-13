package com.gonzalo.challenge.techforb.service;

import java.util.Optional;

import com.gonzalo.challenge.techforb.entitys.User;

public interface IServiceUser {
	Optional<User> findOneByEmail(String email);
	Optional<User> findOneByUsername(String username);
	Optional<User> findOneByDni(String dni);

}
