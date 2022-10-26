package com.consistentinquiry.Oasis.comms.exceptions;

import java.io.Serial;

public class ServerSocketCommunicationFailureException extends Exception{
  @Serial private static final long serialVersionUID =
      8207983878366568207L;

  public ServerSocketCommunicationFailureException(Throwable e){
    super(e);
  }

  public ServerSocketCommunicationFailureException(String message){
    super(message);
  }
}
