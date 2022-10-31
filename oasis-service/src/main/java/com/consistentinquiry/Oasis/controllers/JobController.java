package com.consistentinquiry.Oasis.controllers;

import static com.consistentinquiry.Oasis.models.messages.EntityPageElement.fromPage;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.consistentinquiry.Oasis.exceptions.BadRequestException;
import com.consistentinquiry.Oasis.exceptions.JobNotFoundException;
import com.consistentinquiry.Oasis.exceptions.NotFoundException;
import com.consistentinquiry.Oasis.exceptions.ValidationFailedException;
import com.consistentinquiry.Oasis.models.Frequencies;
import com.consistentinquiry.Oasis.models.Job;
import com.consistentinquiry.Oasis.models.elements.IncomingJobElement;
import com.consistentinquiry.Oasis.models.elements.OutgoingJobElement;
import com.consistentinquiry.Oasis.models.elements.OutgoingPlantElement;
import com.consistentinquiry.Oasis.models.messages.EntityPageElement;
import com.consistentinquiry.Oasis.services.JobService;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public class JobController {

  private static final String JOB_PATH = "/jobs";

  private final JobService jobService;

  private final JobValidator jobValidator;

  public JobController(JobService jobService, JobValidator jobValidator) {
    this.jobService = jobService;
    this.jobValidator = jobValidator;
  }

  @PostMapping(value = JOB_PATH, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  @ApiOperation(value = "Add a new job.", response = OutgoingJobElement.class, code = 201)
  @ApiResponses({ @ApiResponse(code = 201, message = "Job created.") })
  public OutgoingJobElement addJob(
      @ApiParam(value = "A new plant.") IncomingJobElement incomingJobElement)
      throws BadRequestException {

    jobValidator.validate(incomingJobElement);

    return OutgoingJobElement.fromModel(jobService.createJob(Frequencies.valueOf(incomingJobElement.getFrequency()),
                                                             LocalDateTime.parse(incomingJobElement.getJobCreationDateTime())));
  }

  @GetMapping(value = "/jobs/{id}", produces = APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  @ApiOperation(value = "Get a specific job.", code = 200)
  public OutgoingJobElement getJob(@PathVariable("id") String id) {
    try {
      return OutgoingJobElement.fromModel(jobService.getJobById(Integer.parseInt(
          id)));
    } catch (JobNotFoundException e) {
      throw new NotFoundException(e);
    }
  }

  @GetMapping(value = JOB_PATH, produces = APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  @ApiOperation(value = "Get all jobs", code = 200)
  public EntityPageElement<Job> getAllJobs(
      @RequestParam(value = "size", required = false, defaultValue = "10")
      int size,
      @RequestParam(value = "page", required = false, defaultValue = "0")
      int page) {

    return fromPage(jobService.queryJobs(PageRequest.of(page, size)),
                    OutgoingJobElement::fromModel);
  }


  
  //TODO - Update a job endpoint
  //TODO - Delete a job endpoint

}
