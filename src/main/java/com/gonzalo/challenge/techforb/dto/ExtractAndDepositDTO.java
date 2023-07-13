package com.gonzalo.challenge.techforb.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ExtractAndDepositDTO {
	
	@NotNull
	@Min(100)
	private Double money;
	
	@NotNull
	@Min(1)
	private Long account;

	public ExtractAndDepositDTO() {
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Long getAccount() {
		return account;
	}

	public void setAccount(Long account) {
		this.account = account;
	}
}
