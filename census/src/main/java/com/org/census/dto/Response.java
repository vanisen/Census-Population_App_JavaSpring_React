package com.org.census.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * it is model for setting response
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response {
	private StatusEnum status;
}
