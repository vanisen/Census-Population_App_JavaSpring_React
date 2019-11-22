package com.org.census.dto;

import org.springframework.http.HttpStatus;

public class UploadFileProcessingResponse {
  private HttpStatus httpStatus;
  private String message;
  private ProcessingError[] processingErrors;

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

  public void setHttpStatus(final HttpStatus httpStatus) {
    this.httpStatus = httpStatus;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(final String message) {
    this.message = message;
  }

  public ProcessingError[] getProcessingErrors() {
    return processingErrors;
  }

  public void setProcessingErrors(final ProcessingError[] processingErrors) {
    this.processingErrors = processingErrors;
  }
}
