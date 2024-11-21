package com.teamtreehouse.model;

import java.io.Serializable;
import java.util.Objects;

public class Player implements Comparable<Player>, Serializable {
  private static final long serialVersionUID = 1L;

  private String firstName;
  private String lastName;
  private int heightInInches;
  private boolean previousExperience;

  public Player(String firstName, String lastName, int heightInInches, boolean previousExperience) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.heightInInches = heightInInches;
    this.previousExperience = previousExperience;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getHeightInInches() {
    return heightInInches;
  }

  public boolean isPreviousExperience() {
    return previousExperience;
  }

  @Override
  public int compareTo(Player other) {
    // Compare by last name, then by first name, then by height
    int lastNameComparison = this.lastName.compareTo(other.lastName);
    if (lastNameComparison != 0) {
      return lastNameComparison;
    }

    int firstNameComparison = this.firstName.compareTo(other.firstName);
    if (firstNameComparison != 0) {
      return firstNameComparison;
    }

    return Integer.compare(this.heightInInches, other.heightInInches);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Player)) return false;

    Player player = (Player) o;

    return firstName.equals(player.firstName) && lastName.equals(player.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName); // Use only firstName and lastName for hashCode
  }

  @Override
  public String toString() {
    return firstName + " " + lastName;
  }
}