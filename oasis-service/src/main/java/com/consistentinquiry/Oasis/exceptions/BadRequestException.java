package com.consistentinquiry.Oasis.exceptions;

import java.io.Serial;

public class BadRequestException extends Exception{
  @Serial private static final long serialVersionUID =
      -5164527700665376385L;

  public BadRequestException() {
  }

  public BadRequestException(String message) {
    super(message);
  }

  public BadRequestException(String message, Throwable cause) {
    super(message, cause);
  }
}
