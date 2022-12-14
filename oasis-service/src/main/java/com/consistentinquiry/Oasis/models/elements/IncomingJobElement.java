package com.consistentinquiry.Oasis.models.elements;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "A watering job for a given plant")
public class IncomingJobElement {

  @ApiModelProperty("How often this job should run")
  private String frequency;

  @ApiModelProperty("The creation date and time of this job")
  private String jobCreationDateTime;

  private String lastRunTime;

  public IncomingJobElement() {
  }

  public IncomingJobElement(String frequency, String jobCreationDateTime) {
    this.frequency = frequency;
    this.jobCreationDateTime = jobCreationDateTime;
  }

  public IncomingJobElement(
      String frequency, String jobCreationDateTime, String lastRunTime) {
    this.frequency = frequency;
    this.jobCreationDateTime = jobCreationDateTime;
    this.lastRunTime = lastRunTime;
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
    IncomingJobElement that = (IncomingJobElement) o;
    return frequency.equals(that.frequency)
           && jobCreationDateTime.equals(that.jobCreationDateTime)
           && lastRunTime.equals(that.lastRunTime);
  }

  @Override public int hashCode() {
    return Objects.hash(frequency, jobCreationDateTime, lastRunTime);
  }

  @Override public String toString() {
    return "IncomingJobElement{" + "frequency='" + frequency + '\''
           + ", jobCreationDateTime='" + jobCreationDateTime + '\''
           + ", lastRunTime='" + lastRunTime + '\'' + '}';
  }
}
