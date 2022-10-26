package com.consistentinquiry.Oasis.models;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Job {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private LocalDateTime jobCreationDateTime;
  private LocalDateTime lastRunTime;
  private Frequencies frequency;

  protected Job() {

  }

  public Job(LocalDateTime jobCreationDateTime) {
    this.jobCreationDateTime = jobCreationDateTime;
  }

  public LocalDateTime getJobCreationDateTime() {
    return jobCreationDateTime;
  }

  public LocalDateTime getLastRunTime() {
    return lastRunTime;
  }

  public void setLastRunTime(LocalDateTime lastRunTime) {
    this.lastRunTime = lastRunTime;
  }

  public Frequencies getFrequency() {
    return frequency;
  }

  public void setFrequency(Frequencies frequency) {
    this.frequency = frequency;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Job job = (Job) o;
    return id == job.id && jobCreationDateTime.equals(job.jobCreationDateTime)
           && lastRunTime.equals(job.lastRunTime) && frequency == job.frequency;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, jobCreationDateTime, lastRunTime, frequency);
  }

  @Override
  public String toString() {
    return "Job{" + "id=" + id + ", jobCreationDateTime=" + jobCreationDateTime
           + ", lastRunTime=" + lastRunTime + ", frequency=" + frequency + '}';
  }
}
