package Programming.Programming;

import java.util.*;

public class AthleteMain {
    public static void main(String[] args) {

        // Creating a Scanner object to read user input
        Scanner scan = new Scanner(System.in);

        // Creating an ArrayList to store ClassAthletes objects
        ArrayList<ClassAthletes> athletes = new ArrayList<>();

        // Creating an instance of LogoAthlete to display the application logo
        LogoAthlete logo = new LogoAthlete();
        // Printing the logo to the console
        logo.printLogo();

        // Creating an instance of ChoiceMainMenu with the Scanner and ArrayList of
        // athletes
        ChoiceMainMenu mainMenu = new ChoiceMainMenu(scan, athletes);
        // Displaying the main menu to the user
        mainMenu.displayMainMenu();

    }
}
