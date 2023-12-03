package com.gonzalo.bankapibackend.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.gonzalo.bankapibackend.dto.CardDTO;
import com.gonzalo.bankapibackend.dto.CardRemoveDTO;
import com.gonzalo.bankapibackend.dto.TransferDTO;
import com.gonzalo.bankapibackend.entitys.Account;
import com.gonzalo.bankapibackend.entitys.Card;
import com.gonzalo.bankapibackend.entitys.CreditCard;
import com.gonzalo.bankapibackend.entitys.DebitCard;
import com.gonzalo.bankapibackend.entitys.Transaction;
import com.gonzalo.bankapibackend.exceptions.IdOutOfRangeException;

public interface IServiceAccount {
	List<CreditCard> findAllCreditByAccount(Long id);
	List<DebitCard> findAllDebitByAccount(Long id) ;
	Optional<Account> findOne(Long id);
	void save(Account account);
	Card save(CardDTO cardDTO) throws Exception;
	void delete(CardRemoveDTO cardDTO) throws Exception;

}
