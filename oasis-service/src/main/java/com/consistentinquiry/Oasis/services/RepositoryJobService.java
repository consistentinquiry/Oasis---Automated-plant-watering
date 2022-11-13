package com.consistentinquiry.Oasis.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.consistentinquiry.Oasis.exceptions.JobNotFoundException;
import com.consistentinquiry.Oasis.exceptions.PlantNotFoundException;
import com.consistentinquiry.Oasis.models.Frequencies;
import com.consistentinquiry.Oasis.models.Job;
import com.consistentinquiry.Oasis.models.Plant;
import com.consistentinquiry.Oasis.repositories.JobRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RepositoryJobService
    implements JobService {

  private final JobRepository jobRepository;

  public RepositoryJobService(JobRepository jobRepository) {
    this.jobRepository = jobRepository;
  }

  @Override
  public Job createJob(Frequencies frequency, LocalDateTime jobCreationTime) {
    return jobRepository.save(new Job(jobCreationTime));
  }

  @Override public Page<Job> queryJobs(Pageable pageable) {
    return jobRepository.findAll(pageable);
  }

  @Override public Job updateJob(
      int jobId, LocalDateTime lastRunTime, Frequencies frequency)
      throws JobNotFoundException {

    final Job existingJob = getJobById(jobId);

    if (lastRunTime != null) {
      existingJob.setLastRunTime(lastRunTime);
    }

    if (frequency != null) {
      existingJob.setFrequency(frequency);
    }
    jobRepository.save(existingJob);
    return existingJob;
  }

  @Override public Job getJobById(int jobId)
      throws JobNotFoundException {
    return jobRepository.getById(jobId);
  }

  @Override public boolean deleteJobById(Integer id) {
    try {
      Job plant = getJobById(id);
      jobRepository.delete(plant);
      return true;
    } catch (JobNotFoundException e) {
      return false;
    }
  }

  public List<Job> getAllJobsByIds(List<Integer> jobIds)
      throws JobNotFoundException {
    List<Job> jobsList = new ArrayList<>();
    for (int jobId : jobIds) {
      jobsList.add(jobRepository.getById(jobId));
    }
    return jobsList;
  }


}
