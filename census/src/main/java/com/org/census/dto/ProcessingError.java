package com.org.census.dto;

import java.util.List;

/**
 * it is model for Errors while processing data file
 */
public class ProcessingError {

  private String reason;
  private List<String> errorLines;

  public String getReason() {
    return reason;
  }

  public void setReason(final String reason) {
    this.reason = reason;
  }

  public List<String> getErrorLines() {
    return errorLines;
  }

  public void setErrorLines(final List<String> errorLines) {
    this.errorLines = errorLines;
  }
}
