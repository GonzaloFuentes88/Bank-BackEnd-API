package com.gonzalo.challenge.techforb.entitys;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public abstract class Card implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long number;
	
	@NotNull
	@Column(name = "expiration_date")
	private Date expirationDate;
	
	@NotNull
	//@Size(min=100, max=9999)
	private Long cvv;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	//@Column(name = "associated_account")
	@JoinColumn(name = "associated_account")
	@JsonIgnore
	private Account associatedAccount;

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}



	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Account getAssociatedAccount() {
		return associatedAccount;
	}

	public void setAssociatedAccount(Account associatedAccount) {
		this.associatedAccount = associatedAccount;
	}

	public Long getCvv() {
		return cvv;
	}

	public void setCvv(Long cvv) {
		this.cvv = cvv;
	}
	
	
	
	
}
