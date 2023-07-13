package com.gonzalo.challenge.techforb.utils;

public enum TypeTransaction {
	TRANSFER(1,"TRANSFER"),
	DEPOSIT(2,"DEPOSIT"),
	EXTRACT(3,"EXTRACT");

	TypeTransaction(Integer value, String type) {
		this.type=type;
		this.value=value;
	}
	
	private Integer value;
	private String type;
	
	public String getType() {
		return type;
	}
	
	public Integer getValue() {
		return value;
	}

}
