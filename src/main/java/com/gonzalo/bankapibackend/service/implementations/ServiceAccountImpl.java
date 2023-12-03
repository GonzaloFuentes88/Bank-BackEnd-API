package com.gonzalo.bankapibackend.service.implementations;

import java.util.ArrayList; 
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gonzalo.bankapibackend.dao.IAccountDao;
import com.gonzalo.bankapibackend.dao.ICreditCardDao;
import com.gonzalo.bankapibackend.dao.IDebitCardDao;
import com.gonzalo.bankapibackend.dto.CardDTO;
import com.gonzalo.bankapibackend.dto.CardRemoveDTO;
import com.gonzalo.bankapibackend.dto.TransferDTO;
import com.gonzalo.bankapibackend.entitys.Account;
import com.gonzalo.bankapibackend.entitys.Card;
import com.gonzalo.bankapibackend.entitys.CreditCard;
import com.gonzalo.bankapibackend.entitys.DebitCard;
import com.gonzalo.bankapibackend.entitys.Transaction;
import com.gonzalo.bankapibackend.exceptions.IdOutOfRangeException;
import com.gonzalo.bankapibackend.service.IServiceAccount;

@Service
public class ServiceAccountImpl implements IServiceAccount{

	
	@Autowired
	private IAccountDao accountDao;
	
	@Autowired
	private ICreditCardDao creditDao;
	
	@Autowired IDebitCardDao debitDao;
	
	@Override
	@Transactional
	public Card save(CardDTO cardDTO) throws Exception {
		Account account = this.findOne(cardDTO.getAccount()).orElseThrow(()->new Exception("nonexistent account"));
		Card genericCard;
		if(cardDTO.getIsCredit()) {
			CreditCard card = new CreditCard();
			card.setExpirationDate(cardDTO.getExpirationDate());
			card.setCvv(cardDTO.getCvv());
			card.setNumber(cardDTO.getNumber());
			account.addCreditCard(card);
			genericCard=card;
			
		}else {
			DebitCard card = new DebitCard();
			card.setExpirationDate(cardDTO.getExpirationDate());
			card.setCvv(cardDTO.getCvv());
			card.setNumber(cardDTO.getNumber());
			
			account.addDebitCard(card);
			genericCard=card;
		}
		accountDao.save(account);
		return genericCard;
	}
	
	@Override
	@Transactional
	public void save(Account account) {
		accountDao.save(account);
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Account> findOne(Long id) {
		return accountDao.findById(id);
	}
	
	
	
	@Override
	@Transactional(readOnly = true)
	public List<CreditCard> findAllCreditByAccount(Long id) {
		Account account = new Account();
		List<CreditCard> lCreditCards = null;
		if(id > 0) {
			account = accountDao.findById(id).orElse(null);
			lCreditCards = (account != null && account.getCreditCards() != null) 
					? lCreditCards = account.getCreditCards() 
					: null;
		}else {
			throw new IdOutOfRangeException();
		}
		 
		return lCreditCards;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<DebitCard> findAllDebitByAccount(Long id){
		Account account = null;
		if(id > 0) {
			account = accountDao.findById(id).orElse(null);
		}else {
			throw new IdOutOfRangeException();
		}
		return (account !=null &&account.getDebitCards() != null) ? account.getDebitCards() : null;
	}
	
	@Override
	@Transactional
	public void delete(CardRemoveDTO cardDTO) throws Exception {
		if(cardDTO.getNumberCard() > 0) {
				Account account = this.findOne(cardDTO.getAccount()).orElseThrow(()->new Exception("nonexistent account"));
				if(cardDTO.getIsCredit()) {
					creditDao.deleteById(cardDTO.getNumberCard());
				}else {
					debitDao.deleteById(cardDTO.getNumberCard());
				}
		}else {
			throw new IdOutOfRangeException(); 
		}
		
	}
	
}
