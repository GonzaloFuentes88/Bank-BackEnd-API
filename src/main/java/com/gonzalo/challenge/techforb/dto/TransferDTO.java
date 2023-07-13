package com.gonzalo.challenge.techforb.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TransferDTO {
	@Size(max=100)
	private String description;
	
	@NotNull
	@Min(1)
	private Double amount;
	
	@NotNull
	@Min(1)
	private Long numberAccountOrigin;
	
	@NotNull
	@Min(1)
	private Long numberAccoutDestination;
	
	public TransferDTO() {
	}

	
	
	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Double getAmount() {
		return amount;
	}



	public void setAmount(Double amount) {
		this.amount = amount;
	}



	public Long getNumberAccountOrigin() {
		return numberAccountOrigin;
	}

	public void setNumberAccountOrigin(Long numberAccountOrigin) {
		this.numberAccountOrigin = numberAccountOrigin;
	}

	public Long getNumberAccoutDestination() {
		return numberAccoutDestination;
	}

	public void setNumberAccoutDestination(Long numberAccoutDestination) {
		this.numberAccoutDestination = numberAccoutDestination;
	}
	
	
	
	

}
