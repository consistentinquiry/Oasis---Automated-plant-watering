package com.consistentinquiry.Oasis.services;

import java.util.ArrayList;
import java.util.List;

import com.consistentinquiry.Oasis.exceptions.PlantNotFoundException;
import com.consistentinquiry.Oasis.models.Plant;
import com.consistentinquiry.Oasis.repositories.PlantRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service public class RepositoryPlantsService
    implements PlantService {
  private final PlantRepository plantRepository;

  public RepositoryPlantsService(PlantRepository plantRepository) {
    this.plantRepository = plantRepository;
  }

  @Override public Plant createPlant(
      String name, String species, int age, String imageUrl) {
    return plantRepository.save(new Plant(name, species, age, imageUrl));
  }

  @Override public Page<Plant> queryPlants(Pageable pageable) {
    return plantRepository.findAll(pageable);
  }

  @Override public Plant updatePlant(
      int plantId, String name, String species, int age, String imageUrl)
      throws PlantNotFoundException {
    final Plant existingPlant = getPlantById(plantId);

    if(name != null){
      existingPlant.setName(name);
    }

    if(species != null){
      existingPlant.setSpecies(species);
    }

    if(imageUrl != null){
      existingPlant.setImageUrl(imageUrl);
    }

    return existingPlant;
  }

  @Override public Plant getPlantById(int plantId)
      throws PlantNotFoundException {
    return plantRepository.getById(plantId);
  }

  private List<Plant> getPlantsByIds(List<Integer> plantIds)
      throws PlantNotFoundException {
    List<Plant> plants = new ArrayList<>();
    for(int plantId : plantIds){
      plants.add(plantRepository.getById(plantId));
    }
    return plants;
  }
}
