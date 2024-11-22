package com.teamtreehouse.model;

import java.util.*;

public class TeamHeightReport {
    public static void generateReport(Team team) {
        if (team.getPlayers().isEmpty()) {
            System.out.printf("\u001B[31mTeam '%s' has no players.%n\u001B[0m", team.getTeamName());
            return;
        }

        // Group players by height ranges
        Map<String, List<Player>> heightGroups = new LinkedHashMap<>();
        heightGroups.put("35–40 inches", new ArrayList<>());
        heightGroups.put("41–46 inches", new ArrayList<>());
        heightGroups.put("47+ inches", new ArrayList<>());

        for (Player player : team.getPlayers()) {
            int height = player.getHeightInInches();
            if (height >= 35 && height <= 40) {
                heightGroups.get("35–40 inches").add(player);
            } else if (height >= 41 && height <= 46) {
                heightGroups.get("41–46 inches").add(player);
            } else if (height >= 47) {
                heightGroups.get("47+ inches").add(player);
            }
        }

        // Display the height report in a column format
        System.out.printf("\u001B[36mHeight Report for Team '%s':\n\u001B[0m", team.getTeamName());
        System.out.println("\u001B[37m==============================================================\u001B[0m");

        // Iterate over height groups and display sorted players
        for (Map.Entry<String, List<Player>> entry : heightGroups.entrySet()) {
            String range = entry.getKey();
            List<Player> playersInRange = entry.getValue();

            System.out.printf("\n\u001B[36mHeight Range: %s\u001B[0m\n", range);
            System.out.println("\u001B[37m========================================================\u001B[0m");
            System.out.printf("%-15s %-15s %-10s %-15s%n", "First Name", "Last Name", "Height", "Experience");
            System.out.println("==================================================================");

            if (playersInRange.isEmpty()) {
                System.out.printf("%-15s \u001B[31mNo players in this range.\u001B[0m%n", "");
            } else {
                // Sort players alphabetically by last name
                playersInRange.sort(Comparator.comparing(Player::getLastName));

                // Display players in column format
                for (Player player : playersInRange) {
                    System.out.printf("%-15s \u001B[34m%-15s\u001B[0m %-10d %-10b%n",
                            player.getFirstName(),
                            player.getLastName(),
                            player.getHeightInInches(),
                            player.isPreviousExperience());
                }
            }
        }
    }
}
