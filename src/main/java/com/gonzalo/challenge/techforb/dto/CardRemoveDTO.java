package com.gonzalo.challenge.techforb.dto;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CardRemoveDTO {
	
	@NotNull
	@Min(1)
	private Long account;
	
	@Min(999999999999L)
	@Max(9999999999999999L)
	@NotNull
	private Long numberCard;
	
	@NotNull
	private Boolean isCredit;
	
	public CardRemoveDTO() {
	}
	public Long getAccount() {
		return account;
	}
	public void setAccount(Long account) {
		this.account = account;
	}
	public Long getNumberCard() {
		return numberCard;
	}
	public void setNumberCard(Long numberCard) {
		this.numberCard = numberCard;
	}
	public Boolean getIsCredit() {
		return isCredit;
	}
	public void setIsCredit(Boolean isCredit) {
		this.isCredit = isCredit;
	}
	
}
