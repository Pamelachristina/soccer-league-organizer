package com.teamtreehouse.model;

import java.io.Serializable;


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

    return heightInInches == player.heightInInches &&
            previousExperience == player.previousExperience &&
            firstName.equals(player.firstName) &&
            lastName.equals(player.lastName);

  }

  @Override
  public int hashCode() {
    int result = firstName.hashCode();
    result = 31 * result + lastName.hashCode();
    result = 31 * result + heightInInches;
    result = 31 * result + (previousExperience ? 1 : 0);
    return result;
  }

  @Override
  public String toString() {
    return firstName + " " + lastName;
  }
}
