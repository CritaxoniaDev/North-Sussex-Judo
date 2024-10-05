package Programming.Programming;

import java.util.*;

public class ChoiceMainMenu {

    // Scanner object for user input
    private Scanner scan;

    // ArrayList to store athletes' data
    private ArrayList<ClassAthletes> athletes;

    // Constructor to initialize the scanner and athletes' ArrayList
    public ChoiceMainMenu(Scanner scan, ArrayList<ClassAthletes> athletes) {
        this.scan = scan;
        this.athletes = athletes;
    }

    // Method to display the main menu and handle user choices
    public void displayMainMenu() {
        int choiceOption;

        // Loop to continuously display the main menu until the user chooses to exit
        while (true) {
            // Displaying the main menu options
            System.out.println("\t\t\t\t\t\t\tWELCOME TO NORTH SUSSEX JUDO TRAINING CENTER");
            System.out.println(
                    "\t\t\t\t\t* ═══════════════════════════════════════════════════════════════════════════ *");
            System.out
                    .println("\t\t\t\t\t  |                              MAIN MENU                                  |");
            System.out
                    .println("\t\t\t\t\t  |                                                                         |");
            System.out.println(
                    "\t\t\t\t\t* =========================================================================== *");
            System.out
                    .println("\t\t\t\t\t  |                           1.  Add an Athlete                            |");
            System.out
                    .println("\t\t\t\t\t  ---------------------------------------------------------------------------");
            System.out
                    .println("\t\t\t\t\t  |                           2. View Athlete data                          |");
            System.out
                    .println("\t\t\t\t\t  ---------------------------------------------------------------------------");
            System.out
                    .println("\t\t\t\t\t  |                           3.     Exit                                   |");
            System.out.println(
                    "\t\t\t\t\t* ═══════════════════════════════════════════════════════════════════════════ *");

            // Inner loop to handle user input for menu choice
            while (true) {
                try {
                    System.out.print("Enter your choice: ");
                    choiceOption = Integer.parseInt(scan.nextLine());
                    System.out.println("");
                    // Validating the user's choice to be within the menu options
                    if (choiceOption >= 1 && choiceOption <= 3) {
                        break;
                    } else {
                        System.out.println("Please only enter 1 to 3. Thank you!");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number. Thank you!");
                }
            }

            // Handling the user's choice
            if (choiceOption == 1) {
                // Creating a new RegisteredInput object to get athlete details
                RegisteredInput registeredInput = new RegisteredInput(scan);
                String name, plan, category;
                int compe, tuition;
                double kg;

                // Getting athlete details from the user
                name = registeredInput.getAthleteName();
                plan = registeredInput.getTrainingPlan();
                kg = registeredInput.getKg();
                category = registeredInput.getCategory();
                compe = registeredInput.getCompe();
                tuition = registeredInput.getTuition();

                // Creating a new ClassAthletes object with the provided details
                ClassAthletes athlete = new ClassAthletes(name, plan, kg, category, compe, tuition);
                athletes.add(athlete);
                System.out.println("\n+----------------------------------+");
                System.out.println("|    Athlete added to the data    |");
                System.out.println("+----------------------------------+\n");

            } else if (choiceOption == 2) {
                // Checking if there are any athletes registered
                if (athletes.isEmpty()) {
                    System.out.println("No Athletes Registered Yet. Thank you!");
                } else {
                    // Displaying details of all registered athletes
                    for (ClassAthletes athlete : athletes) {
                        System.out.println(athlete);
                        System.out.println("");
                    }
                }
            } else {
                // Exiting the application
                System.out.println("\n\nWe appreciate your registering in North Sussex Judo. Have a Good Day!\n\n");
                break;
            }
        }
    }
}