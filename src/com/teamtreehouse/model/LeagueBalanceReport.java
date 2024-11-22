package com.teamtreehouse.model;

import java.util.*;

public class LeagueBalanceReport {
    public static void generateReport(Set<Team> teams) {
        // Map to store experienced and inexperienced player counts for each team
        Map<Team, Map<String, Integer>> reportData = new LinkedHashMap<>();

        // Iterate through all teams to calculate player counts
        for (Team team : teams) {
            int experienced = 0;
            int inexperienced = 0;

            for (Player player : team.getPlayers()) {
                if (player.isPreviousExperience()) {
                    experienced++;
                } else {
                    inexperienced++;
                }
            }

            // Store the counts in a nested map
            Map<String, Integer> counts = new LinkedHashMap<>();
            counts.put("Experienced", experienced);
            counts.put("Inexperienced", inexperienced);

            reportData.put(team, counts);
        }

        // Display the report
        for (Map.Entry<Team, Map<String, Integer>> entry : reportData.entrySet()) {
            Team team = entry.getKey();
            Map<String, Integer> counts = entry.getValue();

            // Format and display the data
            System.out.printf("\u001B[36m%-20s\u001B[0m \u001B[32m%-10d\u001B[0m \u001B[33m%-10d\u001B[0m%n",
                    team.getTeamName(),
                    counts.get("Experienced"),
                    counts.get("Inexperienced"));
        }
    }
}
