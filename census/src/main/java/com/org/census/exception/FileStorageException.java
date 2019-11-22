package com.org.census.exception;

import com.org.census.dto.UploadFileProcessingResponse;

/**
 * this class handles all exceptions related to the data FIle processing
 */
public class FileStorageException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private UploadFileProcessingResponse uploadFileProcessingResponse;

	String message;

	public FileStorageException(String message) {
		super(message);
		this.message = message;
	}

	public FileStorageException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileStorageException(UploadFileProcessingResponse uploadFileProcessingResponse) {
		this.uploadFileProcessingResponse = uploadFileProcessingResponse;
	}

	public UploadFileProcessingResponse getUploadFileProcessingResponse() {
		return uploadFileProcessingResponse;
	}
}
