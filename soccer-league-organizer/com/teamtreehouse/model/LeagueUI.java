package com.teamtreehouse.model;

public class LeagueUI {
    // Method to display the main menu
    public static void displayMenu () {
        System.out.println("Main Menu:");
        System.out.println("1. Create Team");
        System.out.println("2. Add Player");
        System.out.println("3. Remove Player");
        System.out.println("4. Display League Balance Report");
        System.out.println("5. View Roster");
        System.out.println("6. Exit");
        System.out.println();
    }


    public static void displayWelcomeBanner() throws InterruptedException {
        // Array of banner lines to animate
        String[] banner = {
                "\u001B[32m" + "==============================================",
                " ⚽️ Welcome to the Soccer League Organizer ⚽️",
                "==============================================",
                "  Let's get started organizing your league!      " + "\u001B[0m"
        };

        // Print each line with a delay
        for (String line : banner) {
            System.out.println(line);
            Thread.sleep(900); // Wait for 500 milliseconds (half a second)
        }
        System.out.println(); // Add a blank line after the banner
    }

}
