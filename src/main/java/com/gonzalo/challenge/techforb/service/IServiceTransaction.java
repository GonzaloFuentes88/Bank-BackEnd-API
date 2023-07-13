package com.gonzalo.challenge.techforb.service;

import java.util.List;

import com.gonzalo.challenge.techforb.dto.ExtractAndDepositDTO;
import com.gonzalo.challenge.techforb.dto.TransferDTO;
import com.gonzalo.challenge.techforb.entitys.Transaction;

public interface IServiceTransaction {
	Transaction generatedTransfer(TransferDTO transfer) throws Exception;
	Transaction extractMoney(ExtractAndDepositDTO extractDTO) throws Exception;
	Transaction depositMoney(ExtractAndDepositDTO depositDTO) throws Exception;
	//List<Transaction> findAllByOriginAccount(Long originAccount);
}
