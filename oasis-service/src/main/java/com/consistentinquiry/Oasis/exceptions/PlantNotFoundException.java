package com.consistentinquiry.Oasis.exceptions;

import java.io.Serial;

public class PlantNotFoundException
    extends Exception {

  @Serial private static final long serialVersionUID = -2878067150395137289L;

  public PlantNotFoundException(String e) {
    super(e);
  }
}
