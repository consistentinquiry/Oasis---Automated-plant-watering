package com.consistentinquiry.Oasis.controllers;

import static com.consistentinquiry.Oasis.controllers.validators.utils.Preconditions.checkNotNull;
import static com.consistentinquiry.Oasis.models.messages.EntityPageElement.fromPage;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.consistentinquiry.Oasis.controllers.validators.PlantValidator;
import com.consistentinquiry.Oasis.exceptions.BadRequestException;
import com.consistentinquiry.Oasis.exceptions.InvalidIDException;
import com.consistentinquiry.Oasis.exceptions.NotFoundException;
import com.consistentinquiry.Oasis.exceptions.PlantNotFoundException;
import com.consistentinquiry.Oasis.models.elements.IncomingPlantElement;
import com.consistentinquiry.Oasis.models.elements.OutgoingPlantElement;
import com.consistentinquiry.Oasis.models.messages.EntityPageElement;
import com.consistentinquiry.Oasis.services.PlantService;
import com.consistentinquiry.Oasis.utils.IntegerIDConverter;

import org.aspectj.weaver.ast.Not;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController public class PlantController {

  private static final String PLANT_PATH = "/plants";

  private final PlantService plantService;

  private final PlantValidator plantValidator;

  public PlantController(
      PlantService plantService, PlantValidator plantValidator) {
    this.plantService = plantService;
    this.plantValidator = plantValidator;
  }

  @GetMapping(value = "/plants/{id}", produces = APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  @ApiOperation(value = "Get a specific plant.", code = 200)
  public OutgoingPlantElement getPlant(@PathVariable("id") String id) {
    try {
      return OutgoingPlantElement.fromModel(plantService.getPlantById(Integer.parseInt(
          id)));
    } catch (PlantNotFoundException e) {
      throw new NotFoundException(e);
    }
  }

  @GetMapping(value = PLANT_PATH, produces = APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  @ApiOperation(value = "Get all plants.", code = 200)
  public EntityPageElement<OutgoingPlantElement> getAllPlants(
      @RequestParam(value = "size", required = false, defaultValue = "3")
      int size,
      @RequestParam(value = "page", required = false, defaultValue = "0")
      int page) {


    return fromPage(plantService.queryPlants(PageRequest.of(page, size)),
                    OutgoingPlantElement::fromModel);
  }

  @PostMapping(value = PLANT_PATH, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  @ApiOperation(value = "Add a new plant.", response = OutgoingPlantElement.class, code = 201)
  @ApiResponses({ @ApiResponse(code = 201, message = "Tag created.") })
  public OutgoingPlantElement addPlant(
      @ApiParam(value = "A new plant.") @RequestBody
      IncomingPlantElement incomingPlantElement)
      throws BadRequestException {

    plantValidator.validate(incomingPlantElement);

    return OutgoingPlantElement.fromModel(plantService.createPlant(
        incomingPlantElement.getName(),
        incomingPlantElement.getSpecies(),
        Integer.parseInt(incomingPlantElement.getAge()),
        incomingPlantElement.getImageUrl()));
  }

  //TODO : Updates are not actually updating, find out why.
  @PostMapping(value = PLANT_PATH
                       + "/{id}/updates", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.ACCEPTED) @ApiOperation(value = "Update a plant")
  @ApiResponses({
      @ApiResponse(code = 201, message = "Plant updated."),
      @ApiResponse(code = 404, message = "Plant not found") })
  public void updatePlant(
      @PathVariable("id") String id, @RequestBody IncomingPlantElement plant)
      throws BadRequestException {

    checkNotNull(id, "plantId");
    IntegerIDConverter integerIDConverter = new IntegerIDConverter(id);

    final Integer plantId;
    try {
      plantId = integerIDConverter.getInteger();
    } catch (InvalidIDException e) {
      throw new BadRequestException("The id: " + id + " is invalid.");
    }

    try {
      OutgoingPlantElement.fromModel(plantService.updatePlant(plantId,
                                                              plant.getName(),
                                                              plant.getSpecies(),
                                                              Integer.parseInt(
                                                                  plant.getAge()),
                                                              plant.getImageUrl()));
    } catch (PlantNotFoundException e) {
      throw new NotFoundException(e);
    }
  }

  //TODO : Delete plant endpoint and repository
/*
  @DeleteMapping(value = PLANT_PATH + "/{id}/")
  @ResponseStatus(HttpStatus.ACCEPTED)
  @ApiOperation(value = "Delete a plant", code = 202) @ApiResponses({
      @ApiResponse(code = 202, message = "Plant deleted"),
      @ApiResponse(code = 404, message = "Plant not found") })
  public void deletePlant( @PathVariable("id") String id)
      throws BadRequestException {

    checkNotNull(id, "plantId");
    IntegerIDConverter integerIDConverter = new IntegerIDConverter(id);

    final Integer plantId;
    try {
      plantId = integerIDConverter.getInteger();
    } catch (InvalidIDException e) {
      throw new BadRequestException("The id: " + id + " is invalid.");
    }

    try{
    }
  }
*/
}
