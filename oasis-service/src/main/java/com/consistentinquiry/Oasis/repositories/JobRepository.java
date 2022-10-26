package com.consistentinquiry.Oasis.repositories;

import com.consistentinquiry.Oasis.models.Job;

import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job, Integer> {
  Job findById(int id);
}
