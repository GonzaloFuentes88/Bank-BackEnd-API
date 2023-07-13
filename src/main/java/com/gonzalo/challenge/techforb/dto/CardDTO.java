package com.gonzalo.challenge.techforb.dto;

import java.util.Date;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CardDTO {
	
	@NotNull
	@Min(999999999999L)
	@Max(9999999999999999L)
	private Long number;
	
	@NotNull
	@Min(1)
	private Long account;
	
	@NotNull
	@FutureOrPresent
	private Date expirationDate;
	
	@NotNull
	@Min(100)
	@Max(9999L)
	private Long cvv;
	
	@NotNull
	private Boolean isCredit;
	
	
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public Long getAccount() {
		return account;
	}
	public void setAccount(Long account) {
		this.account = account;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public Long getCvv() {
		return cvv;
	}
	public void setCvv(Long cvv) {
		this.cvv = cvv;
	}
	public Boolean getIsCredit() {
		return isCredit;
	}
	public void setIsCredit(Boolean isCredit) {
		this.isCredit = isCredit;
	}
	
}
