package com.consistentinquiry.Oasis.controllers.validators;

import static com.consistentinquiry.Oasis.controllers.validators.utils.Preconditions.checkNotEmpty;
import static com.consistentinquiry.Oasis.controllers.validators.utils.Preconditions.checkNotExclusiveWhitespaces;
import static com.consistentinquiry.Oasis.controllers.validators.utils.Preconditions.checkNotNull;

import com.consistentinquiry.Oasis.exceptions.BadRequestException;
import com.consistentinquiry.Oasis.exceptions.ValidationFailedException;
import com.consistentinquiry.Oasis.models.elements.IncomingPlantElement;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class PlantValidator implements Validator<IncomingPlantElement>{
  @Override public void validate(IncomingPlantElement createPlantDTO)
      throws BadRequestException {
    checkNotNull(createPlantDTO.getName(), "name");
    checkNotEmpty(createPlantDTO.getName(), "name");
    checkNotExclusiveWhitespaces(createPlantDTO.getName(), "name");

   checkNotNull(createPlantDTO.getSpecies(), "species");
   checkNotNull(createPlantDTO.getSpecies(), "species");
   checkNotExclusiveWhitespaces(createPlantDTO.getSpecies(), "species");

   checkNotNull(createPlantDTO.getSpecies(), "age");
   checkNotEmpty(createPlantDTO.getAge(), "age");
   checkNotExclusiveWhitespaces(createPlantDTO.getSpecies(), "age");
  }
}
