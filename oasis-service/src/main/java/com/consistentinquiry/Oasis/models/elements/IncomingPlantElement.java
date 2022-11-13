package com.consistentinquiry.Oasis.models.elements;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "A plant that can have jobs assigned to it ")
public class IncomingPlantElement {

  @ApiModelProperty("The name of this plant")
  private String name;

  @ApiModelProperty("The species of this plant")
  private String species;

  @ApiModelProperty("The url of the image of this plant")
  private String imageUrl;

  public IncomingPlantElement(){

  }

  public IncomingPlantElement(String name, String species, String imageUrl) {
    this.name = name;
    this.species = species;
    this.imageUrl = imageUrl;
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
    IncomingPlantElement that = (IncomingPlantElement) o;
    return name.equals(that.name) && species.equals(that.species)
           && imageUrl.equals(that.imageUrl);
  }

  @Override public int hashCode() {
    return Objects.hash(name, species, imageUrl);
  }

  @Override public String toString() {
    return "IncomingPlantElement{" + "name='" + name + '\'' + ", species='"
           + species + '\'' + ", imageUrl='" + imageUrl + '\'' + '}';
  }
}
