package com.teamtreehouse.model;

public class LeagueUI {
    // Method to display the main menu
    public static void displayMenu () {
        System.out.println("\nMain Menu:");
        System.out.println("===================================");
        System.out.println(" 1. 🏟️  Create a Team");
        System.out.println(" 2. 🏃  Add a Player to a Team");
        System.out.println(" 3. ❌  Remove a Player from a Team");
        System.out.println(" 4. 📊  View League Balance Report");
        System.out.println(" 5. 📝  View Team Roster");
        System.out.println(" 6. 📏  View Team Height Report");
        System.out.println(" 7. Exit");
        System.out.println("===================================");

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
