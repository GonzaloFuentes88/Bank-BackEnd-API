package com.gonzalo.challenge.techforb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gonzalo.challenge.techforb.dto.CardDTO;
import com.gonzalo.challenge.techforb.dto.CardRemoveDTO;
import com.gonzalo.challenge.techforb.entitys.Card;
import com.gonzalo.challenge.techforb.entitys.CreditCard;
import com.gonzalo.challenge.techforb.entitys.DebitCard;
import com.gonzalo.challenge.techforb.exceptions.IdOutOfRangeException;
import com.gonzalo.challenge.techforb.service.IServiceAccount;

@RestController
@RequestMapping("/card")
public class CardsController {
	
	@Autowired
	private IServiceAccount serviceAccount;
	
	
	//AGREGAR TARJETA
	@PostMapping("/add")
	public ResponseEntity<Card> addCard(@Valid @RequestBody CardDTO cardDTO, BindingResult result){
		Card card = null;
		String mesaggeError = "";
		if(!result.hasErrors() && cardDTO.getAccount() > 0) {
			try {
				card = serviceAccount.save(cardDTO);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ResponseEntity.ok(card);
		}
		for(int i = 0 ;i < result.getErrorCount();i++) {
			FieldError error = result.getFieldErrors().get(i);
			mesaggeError += error.getField()+" - "+error.getDefaultMessage() + "\n";	
		}
		return new ResponseEntity(mesaggeError,HttpStatus.NOT_ACCEPTABLE);
	}
	
	//QUITAR TARJETA
	
	
	@GetMapping("/credit/listar/{accountNumber}")
	public ResponseEntity<List<CreditCard>> findAllCreditCards(@PathVariable("accountNumber") Long accountNumber){
		List<CreditCard> cards = new ArrayList<>();
		try {
			cards = serviceAccount.findAllCreditByAccount(accountNumber);  
			if(cards != null) {
				return new ResponseEntity<List<CreditCard>>(cards,HttpStatus.OK);
			}
			return new ResponseEntity<List<CreditCard>>(HttpStatus.NO_CONTENT);
		}catch(IdOutOfRangeException idOutOfRangeException) {
			return new ResponseEntity(idOutOfRangeException.getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping("/debit/listar/{accountNumber}")
	public ResponseEntity<List<DebitCard>> findAllDebitCards(@PathVariable("accountNumber") Long accountNumber){
		List<DebitCard> cards = new ArrayList<>();
		try {
			cards = serviceAccount.findAllDebitByAccount(accountNumber);  
			if(cards != null) {
				return new ResponseEntity<List<DebitCard>>(cards,HttpStatus.OK);
			}
			return new ResponseEntity<List<DebitCard>>(HttpStatus.NO_CONTENT);
		}catch(IdOutOfRangeException idOutOfRangeException) {
			return new ResponseEntity(idOutOfRangeException.getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@DeleteMapping("/remove/")
	public ResponseEntity<Card> removeCard(@Valid @RequestBody CardRemoveDTO cardDTO, BindingResult result){
		String mesaggeError = "";
		if(!result.hasErrors()) {
			try {
				serviceAccount.delete(cardDTO);
				return ResponseEntity.ok().build();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int i = 0 ;i < result.getErrorCount();i++) {
			FieldError error = result.getFieldErrors().get(i);
			mesaggeError += error.getField()+" - "+error.getDefaultMessage() + "\n";	
		}
		return new ResponseEntity(mesaggeError,HttpStatus.NOT_ACCEPTABLE);
	}

}
