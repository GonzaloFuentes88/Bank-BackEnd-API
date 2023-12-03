package com.gonzalo.bankapibackend.service;

import java.util.List;
import java.util.Optional;

import com.gonzalo.bankapibackend.dto.RegisterDTO;
import com.gonzalo.bankapibackend.entitys.Client;

public interface IServiceClient {
	Optional<Client> findOne(Long dni);
	List<Client> findAll();
	void save(RegisterDTO registerDTO) throws Exception;
	
}
