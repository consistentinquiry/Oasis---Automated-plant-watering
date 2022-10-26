package com.consistentinquiry.Oasis.controllers.validators.utils;

import com.consistentinquiry.Oasis.exceptions.BadRequestException;

public class Preconditions {

  public static <T> T checkNotNull(T value, String field)
      throws BadRequestException {
    if(value == null){
      throw new BadRequestException(field + " must be present");
    }
    return value;
  }

  public static String checkNotEmpty(String value, String field)
      throws BadRequestException {
    if(value.length() == 0){
      throw new BadRequestException(field + " cannot be empty");
    }
    return value;
  }

  public static String checkNotExclusiveWhitespaces(String value, String field)
      throws BadRequestException {
    if(value.isBlank()){
      throw new BadRequestException(field + " cannot consist only of whitespace");
    }
    return value;
  }
}
