package com.consistentinquiry.Oasis.models.elements;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.consistentinquiry.Oasis.models.Job;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "A job that is assigned to a job")
public class OutgoingJobElement {

  @ApiModelProperty("The unique identifier of this job") private String id;

  @ApiModelProperty("The frequency this job will run") private String frequency;

  @ApiModelProperty("The date and time this job was created") private String
      jobCreationDateTime;

  @ApiModelProperty("The date and time this job was last run") private String
      lastRunTime;

  public OutgoingJobElement() {
  }

  public OutgoingJobElement(
      String id,
      String frequency,
      String jobCreationDateTime,
      String lastRunTime) {
    this.id = id;
    this.frequency = frequency;
    this.jobCreationDateTime = jobCreationDateTime;
    this.lastRunTime = lastRunTime;
  }


  public static OutgoingJobElement fromModel(Job job) {
    return new OutgoingJobElement(String.valueOf(job.getId()),
                                  job.getFrequency().name(),
                                  job.getJobCreationDateTime().toString(),
                                  job.getLastRunTime().toString());
  }

  public static List<OutgoingJobElement> fromModelList(List<Job> jobs) {
    return jobs.stream()
               .map(OutgoingJobElement::fromModel)
               .collect(Collectors.toList());
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFrequency() {
    return frequency;
  }

  public void setFrequency(String frequency) {
    this.frequency = frequency;
  }

  public String getJobCreationDateTime() {
    return jobCreationDateTime;
  }

  public void setJobCreationDateTime(String jobCreationDateTime) {
    this.jobCreationDateTime = jobCreationDateTime;
  }

  public String getLastRunTime() {
    return lastRunTime;
  }

  public void setLastRunTime(String lastRunTime) {
    this.lastRunTime = lastRunTime;
  }

  @Override public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    OutgoingJobElement that = (OutgoingJobElement) o;
    return id.equals(that.id) && frequency.equals(that.frequency)
           && jobCreationDateTime.equals(that.jobCreationDateTime)
           && lastRunTime.equals(that.lastRunTime);
  }

  @Override public int hashCode() {
    return Objects.hash(id, frequency, jobCreationDateTime, lastRunTime);
  }

  @Override public String toString() {
    return "OutgoingJobElement{" + "id='" + id + '\'' + ", frequency='"
           + frequency + '\'' + ", jobCreationDateTime='" + jobCreationDateTime
           + '\'' + ", lastRunTime='" + lastRunTime + '\'' + '}';
  }
}
