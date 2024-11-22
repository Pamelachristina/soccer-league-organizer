package com.teamtreehouse.model;

import java.util.*;

import static com.teamtreehouse.model.LeagueUI.displayMenu;


public class LeagueManager {
    private static Set<Team> teams = new TreeSet<>(); // To store all teams
    static Player[] players = Players.load(); // Load all players
    private static Scanner scanner = new Scanner(System.in); // Shared scanner

    public static void main(String[] args) throws InterruptedException {
        try {
            LeagueUI.displayWelcomeBanner();
        } catch (InterruptedException e) {
            System.out.println("Animation interrupted!");
        }

        System.out.println("🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃");
        Thread.sleep(500); // Wait for 500ms before the next line
        System.out.printf("There are currently %d registered players.%n", players.length);
        Thread.sleep(600);
        System.out.println("🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃🏃\n\n");
        Thread.sleep(1150);

        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("Please select an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    Team newTeam = Team.createTeam(scanner);
                    teams.add(newTeam);
                    System.out.println("Team added to the league.");
                    break;

                case "2":
                    if (teams.isEmpty()) {
                        System.out.println("No teams available to add players. Create a team first.");
                    } else {
                        addPlayerToTeam();
                    }
                    break;

                case "3":
                    removePlayerFromTeam();
                    break;

                case "4":
                    displayLeagueBalanceReport();
                    break;

                case "5":
                    displayTeamRoster();
                    break;

                case "6":
                    displayTeamHeightReport();
                    break;

                case "7":
                    System.out.println("Quit - Exiting program...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        }

        scanner.close();
    }

    private static void addPlayerToTeam() {
        displayTeams();

        System.out.print("Select a team by number: ");
        int teamNumber = scanner.nextInt();
        scanner.nextLine();

        if (teamNumber < 1 || teamNumber > teams.size()) {
            System.out.println("Invalid team selection.");
            return;
        }

        Team selectedTeam = new ArrayList<>(teams).get(teamNumber - 1);

        // Convert Player[] to List<Player>
        List<Player> playerList = new ArrayList<>(Arrays.asList(players));
        DisplayPlayersAlpha.displayPlayers(playerList.toArray(new Player[0])); // Display players alphabetically

        System.out.print("Enter the number of the player to add: ");
        int playerNumber = scanner.nextInt();
        scanner.nextLine();

        if ((playerNumber < 1) || (playerNumber > players.length)) {
            System.out.println("Invalid player selection.");
            return;
        }

        Player selectedPlayer = players[playerNumber - 1];
        if (selectedTeam.addPlayer(selectedPlayer)) {
            System.out.printf("Player %s %s has been added to team '%s'.%n",
                    selectedPlayer.getFirstName(),
                    selectedPlayer.getLastName(),
                    selectedTeam.getTeamName());

            }
        }

    private static void displayTeams() {
        if (teams.isEmpty()) {
            System.out.println("No teams have been created yet.");
        } else {
            System.out.println("Teams in the League:");
            int count = 1;
            for (Team team : teams) {
                System.out.printf("%d. %s%n", count++, team);
            }
        }
    }

    private static void removePlayerFromTeam() {
        displayTeams();

        System.out.print("Select a team by number: ");
        int teamNumber = scanner.nextInt();
        scanner.nextLine();

        if (teamNumber < 1 || teamNumber > teams.size()) {
            System.out.println("Invalid team selection.");
            return;
        }

        Team selectedTeam = new ArrayList<>(teams).get(teamNumber - 1);

        Player[] teamPlayers = selectedTeam.getPlayers().toArray(new Player[0]);
        DisplayPlayersAlpha.displayPlayers(teamPlayers);

        System.out.print("Enter the number of the player to remove: ");
        int playerNumber = scanner.nextInt();
        scanner.nextLine();

        if (playerNumber < 1 || playerNumber > teamPlayers.length) {
            System.out.println("Invalid player selection.");
            return;
        }

        Player selectedPlayer = teamPlayers[playerNumber - 1];
        if (selectedTeam.removePlayer(selectedPlayer)) {
            System.out.printf("Player %s %s has been removed from team '%s'.%n",
                    selectedPlayer.getFirstName(),
                    selectedPlayer.getLastName(),
                    selectedTeam.getTeamName());
        } else {
            System.out.printf("\\u001B[33mWarning: Player %s %s was not found in team '%s'.%n\\u001B[0m",
                    selectedPlayer.getFirstName(),
                    selectedPlayer.getLastName(),
                    selectedTeam.getTeamName());
        }
    }


    private static void displayTeamRoster() {
        // Display all teams
        displayTeams();

        // Prompt for team selection
        System.out.print("Select a team by number to view its roster: ");
        int teamNumber = scanner.nextInt();
        scanner.nextLine();

        // Validate the team number
        if (teamNumber < 1 || teamNumber > teams.size()) {
            System.out.println("\\u001B[31mError: Invalid team selection.\\u001B[0m");
            return;
        }

        // Get the selected team
        Team selectedTeam = new ArrayList<>(teams).get(teamNumber - 1);

        // Use Roster class to display team roster
        Roster.displayRoster(selectedTeam);


    }


    private static void displayLeagueBalanceReport() {
        if (teams.isEmpty()) {
            System.out.println("\u001B[33mWarning: No teams available. Create teams first.\u001B[0m");
            return;
        }

        System.out.println("\u001B[36mLeague Balance Report:\u001B[0m");
        System.out.println("==================================================");
        System.out.printf("%-20s %-10s %-10s%n", "Team Name", "Experienced", "Inexperienced");
        System.out.println("==================================================");

        // Delegate the report generation to the LeagueBalanceReport class
        LeagueBalanceReport.generateReport(teams);
    }




    private static void displayTeamHeightReport() {
        // Display all teams
        displayTeams();

        // Prompt for team selection
        System.out.print("Select a team by number to view its height report: ");
        int teamNumber = scanner.nextInt();
        scanner.nextLine();

        // Validate team selection
        if (teamNumber < 1 || teamNumber > teams.size()) {
            System.out.println("Invalid team selection.");
            return;
        }

        // Get the selected team
        Team selectedTeam = new ArrayList<>(teams).get(teamNumber - 1);

        // Generate and display the height report
        TeamHeightReport.generateReport(selectedTeam);
    }




}











