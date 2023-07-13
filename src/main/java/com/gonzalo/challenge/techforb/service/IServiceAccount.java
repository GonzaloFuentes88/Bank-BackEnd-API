package com.gonzalo.challenge.techforb.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.gonzalo.challenge.techforb.dto.CardDTO;
import com.gonzalo.challenge.techforb.dto.CardRemoveDTO;
import com.gonzalo.challenge.techforb.dto.TransferDTO;
import com.gonzalo.challenge.techforb.entitys.Account;
import com.gonzalo.challenge.techforb.entitys.Card;
import com.gonzalo.challenge.techforb.entitys.CreditCard;
import com.gonzalo.challenge.techforb.entitys.DebitCard;
import com.gonzalo.challenge.techforb.entitys.Transaction;
import com.gonzalo.challenge.techforb.exceptions.IdOutOfRangeException;

public interface IServiceAccount {
	List<CreditCard> findAllCreditByAccount(Long id);
	List<DebitCard> findAllDebitByAccount(Long id) ;
	Optional<Account> findOne(Long id);
	void save(Account account);
	Card save(CardDTO cardDTO) throws Exception;
	void delete(CardRemoveDTO cardDTO) throws Exception;

}
