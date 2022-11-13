package com.consistentinquiry.Oasis.models.elements;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.consistentinquiry.Oasis.models.Job;
import com.consistentinquiry.Oasis.models.Plant;
import com.consistentinquiry.Oasis.utils.DateToStrConverter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "A plant that can have jobs assigned to it")
public class OutgoingPlantElement {

  @ApiModelProperty("The unique identifier of this plant") private String id;

  @ApiModelProperty("The name of this plant") private String name;

  @ApiModelProperty("The species of this plant") private String species;


  @ApiModelProperty("The url of the image of this plant") private String
      imageUrl;

  public OutgoingPlantElement() {

  }

  public OutgoingPlantElement(String name, String species, String imageUrl) {
    this.name = name;
    this.species = species;
    this.imageUrl = imageUrl;
  }

  public OutgoingPlantElement(
      String id, String name, String species, String imageUrl) {
    this.id = id;
    this.name = name;
    this.species = species;
    this.imageUrl = imageUrl;
  }

  public static OutgoingPlantElement fromModel(Plant plant) {
    return new OutgoingPlantElement(String.valueOf(plant.getId()),
                                  String.valueOf(plant.getName()),
                                  String.valueOf(plant.getSpecies()),
                                  String.valueOf(plant.getImageUrl()));
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSpecies() {
    return species;
  }

  public void setSpecies(String species) {
    this.species = species;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  @Override public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    OutgoingPlantElement that = (OutgoingPlantElement) o;
    return id.equals(that.id) && name.equals(that.name)
           && species.equals(that.species) && imageUrl.equals(that.imageUrl);
  }

  @Override public int hashCode() {
    return Objects.hash(id, name, species, imageUrl);
  }

  @Override public String toString() {
    return "OutgoingPlantElement{" + "id='" + id + '\'' + ", name='" + name
           + '\'' + ", species='" + species + '\'' + ", imageUrl='" + imageUrl
           + '\'' + '}';
  }
}
