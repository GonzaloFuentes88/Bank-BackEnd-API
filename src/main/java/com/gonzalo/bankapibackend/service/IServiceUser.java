package com.gonzalo.bankapibackend.service;

import java.util.Optional;

import com.gonzalo.bankapibackend.entitys.User;

public interface IServiceUser {
	Optional<User> findOneByEmail(String email);
	Optional<User> findOneByUsername(String username);
	Optional<User> findOneByDni(String dni);

}
