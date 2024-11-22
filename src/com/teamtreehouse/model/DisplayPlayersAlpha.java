package com.teamtreehouse.model;

import java.util.Arrays;

public class DisplayPlayersAlpha {
    public static void displayPlayers(Player[] players) {
        // sort players alphabetically
        Arrays.sort(players);

        // Display header
        System.out.println("Available Players (Alphabetical Order):");
        System.out.println("------------------------------------------------");
        System.out.printf("%-15s %-15s %-10s %-10s%n", "First Name", "Last Name", "Height", "Experience");
        System.out.println("------------------------------------------------");


        // display players
        for (int i = 0; i < players.length; i++) {
            Player player = players[i];
            System.out.printf("%d. %-15s \u001B[34m%-15s\u001B[0m %-10d %-10b%n",
                                i + 1, // number for user display
                                player.getFirstName(),
                                player.getLastName(),
                                player.getHeightInInches(),
                                player.isPreviousExperience());
        }

    }
}
