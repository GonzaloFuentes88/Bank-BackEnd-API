package com.gonzalo.bankapibackend.utils;

public enum TypeCivilStatus {
	SINGLE(1,"SINGLE"),
	MARRIED(2,"MARRIED"),
	WINDOWED(3,"WINDOWED"),
	DIVORCED(4,"DIVORCED");
	

	TypeCivilStatus(Integer value, String type) {
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
