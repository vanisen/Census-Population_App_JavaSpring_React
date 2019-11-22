package com.org.census.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.org.census.dto.UploadFileProcessingResponse;

/**
 * This is the exception handler for all exceptions occurring in the application
 */
@ControllerAdvice
public class AppExceptionHandler {


  @ExceptionHandler(value = AppValidationException.class)
  public ResponseEntity <Object> exception(AppValidationException exception) {
    return new ResponseEntity<>(exception.getMsg(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = FileStorageException.class)
  public ResponseEntity <Object> exception(FileStorageException exception) {
    UploadFileProcessingResponse uploadFileProcessingResponse = exception.getUploadFileProcessingResponse();
    if(null == uploadFileProcessingResponse) {
      return new ResponseEntity<>(exception.getMessage(), HttpStatus.OK);
    }
    return new ResponseEntity<>(uploadFileProcessingResponse, HttpStatus.OK);
  }
}
