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
  private int age;

  protected Plant(){

  }

  public Plant(String name, String species, int age) {
    this.name = name;
    this.species = species;
    this.age = age;
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

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Plant plant = (Plant) o;
    return id == plant.id && age == plant.age && name.equals(plant.name)
           && species.equals(plant.species);
  }

  @Override
  public String toString() {
    return "Plant{" + "id=" + id + ", name='" + name + '\'' + ", species='"
           + species + '\'' + ", age=" + age + '}';
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, species, age);
  }
}
