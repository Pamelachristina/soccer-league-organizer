package com.teamtreehouse.model;

import java.util.List;

import static com.teamtreehouse.model.LeagueManager.players;

public class Roster {
    public static void displayRoster(Team team) {
        // Get players on the selected team
        Player[] teamPlayers = team.getPlayers().toArray(new Player[0]);

        // Display players and their stats
        if (teamPlayers.length == 0) {
            System.out.println("This team has no players.");
        } else {
            System.out.println("Team Roster:");
            System.out.println("==============================================================");

            System.out.printf("%-15s %-15s %-10s %-15s%n", "First Name", "Last Name", "Height", "Experience");
            System.out.println("==============================================================");


            for (Player player : teamPlayers) {
                System.out.printf("%-15s \u001B[34m%-15s\u001B[0m %-10d \u001B[32m%-10b\u001B[0m%n",
                        player.getFirstName(), player.getLastName(),
                        player.getHeightInInches(), player.isPreviousExperience());
            }

        }
    }
}

