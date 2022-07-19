package com.accenture.appsyncpoc.error;

public class CustomerWithEmailAlreadyExists extends Exception {

  private static final long serialVersionUID = 1L;

  public CustomerWithEmailAlreadyExists() {
    super();
  }

  public CustomerWithEmailAlreadyExists(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public CustomerWithEmailAlreadyExists(String message, Throwable cause) {
    super(message, cause);
  }

  public CustomerWithEmailAlreadyExists(String message) {
    super(message);
  }

  public CustomerWithEmailAlreadyExists(Throwable cause) {
    super(cause);
  }
}
