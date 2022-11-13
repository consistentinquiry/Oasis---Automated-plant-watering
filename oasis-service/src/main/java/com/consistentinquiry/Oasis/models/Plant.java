package com.consistentinquiry.Oasis.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Plant {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String name;
  private String species;

  private String imageUrl;

  protected Plant(){

  }

  public Plant(String name, String species, String imageUrl) {
    this.name = name;
    this.species = species;
    this.imageUrl = imageUrl;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
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
    Plant plant = (Plant) o;
    return id == plant.id && name.equals(plant.name)
           && species.equals(plant.species) && imageUrl.equals(plant.imageUrl);
  }

  @Override public int hashCode() {
    return Objects.hash(id, name, species, imageUrl);
  }

  @Override public String toString() {
    return "Plant{" + "id=" + id + ", name='" + name + '\'' + ", species='"
           + species + '\'' + ", imageUrl='" + imageUrl + '\'' + '}';
  }
}
