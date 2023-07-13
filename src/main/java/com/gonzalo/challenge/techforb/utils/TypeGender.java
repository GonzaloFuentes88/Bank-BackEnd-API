package com.gonzalo.challenge.techforb.utils;

public enum TypeGender {
	M(1,"MALE"),
	F(2,"FEMALE"),
	O(3,"OTHER");

	TypeGender(Integer value, String type) {
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
