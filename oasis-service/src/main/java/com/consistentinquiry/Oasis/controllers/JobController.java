package com.consistentinquiry.Oasis.controllers;

import static com.consistentinquiry.Oasis.controllers.validators.utils.Preconditions.checkNotNull;
import static com.consistentinquiry.Oasis.models.messages.EntityPageElement.fromPage;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.time.LocalDateTime;
import java.util.Optional;

import com.consistentinquiry.Oasis.controllers.validators.JobValidator;
import com.consistentinquiry.Oasis.exceptions.BadRequestException;
import com.consistentinquiry.Oasis.exceptions.InvalidIDException;
import com.consistentinquiry.Oasis.exceptions.JobNotFoundException;
import com.consistentinquiry.Oasis.exceptions.NotFoundException;
import com.consistentinquiry.Oasis.models.Frequencies;
import com.consistentinquiry.Oasis.models.elements.IncomingJobElement;
import com.consistentinquiry.Oasis.models.elements.OutgoingJobElement;
import com.consistentinquiry.Oasis.models.messages.EntityPageElement;
import com.consistentinquiry.Oasis.services.JobService;
import com.consistentinquiry.Oasis.utils.IntegerIDConverter;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController public class JobController {

  private static final String JOB_PATH = "/jobs";

  private final JobService jobService;

  private final JobValidator jobValidator;

  public JobController(JobService jobService, JobValidator jobValidator) {
    this.jobService = jobService;
    this.jobValidator = jobValidator;
  }


  @GetMapping(value = JOB_PATH + "/{id}", produces = APPLICATION_JSON_VALUE)
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
  public EntityPageElement<OutgoingJobElement> getAllJobs(
      @RequestParam(value = "size", required = false, defaultValue = "10")
      int size,
      @RequestParam(value = "page", required = false, defaultValue = "0")
      int page) {

    return fromPage(jobService.queryJobs(PageRequest.of(page, size)),
                    OutgoingJobElement::fromModel);
  }

  @PostMapping(value = JOB_PATH, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  @ApiOperation(value = "Add a new job.", response = OutgoingJobElement.class, code = 201)
  @ApiResponses({ @ApiResponse(code = 201, message = "Job created.") })
  public OutgoingJobElement addJob(
      @RequestBody IncomingJobElement incomingJobElement)
      throws BadRequestException {

    jobValidator.validate(incomingJobElement);

    return OutgoingJobElement.fromModelWithoutLastRunTime(jobService.createJob(
        Frequencies.valueOf(incomingJobElement.getFrequency()),
        LocalDateTime.parse(incomingJobElement.getJobCreationDateTime())));
  }


  @PostMapping(value = JOB_PATH
                       + "/{id}/updates", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.ACCEPTED) @ApiOperation(value = "Update a job")
  @ApiResponses({
      @ApiResponse(code = 201, message = "Job updated."),
      @ApiResponse(code = 404, message = "Job not found") })
  public void updateJob(
      @PathVariable("id") String id, @RequestBody IncomingJobElement job)
      throws BadRequestException {

    checkNotNull(id, "jobId");
    IntegerIDConverter integerIDConverter = new IntegerIDConverter(id);

    final Integer jobId;
    try {
      jobId = integerIDConverter.getInteger();
    } catch (InvalidIDException e) {
      throw new BadRequestException("The id: " + id + " is invalid");
    }

    LocalDateTime lastRunTime;
    Frequencies frequency;
    try {
      lastRunTime = LocalDateTime.parse(job.getLastRunTime());
    } catch (NullPointerException e) {
      lastRunTime = null;
    }

    try {
      frequency = Frequencies.valueOf(job.getFrequency());
    } catch (NullPointerException e) {
      frequency = null;
    }

    try {
      OutgoingJobElement.fromModel(jobService.updateJob(jobId,
                                                        lastRunTime,
                                                        frequency));
    } catch (Exception e) {
      throw new NotFoundException(e);
    }
  }

  @PostMapping(value = JOB_PATH + "/{id}/delete")
  @ResponseStatus(HttpStatus.ACCEPTED)
  @ApiOperation(value = "Delete a job", code = 202) @ApiResponses({
      @ApiResponse(code = 202, message = "Job deleted"),
      @ApiResponse(code = 404, message = "Job not found") })
  public ResponseEntity<Integer> deleteJob(@PathVariable("id") String id)
      throws BadRequestException {

    checkNotNull(id, "jobId");
    IntegerIDConverter integerIDConverter = new IntegerIDConverter(id);

    final Integer jobId;
    try {
      jobId = integerIDConverter.getInteger();
    } catch (InvalidIDException e) {
      throw new BadRequestException("The id: " + id + " is invalid.");
    }

    try {
      jobService.deleteJobById(jobId);
      return new ResponseEntity<>(HttpStatus.ACCEPTED);
    } catch (JobNotFoundException e){
      return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
  }
}
