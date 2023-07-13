package com.gonzalo.challenge.techforb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gonzalo.challenge.techforb.dto.ExtractAndDepositDTO;
import com.gonzalo.challenge.techforb.dto.TransferDTO;
import com.gonzalo.challenge.techforb.entitys.Transaction;
import com.gonzalo.challenge.techforb.exceptions.InsufficientSalaryException;
import com.gonzalo.challenge.techforb.service.IServiceTransaction;


@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	
	@Autowired
	private IServiceTransaction serviceTransaction;
	
	@PostMapping("/carryOut")
	public ResponseEntity<Transaction> generatedTransfer(@Valid @RequestBody TransferDTO transfer, BindingResult result){
		Transaction transaction = null;
		String mesaggeError ="";
		if(!result.hasErrors()) {
			try {
				transaction = serviceTransaction.generatedTransfer(transfer);
				return ResponseEntity.ok(transaction);
			}catch(InsufficientSalaryException insufficient) {
				return new ResponseEntity(insufficient.getMessage(),HttpStatus.NOT_ACCEPTABLE);
			}catch (Exception e) {
				// TODO Auto-generated catch block
				return new ResponseEntity(e.getMessage(),HttpStatus.NO_CONTENT);
			}
		}
		for(int i = 0 ;i < result.getErrorCount();i++) {
			FieldError error = result.getFieldErrors().get(i);
			mesaggeError += error.getField()+" - "+error.getDefaultMessage() + "\n";	
		}
		return new ResponseEntity(mesaggeError,HttpStatus.NOT_ACCEPTABLE);
	}
	
	@PostMapping("/extract")
	public ResponseEntity<Transaction> extractMoney(@Valid @RequestBody ExtractAndDepositDTO extractDTO, BindingResult result){
		Transaction transaction = null;
		String mesaggeError = "";
		if(!result.hasErrors()) {
			try {
				transaction = serviceTransaction.extractMoney(extractDTO);
				return ResponseEntity.ok(transaction);
			}catch(InsufficientSalaryException insufficient) {
				return new ResponseEntity(insufficient.getMessage(),HttpStatus.NOT_ACCEPTABLE);
			}catch(Exception e) {
				return new ResponseEntity(e.getMessage(),HttpStatus.NO_CONTENT);
			}
		}
		for(int i = 0 ;i < result.getErrorCount();i++) {
			FieldError error = result.getFieldErrors().get(i);
			mesaggeError += error.getField()+" - "+error.getDefaultMessage() + "\n";	
		}
		return new ResponseEntity(mesaggeError,HttpStatus.NOT_ACCEPTABLE);
	}
	
	@PostMapping("/deposit")
	public ResponseEntity<Transaction> depositMoney(@RequestBody ExtractAndDepositDTO depositDTO, BindingResult result){
		Transaction transaction = null;
		String mesaggeError = "";
		if(!result.hasErrors()) {
			try {
				transaction = serviceTransaction.depositMoney(depositDTO);
				return ResponseEntity.ok(transaction);
			}catch(Exception e) {
				return new ResponseEntity(e.getMessage(),HttpStatus.NO_CONTENT);
			}
		}

		for(int i = 0 ;i < result.getErrorCount();i++) {
			FieldError error = result.getFieldErrors().get(i);
			mesaggeError += error.getField()+" - "+error.getDefaultMessage() + "\n";	
		}
		return new ResponseEntity(mesaggeError,HttpStatus.NOT_ACCEPTABLE);
	}
	
	

}
