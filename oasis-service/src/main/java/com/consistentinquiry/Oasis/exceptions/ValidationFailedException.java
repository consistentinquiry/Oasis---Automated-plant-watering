package com.consistentinquiry.Oasis.exceptions;

import java.io.Serial;

public class ValidationFailedException extends Exception{
  @Serial private static final long serialVersionUID =
      -8623211011538278083L;

  public ValidationFailedException(){super();}

  public ValidationFailedException(String message) {
    super(message);
  }

  public ValidationFailedException(String message, Throwable cause) {
    super(message, cause);
  }
}
