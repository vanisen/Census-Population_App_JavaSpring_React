package com.org.census.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * it is model for setting response
 */

@Getter
@Setter
@NoArgsConstructor
public class ZipCodeResponse {
	private StatusEnum status;
	private List<Long> result;
	public ZipCodeResponse(StatusEnum status, List<Long> response) {
		this.status = status;
		this.result = response;
	}
}
