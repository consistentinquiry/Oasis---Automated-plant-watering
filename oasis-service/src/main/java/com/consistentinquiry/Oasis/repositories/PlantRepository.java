package com.consistentinquiry.Oasis.repositories;

import java.util.Optional;

import com.consistentinquiry.Oasis.exceptions.PlantNotFoundException;
import com.consistentinquiry.Oasis.models.Plant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PlantRepository
    extends JpaRepository<Plant, Integer>, JpaSpecificationExecutor<Plant> {

  //Learning note, repositories are the same things as DAOs so
  //stop getting confused about them

  @Override Page<Plant> findAll(Pageable pageable);

  @Override Optional<Plant> findById(Integer integer);

  default Plant getById(int id)
      throws PlantNotFoundException {
    return findById(id).orElseThrow(() -> new PlantNotFoundException(String.valueOf(id)));
  }
}
