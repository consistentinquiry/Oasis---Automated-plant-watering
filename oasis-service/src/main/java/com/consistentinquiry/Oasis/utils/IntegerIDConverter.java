package com.consistentinquiry.Oasis.utils;

import java.util.List;

import com.consistentinquiry.Oasis.exceptions.InvalidIDException;

public class IntegerIDConverter {
  String strId;

  List<String> strIds;
  List<Integer> intIds;


  public IntegerIDConverter(String id) {
    this.strId = id;
  }

  public IntegerIDConverter(List<String> ids) {
    this.strIds = ids;
  }

  /**
   * Convert a single string ID into a Integer equivalent.
   *
   * @throws NumberFormatException when the String provided to the
   * constructor cannot be converted into an Integer.
   */
  public Integer getInteger()
      throws InvalidIDException {
    try {
      return convert(strId);
    } catch (NumberFormatException e) {
      throw new InvalidIDException(e);
    }
  }

  /**
   * Convert a List of string IDs into their Integer equivalents.
   *
   * @throws NumberFormatException when a String in the provided List to the
   * constructor cannot be converted into an Integer.
   */
  public List<Integer> getIntegers()
      throws InvalidIDException {
    for (String id : strIds) {
      try {
        intIds.add(convert(id));
      } catch (NumberFormatException e) {
        throw new InvalidIDException(e);
      }
    }
    return intIds;
  }

  private Integer convert(String id) {
    return Integer.parseInt(id);
  }
}
