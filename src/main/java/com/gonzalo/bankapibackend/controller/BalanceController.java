package com.gonzalo.bankapibackend.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gonzalo.bankapibackend.entitys.Account;
import com.gonzalo.bankapibackend.entitys.Transaction;
import com.gonzalo.bankapibackend.exceptions.IdOutOfRangeException;
import com.gonzalo.bankapibackend.service.IServiceAccount;
import com.gonzalo.bankapibackend.service.IServiceTransaction;
import com.gonzalo.bankapibackend.utils.TypeTransaction;

@RestController
@RequestMapping("/balance")
public class BalanceController {
	
	@Autowired
	private IServiceAccount serviceAccount;
	/*
	@GetMapping("/mounth/{numberAccount}")
	public ResponseEntity<Double> balanceMounth(@PathVariable Long numberAccount){
		List<Transaction> listReceived;
		List<Transaction> listMade;
		Account account = new Account();
		LocalDate currentDate = LocalDate.now();
		Date firstDay = Date.from((currentDate.withDayOfMonth(1)).atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date lastDay = Date.from((currentDate.withDayOfMonth(currentDate.lengthOfMonth())).atStartOfDay(ZoneId.systemDefault()).toInstant());
		Double depositTotal;
		Double extractTotal;
		Double transferTotal;
		Double resultado; 
		try{
			account = serviceAccount.findOne(numberAccount).orElseThrow(()->new Exception("nonexist account"));
			listReceived = account.getTransactionsReceived();
			listMade = account.getTransactionsMade();
			//a.getDate().before(firstDay) && a.getDate().after(lastDay)
			income= listReceived
					.stream()
					.filter(a -> a.getDate().after(firstDay) && a.getDate().before(lastDay))
					.mapToDouble(Transaction::getAmount).sum();
			expenses = listMade.stream().filter(a->
			(a.getTransactionType() == TypeTransaction.EXTRACT.getValue())
			&&
			(a.getTransactionType() == TypeTransaction.TRANSFER.getValue())
			&& a.getDate().before(firstDay) && a.getDate().after(lastDay)
					)
					.map(Transaction::getAmount).reduce((t, u) -> t+u).orElse(0D);
			
			return ResponseEntity.ok(income - expenses);
			}catch(IdOutOfRangeException idOutOfRangeException) {
				return new ResponseEntity(idOutOfRangeException.getMessage(),HttpStatus.NOT_ACCEPTABLE);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return new ResponseEntity(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
			}
		}
		*/
}

