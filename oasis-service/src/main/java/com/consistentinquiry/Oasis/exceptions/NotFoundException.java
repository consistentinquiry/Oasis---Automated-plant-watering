package com.consistentinquiry.Oasis.exceptions;

import java.io.Serial;

public class NotFoundException
    extends RuntimeException {
  @Serial private static final long serialVersionUID = -6462260872854284002L;

  public NotFoundException(Throwable cause) {
    super(cause);
  }

  public NotFoundException(String message) {
    super(message);
  }
}
