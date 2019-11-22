package com.org.census.dto;

/**
 * this class is the model to aggregate all errors while processing data file
 */
public class UploadFileResponse {
  private String fileName;
  private String fileType;
  private long size;

  public UploadFileResponse(String fileName, String fileType, long size) {
    this.fileName = fileName;
    this.fileType = fileType;
    this.size = size;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(final String fileName) {
    this.fileName = fileName;
  }

  public String getFileType() {
    return fileType;
  }

  public void setFileType(final String fileType) {
    this.fileType = fileType;
  }

  public long getSize() {
    return size;
  }

  public void setSize(final long size) {
    this.size = size;
  }
}
