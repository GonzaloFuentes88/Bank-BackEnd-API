package com.gonzalo.challenge.techforb.service.implementations;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gonzalo.challenge.techforb.dao.IClientDao;
import com.gonzalo.challenge.techforb.dto.RegisterDTO;
import com.gonzalo.challenge.techforb.entitys.Account;
import com.gonzalo.challenge.techforb.entitys.Address;
import com.gonzalo.challenge.techforb.entitys.Client;
import com.gonzalo.challenge.techforb.entitys.User;
import com.gonzalo.challenge.techforb.service.IServiceClient;
import com.gonzalo.challenge.techforb.utils.TypeCivilStatus;
import com.gonzalo.challenge.techforb.utils.TypeGender;

@Service
public class ServiceClientImpl implements IServiceClient{
	
	@Autowired
	private IClientDao clientDao;
		
	@Override
	public List<Client> findAll() {
		return clientDao.findAll();
	}
	@Override
	public Optional<Client> findOne(Long dni) {
		return clientDao.findOneByDni(dni);
	}
	
	@Override
	public void save(RegisterDTO registerDTO) throws Exception{
		Client client = new Client();
		User user = new User();
		Account account = new Account();
		Address address = new Address();
		client.setDni(registerDTO.getDni());
		client.setName(registerDTO.getName());
		client.setLastName(registerDTO.getLastName());
		client.setDateOfBirth(registerDTO.getDateOfBirth());
		client.setNationality(registerDTO.getNationality());
		if(registerDTO.getCivilStatus().equalsIgnoreCase("SINGLE")) client.setCivilStatus(TypeCivilStatus.SINGLE.getValue());
		if(registerDTO.getCivilStatus().equalsIgnoreCase("MARRIED")) client.setCivilStatus(TypeCivilStatus.MARRIED.getValue());
		if(registerDTO.getCivilStatus().equalsIgnoreCase("WINDOWED")) client.setCivilStatus(TypeCivilStatus.WINDOWED.getValue());
		if(registerDTO.getCivilStatus().equalsIgnoreCase("DIVORCED")) client.setCivilStatus(TypeCivilStatus.DIVORCED.getValue());
		if(registerDTO.getGender().equalsIgnoreCase("M")) client.setGender(TypeGender.M.getValue());
		if(registerDTO.getGender().equalsIgnoreCase("F")) client.setGender(TypeGender.F.getValue());
		if(registerDTO.getGender().equalsIgnoreCase("O")) client.setGender(TypeGender.O.getValue());
		user.setEmail(registerDTO.getEmail());
		user.setUsername(registerDTO.getUsername());
		user.setPassword(new BCryptPasswordEncoder().encode(registerDTO.getPassword()));
		account.setBalance(0D);
		account.setOpeningDate(new Date());
		address.setNumber(registerDTO.getNumber());
		address.setStreet(registerDTO.getStreet());
		address.setZip(registerDTO.getZip());
		
		client.setAccount(account);
		client.setUser(user);
		client.setAddress(address);
		
		clientDao.save(client);
	}

}
