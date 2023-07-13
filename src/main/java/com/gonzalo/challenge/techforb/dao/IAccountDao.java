package com.gonzalo.challenge.techforb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gonzalo.challenge.techforb.entitys.Account;

public interface IAccountDao extends JpaRepository<Account, Long>{
	

}
