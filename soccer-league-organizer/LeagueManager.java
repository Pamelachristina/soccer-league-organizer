import com.teamtreehouse.model.LeagueUI;
import com.teamtreehouse.model.Player;
import com.teamtreehouse.model.Players;
import com.teamtreehouse.model.Team;


import static com.teamtreehouse.model.LeagueUI.displayMenu;


import java.util.*;


public class LeagueManager {
    private static Set<Team> teams = new TreeSet<>(); // To store all teams
    private static Scanner scanner = new Scanner(System.in); // Shared scanner

    public static void main(String[] args) throws InterruptedException {
        Player[] players = Players.load();
        try {
            LeagueUI.displayWelcomeBanner();
        } catch (InterruptedException e) {
            System.out.println("Animation interrupted!");
        }

        System.out.println("##==##==##==##==##==##==##==##==##==##==##==##");
        Thread.sleep(500); // Wait for 500ms before the next line
        System.out.printf("There are currently %d registered players.%n", players.length);
        Thread.sleep(600);
        System.out.println("##==##==##==##==##==##==##==##==##==##==##==##\n\n");
        Thread.sleep(1150);
        // Your code here!
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
                    System.out.println("TODO: view league report");
                    break;

                case "5":
                    System.out.println("TODO: Roster");
                    break;

                case "6":
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
        // Display teams
        displayTeams();

        // Prompt for team selection
        System.out.print("Select a team by number: ");
        int teamNumber = scanner.nextInt();
        scanner.nextLine();

        if (teamNumber < 1 || teamNumber > teams.size()) {
            System.out.println("Invalid team selection.");
            return; // Exit if invalid selection
        }

        // Convert Set to List for indexed access
        Team selectedTeam = new ArrayList<>(teams).get(teamNumber - 1);

        // Prompt for player details
        System.out.print("Enter player's first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter player's last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter player's height (in inches): ");
        int heightInInches = scanner.nextInt();

        System.out.print("Enter player's age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.printf("Does %s %s have any soccer experience (true/false)? ", firstName, lastName);
        boolean previousExperience = scanner.nextBoolean();
        scanner.nextLine();

        // Create and add the player
        Player newPlayer = new Player(firstName, lastName, heightInInches, previousExperience);
        boolean added = selectedTeam.addPlayer(newPlayer);

        if (added) {
            System.out.printf("Player %s %s has been added to team '%s'.%n",
                    firstName, lastName, selectedTeam.getTeamName());
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

    /**
     * Removes a player from the team.
     */
    private static void removePlayerFromTeam() {
        displayTeams();

        System.out.print("Select a team by number: ");
        int teamNumber = scanner.nextInt();
        scanner.nextLine();

        if (teamNumber < 1 || teamNumber > teams.size()) {
            System.out.println("Invalid team selection.");
            return;
        }

        // Get the selected team
        Team selectedTeam = new ArrayList<>(teams).get(teamNumber - 1);


        // Prompt for player's name
        System.out.print("Enter player's first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter player's last name: ");
        String lastName = scanner.nextLine();

        // Create a player object with minimal info for removal
        Player playerToRemove = new Player(firstName, lastName, 0, false);

        // Attempt to remove the player
        boolean removed = selectedTeam.getPlayers().remove(playerToRemove);
        if (removed) {
            System.out.printf("Player %s %s has been removed from team '%s'.%n",
                    firstName, lastName, selectedTeam.getTeamName());
        } else {
            System.out.printf("Player %s %s was not found in team '%s'.%n",
                    firstName, lastName, selectedTeam.getTeamName());
        }




    }
}










