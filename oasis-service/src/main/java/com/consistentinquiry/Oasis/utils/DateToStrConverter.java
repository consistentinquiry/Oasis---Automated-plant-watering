package com.consistentinquiry.Oasis.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateToStrConverter {

  static DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;


  public static String convert(LocalDateTime dateTime){
    String NULL_DATE_TIME = "NULL";
    return dateTime != null ? dateTime.format(formatter) : NULL_DATE_TIME;
  }
}
