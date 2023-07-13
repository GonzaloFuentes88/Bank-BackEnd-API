package com.gonzalo.challenge.techforb.entitys;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Client implements Serializable{

	@Id
	private Long dni;
	
	//@NotBlank
	private String name;
	
	//@NotBlank
	@Column(name = "last_name")
	private String lastName;
	
	//@NotNull
	@Column(name = "date_of_bith")
	private Date dateOfBirth;
	
	//@NotNull
	//@Size(min = 1, max= 4)
	@Column(name = "civil_status")
	private Integer civilStatus;
	
	//@NotBlank
	private String nationality;
	
	//@Size(min=1, max=2)
	@NotNull
	private Integer gender;
	
	//@NotNull
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "address")
	private Address address;
	
	//@NotNull
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "account")
	private Account account;
	
	//@NotNull
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private User user;
	
	
	public Client() {
	}
	
	

	public Account getAccount() {
		return account;
	}



	public void setAccount(Account account) {
		this.account = account;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getCivilStatus() {
		return civilStatus;
	}

	public void setCivilStatus(Integer civilStatus) {
		this.civilStatus = civilStatus;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}
	
	
	
	

	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}





	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


}
