package com.gonzalo.challenge.techforb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gonzalo.challenge.techforb.entitys.Transaction;

public interface ITransactionDao extends JpaRepository<Transaction, Long>{
	 //List<User> findAllByName(String name, Pageable pageable);
	 //List<Transaction> findAllByOriginAccountId(Long originAccount);

}
