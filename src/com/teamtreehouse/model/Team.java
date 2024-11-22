package com.teamtreehouse.model;

import java.util.*;

public class Team implements Comparable<Team> {
    private String teamName;
    private String coachName;
    private Set<Player> players; // Each team has its own set of players

    public Team(String teamName, String coachName) {
        this.teamName = teamName;
        this.coachName = coachName;
        this.players = new TreeSet<>(); // Initialize players set
    }

    public String getTeamName() {
        return teamName;
    }

    public String getCoachName() {
        return coachName;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    /**
     * Factory method to create a new Team using user input.
     */
    public static Team createTeam(Scanner scanner) {
        System.out.print("Enter the team name: ");
        String teamName = scanner.nextLine();

        System.out.print("Enter the coach's name: ");
        String coachName = scanner.nextLine();

        System.out.printf("Team '%s' with Coach '%s' has been created.%n", teamName, coachName);
        return new Team(teamName, coachName);
    }

    /**
     * Adds a player to the team.
     */
    public boolean addPlayer(Player player) {
        // Check if the team already has 11 players
        if (players.size() >= 11) {
            System.out.printf("Cannot add player %s %s. Team '%s' already has 11 players.%n",
                    player.getFirstName(), player.getLastName(), teamName);
            return false;
        }

        boolean added = players.add(player);
        if (!added) {
            System.out.println("Duplicate player not added: " + player.getFirstName() + " " + player.getLastName());
        }
        return added;
    }

    /**
     * Removes a player from the team.
     */
    public boolean removePlayer(Player player) {
        boolean removed = players.remove(player); // Use Set's remove method
        return removed;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;
        return Objects.equals(teamName, team.teamName) &&
                Objects.equals(coachName, team.coachName) &&
                Objects.equals(players, team.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamName, coachName, players);
    }

    @Override
    public String toString() {
        return String.format("Team Name: %s, Coach: %s, Players: %d",
                teamName, coachName, players.size());
    }

    @Override
    public int compareTo(Team other) {
        return this.teamName.compareTo(other.teamName);
    }
}








