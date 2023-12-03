package com.gonzalo.bankapibackend.entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "debit_cars")
public class DebitCard extends Card implements Serializable{

	//@Size(min=0)
	@Column(name = "available_balance")
	private Double availableBalance;
	
	//@Size(min=0)
	@Column(name = "daily_limit")
	private Double dailyLimit;
	
	public DebitCard() {
	}
	

	public Double getAvailableBalance() {
		return availableBalance;
	}






	public void setAvailableBalance(Double availableBalance) {
		this.availableBalance = availableBalance;
	}






	public Double getDailyLimit() {
		return dailyLimit;
	}






	public void setDailyLimit(Double dailyLimit) {
		this.dailyLimit = dailyLimit;
	}






	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}
