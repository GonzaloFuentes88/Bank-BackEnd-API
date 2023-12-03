package com.gonzalo.bankapibackend.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.gonzalo.bankapibackend.dto.RegisterDTO;
import com.gonzalo.bankapibackend.entitys.Account;
import com.gonzalo.bankapibackend.service.IServiceClient;

import ch.qos.logback.core.net.server.Client;

@RestController
public class LoginController {

	
	@Autowired
	private IServiceClient clientService;
	
//	//METODO PRUEBA PARA SABER SI EL TOKEN ANDA
//	@GetMapping("/Home")
//	public String obtenerToken(@RequestHeader("Authorization") String token) {
//		if(token.isBlank()) {
//			return "ERROR TOKEN";
//		}
//		return token;
//	}
	
	@PostMapping("/register")
	public ResponseEntity<Client> registerClient(@Valid @RequestBody RegisterDTO registerDTO, BindingResult result){
		String mesaggeError = "";
		if(!result.hasErrors()) {
			try {
				clientService.save(registerDTO);
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
	
	@GetMapping("/logout")
	public String logout() {
		return "redirect:/logout";
	}
	
	
	
}
