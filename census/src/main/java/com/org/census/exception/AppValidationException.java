package com.org.census.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * this class handles all validation related exceptions
 */
@Getter
@Setter
@AllArgsConstructor
public class AppValidationException extends Exception {
	private static final long serialVersionUID = 1L;
	private String msg;
}
