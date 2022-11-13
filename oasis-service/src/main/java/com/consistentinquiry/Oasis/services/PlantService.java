package com.consistentinquiry.Oasis.services;

import com.consistentinquiry.Oasis.models.Plant;
import com.consistentinquiry.Oasis.exceptions.PlantNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PlantService {
  /**
   * Persists a new plant.
   *
   * @param name     The name of the plant, yes plants obviously have names
   * @param species  The species of the plant
   * @param imageUrl The url to the associated image
   **/
  Plant createPlant(String name, String species, String imageUrl);

  /**
   * Queries all plants.
   *
   * @param pageable Pagination information, including sorting.
   * @return The requested {@link Page} of {@link Plant}s.
   * Never * {@code null}. If there are no plants
   * available, the * {@link Page#getContent() page content} will be an
   * empty list.
   */

  Page<Plant> queryPlants(Pageable pageable);

  /**
   * update an existing plant.
   *
   * @param plantId  The id of the plant to update
   * @param name     The name of the plant to update
   * @param species  The species of the plant to update
   * @param imageUrl The url to the associated image to update
   **/
  Plant updatePlant(
      int plantId,
      String name,
      String species,
      String imageUrl)
      throws PlantNotFoundException;

  /**
   * Returns the plant with the given ID
   *
   * @param plantId the ID of the plant to return
   * @return the plant by the given ID
   * @throws PlantNotFoundException If the given plant ID does not exist
   */
  Plant getPlantById(int plantId)
      throws PlantNotFoundException;


  /**
   * Deletes the plant with the given ID
   *
   * @param plantId of the plant to delete
   * @return true or false depending on whether the operation was successful.
   */
  boolean deletePlant(int plantId);
}
