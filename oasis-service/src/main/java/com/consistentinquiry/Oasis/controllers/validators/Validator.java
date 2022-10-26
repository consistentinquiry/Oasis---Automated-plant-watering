package com.consistentinquiry.Oasis.controllers.validators;

import com.consistentinquiry.Oasis.exceptions.BadRequestException;
import com.consistentinquiry.Oasis.exceptions.ValidationFailedException;

public interface Validator<T> {
  /*
  * Validates the provided T.
  *
  * @param entity the entity to validate
  * @throws ValidationFailedException
  *
  */
  void validate(T entity)
      throws ValidationFailedException, BadRequestException;
}
