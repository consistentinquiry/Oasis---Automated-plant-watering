package com.consistentinquiry.Oasis.repositories;

import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;

import com.consistentinquiry.Oasis.exceptions.JobNotFoundException;
import com.consistentinquiry.Oasis.exceptions.PlantNotFoundException;
import com.consistentinquiry.Oasis.models.Job;
import com.consistentinquiry.Oasis.models.Plant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends JpaRepository<Job, Integer> {
  Page<Job> findAll(Pageable pageable);

  Optional<Job> findById(Integer integer);

  default Job getById(int id)
      throws JobNotFoundException {
    return findById(id).orElseThrow(() -> new JobNotFoundException(String.valueOf(id)));
  }
}
