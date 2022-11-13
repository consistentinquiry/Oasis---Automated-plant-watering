package com.consistentinquiry.Oasis.services;

import java.time.LocalDateTime;

import com.consistentinquiry.Oasis.exceptions.JobNotFoundException;
import com.consistentinquiry.Oasis.models.Frequencies;
import com.consistentinquiry.Oasis.models.Job;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface JobService {

  /**
   * Persists a new job.
   *
   * @param frequency of the job, how often it will be run.
   * @param jobCreationTime the date and time that the job was created.
   *
   **/
  Job createJob(Frequencies frequency, LocalDateTime jobCreationTime);

  /**
   * Queries all jobs.
   *
   * @param pageable Pagination information, including sorting.
   * @return The requested {@link Page} of {@link Job}s.
   * Never * {@code null}. If there are no jobs
   * available, the {@link Page#getContent() page content} will be an
   * empty list.
   */

  Page<Job> queryJobs(Pageable pageable);

  /**
   * update an existing job.
   *
   * @param jobId  The id of the job to update.
   * @param lastRunTime The date and time that the job was last run.
   * @param frequency The new updated job frequency.
   **/
  Job updateJob(
      int jobId,
      LocalDateTime lastRunTime,
      Frequencies frequency )
      throws JobNotFoundException;

  /**
   * Returns the job with the given ID
   *
   * @param jobId the ID of the job to return
   * @return the job by the given ID
   * @throws JobNotFoundException If the given job ID does not exist
   */
  Job getJobById(int jobId)
      throws JobNotFoundException;


  /**
   * Deletes the job with the given ID
   *
   * @param id of the job to be deleted.
   * @return true or false depending on whether the operation was successful.
   * @throws JobNotFoundException if the given job id does not exist.
  * */
  boolean deleteJobById(Integer id) throws JobNotFoundException;

}
