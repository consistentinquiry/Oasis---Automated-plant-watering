package com.consistentinquiry.Oasis.comms.exceptions;

import java.io.Serial;

public class ServerSocketStartupFailureException extends Exception{
  @Serial private static final long serialVersionUID =
      -6494863012161128329L;


  public ServerSocketStartupFailureException(Throwable e){
    super(e);
  }

  public ServerSocketStartupFailureException(String message){
    super(message);
  }
}
