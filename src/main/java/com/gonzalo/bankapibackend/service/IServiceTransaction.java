package com.gonzalo.bankapibackend.service;

import java.util.List;

import com.gonzalo.bankapibackend.dto.ExtractAndDepositDTO;
import com.gonzalo.bankapibackend.dto.TransferDTO;
import com.gonzalo.bankapibackend.entitys.Transaction;

public interface IServiceTransaction {
	Transaction generatedTransfer(TransferDTO transfer) throws Exception;
	Transaction extractMoney(ExtractAndDepositDTO extractDTO) throws Exception;
	Transaction depositMoney(ExtractAndDepositDTO depositDTO) throws Exception;
	//List<Transaction> findAllByOriginAccount(Long originAccount);
}
