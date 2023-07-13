package com.gonzalo.challenge.techforb.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gonzalo.challenge.techforb.entitys.Client;

public interface IClientDao extends JpaRepository<Client, Long>{
	Optional<Client> findOneByDni(Long dni);

}
