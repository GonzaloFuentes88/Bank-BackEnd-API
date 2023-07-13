package com.gonzalo.challenge.techforb.service;

import java.util.List;
import java.util.Optional;

import com.gonzalo.challenge.techforb.dto.RegisterDTO;
import com.gonzalo.challenge.techforb.entitys.Client;

public interface IServiceClient {
	Optional<Client> findOne(Long dni);
	List<Client> findAll();
	void save(RegisterDTO registerDTO) throws Exception;
	
}
