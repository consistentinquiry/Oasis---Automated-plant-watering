package com.consistentinquiry.Oasis.exceptions;

import java.io.Serial;

public class JobNotFoundException extends Exception{
  @Serial private static final long serialVersionUID =
      3069470573735059963L;

  public JobNotFoundException(Throwable e){
    super(e);
  }

  public JobNotFoundException(String message){
    super(message);
  }
}
