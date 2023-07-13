package com.gonzalo.challenge.techforb.service.implementations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gonzalo.challenge.techforb.dao.ITransactionDao;
import com.gonzalo.challenge.techforb.dto.ExtractAndDepositDTO;
import com.gonzalo.challenge.techforb.dto.TransferDTO;
import com.gonzalo.challenge.techforb.entitys.Account;
import com.gonzalo.challenge.techforb.entitys.Transaction;
import com.gonzalo.challenge.techforb.exceptions.IdOutOfRangeException;
import com.gonzalo.challenge.techforb.exceptions.InsufficientSalaryException;
import com.gonzalo.challenge.techforb.service.IServiceAccount;
import com.gonzalo.challenge.techforb.service.IServiceTransaction;
import com.gonzalo.challenge.techforb.utils.TypeTransaction;

@Service
public class ServiceTransactionImpl implements IServiceTransaction{
	
	@Autowired
	private ITransactionDao transactionDao;
	
	@Autowired
	private IServiceAccount serviceAccount;
	
	
	@Override
	@Transactional
	public Transaction depositMoney(ExtractAndDepositDTO depositDTO) throws Exception {
		Transaction transaction = new Transaction();
		Account originAccount = null;
		if(depositDTO.getAccount() > 0) {
			originAccount = serviceAccount.findOne(depositDTO.getAccount()).orElseThrow(() -> new Exception("nonexistent account"));
			if(depositDTO.getMoney() <= originAccount.getBalance()) {
				originAccount.setBalance(originAccount.getBalance() + depositDTO.getMoney());
				serviceAccount.save(originAccount);
				
				transaction.setAmount(depositDTO.getMoney());
				transaction.setDate(new Date());
				transaction.setTransactionType(TypeTransaction.DEPOSIT.getValue());
				transaction.setDescription(TypeTransaction.DEPOSIT.getType() + " - "+ depositDTO.getMoney());
				transaction.setOriginAccount(originAccount);

				transactionDao.save(transaction);
			}
		}
				
		return transaction;
	}
	
	
	@Override
	@Transactional
	public Transaction extractMoney(ExtractAndDepositDTO extractDTO) throws Exception {
		Transaction transaction = new Transaction();
		Account originAccount = null;
		if(extractDTO.getAccount() > 0) {
			originAccount = serviceAccount.findOne(extractDTO.getAccount()).orElseThrow(() -> new Exception("nonexistent account"));
			Double value = originAccount.getBalance() - extractDTO.getMoney();
			if(extractDTO.getMoney() < value) {
				originAccount.setBalance(value);
				serviceAccount.save(originAccount);
				
				transaction.setAmount(extractDTO.getMoney());
				transaction.setDate(new Date());
				transaction.setTransactionType(TypeTransaction.EXTRACT.getValue());
				transaction.setDescription(TypeTransaction.EXTRACT.getType() + " - "+ extractDTO.getMoney());
				transaction.setOriginAccount(originAccount);

				transactionDao.save(transaction);

			}
			else {
				throw new InsufficientSalaryException();
			}
			
		}
				
		return transaction;
	}
	
	@Override
	@Transactional
	public Transaction generatedTransfer(TransferDTO transfer) throws Exception {
		Transaction transaction = new Transaction();
		Account accountOrigin = null;
		Account accountDestination = null;
		
		if(transfer != null ) {
			if(transfer.getNumberAccountOrigin() > 0) {
				accountOrigin = serviceAccount.findOne(transfer.getNumberAccountOrigin()).orElseThrow(()-> new Exception("nonexistent account"));
				Double value = accountOrigin.getBalance() - transfer.getAmount();
				if(transfer.getAmount() < value) {
					accountOrigin.setBalance(value);	
				}
				else {
					throw new InsufficientSalaryException();
				}
				serviceAccount.save(accountOrigin);
			}
			if(transfer.getNumberAccoutDestination() > 0) {
				accountDestination = serviceAccount.findOne(transfer.getNumberAccoutDestination()).orElseThrow(()-> new Exception("nonexistent account"));
				accountDestination.setBalance(accountDestination.getBalance() + transfer.getAmount());
				serviceAccount.save(accountDestination);
			}
			transaction.setDate(new Date());
			transaction.setDescription(transfer.getDescription());
			transaction.setAmount(transfer.getAmount());
			transaction.setTransactionType(TypeTransaction.TRANSFER.getValue());
			transaction.setOriginAccount(accountOrigin);
			transaction.setDestinationAccuount(accountDestination);
			
			transactionDao.save(transaction);
		}
		
		return transaction;
	}
//	
//	@Override
//	public List<Transaction> findAllByOriginAccount(Long originAccount) {
//		List<Transaction> transactions = new ArrayList<>();
//		if(originAccount > 0) {
//			transactions = serviceAccount.findOne(originAccount).orElse(null).getTransactionsMade();
//
//		}else {
//			throw new IdOutOfRangeException();
//		}
//		return transactions;
//	}
	

}
