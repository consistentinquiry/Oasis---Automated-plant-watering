package com.consistentinquiry.Oasis.controllers.validators;

import static com.consistentinquiry.Oasis.controllers.validators.utils.Preconditions.checkNotEmpty;
import static com.consistentinquiry.Oasis.controllers.validators.utils.Preconditions.checkNotNull;

import javax.persistence.criteria.CriteriaBuilder;

import com.consistentinquiry.Oasis.controllers.validators.Validator;
import com.consistentinquiry.Oasis.exceptions.BadRequestException;
import com.consistentinquiry.Oasis.exceptions.ValidationFailedException;
import com.consistentinquiry.Oasis.models.Job;
import com.consistentinquiry.Oasis.models.elements.IncomingJobElement;
import com.consistentinquiry.Oasis.models.elements.IncomingPlantElement;

import org.springframework.stereotype.Component;

@Component
public class JobValidator
    implements Validator<IncomingJobElement> {

  @Override public void validate(IncomingJobElement job)
      throws BadRequestException {
    checkNotNull(job.getFrequency(), "frequency");
    checkNotEmpty(job.getFrequency(), "frequency");

    checkNotNull(job.getJobCreationDateTime(), "jobCreationDateTime");
    checkNotEmpty(job.getJobCreationDateTime(), "jobCreationDateTime");
  }
}

