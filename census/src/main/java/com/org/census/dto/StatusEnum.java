package com.org.census.dto;

public enum StatusEnum {

	SUCCESS("Success"), FAILED("Failed");

	private String status;

	StatusEnum(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}
