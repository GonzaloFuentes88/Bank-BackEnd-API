package com.gonzalo.bankapibackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gonzalo.bankapibackend.entitys.Account;

public interface IAccountDao extends JpaRepository<Account, Long>{
	

}
