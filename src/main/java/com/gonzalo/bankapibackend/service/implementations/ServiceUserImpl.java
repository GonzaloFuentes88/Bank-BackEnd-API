package com.gonzalo.bankapibackend.service.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gonzalo.bankapibackend.dao.IUserDao;
import com.gonzalo.bankapibackend.entitys.Client;
import com.gonzalo.bankapibackend.entitys.User;
import com.gonzalo.bankapibackend.service.IServiceClient;
import com.gonzalo.bankapibackend.service.IServiceUser;

@Service
public class ServiceUserImpl implements IServiceUser{
	
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IServiceClient serviceClient;
	
	@Override
	public Optional<User> findOneByEmail(String email) {
		return userDao.findOneByEmail(email);
	}
	
	@Override
	public Optional<User> findOneByUsername(String username) {
		return userDao.findOneByUsername(username);
	}
	
	@Override
	public Optional<User> findOneByDni(String dni) {
		Client client = serviceClient.findOne(Long.parseLong(dni)).orElse(null);
		Optional<User> opt = Optional.of(client != null ? client.getUser() : null);
		
		return opt;
	}

}
