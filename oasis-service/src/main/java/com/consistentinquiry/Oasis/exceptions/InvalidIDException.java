package com.consistentinquiry.Oasis.exceptions;

import java.io.Serial;

public class InvalidIDException extends Exception{
  @Serial private static final long serialVersionUID =
      6035772555985116244L;

  public InvalidIDException(Throwable cause){
    super(cause);
  }

  public InvalidIDException(String message){
    super(message);
  }
}
