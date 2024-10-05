package Programming.Programming;

import java.util.*;

public class RegisteredInput {
    String athleteName, trainingPlan, category;
    int compe, tuition, choices;
    double kg;
    boolean validTrainingPlan;
    private Scanner scan;

    private static class WeightCategory {
        String name;
        double lowerLimit;
        double upperLimit;

        WeightCategory(String name, double lowerLimit, double upperLimit) {
            this.name = name;
            this.lowerLimit = lowerLimit;
            this.upperLimit = upperLimit;
        }
    }

    private List<WeightCategory> weightCategories;

    public RegisteredInput(Scanner scan) {
        this.scan = scan;
        initializeWeightCategories();

        System.out.println("");
        System.out.println("North Sussex Judo Registering Process");
        System.out.println("═════════════════════════════════════");

        enterAthleteName();
        enterTrainingPlan();
        enterCurrentWeight();
        enterWeightCategory();
        enterCompetitionsPerMonth();
        enterPrivateCoachingHours();
    }

    private void initializeWeightCategories() {
        weightCategories = new ArrayList<>();
        weightCategories.add(new WeightCategory("Flyweight", 0, 66));
        weightCategories.add(new WeightCategory("Lightweight", 66, 73));
        weightCategories.add(new WeightCategory("Light-Middleweight", 73, 81));
        weightCategories.add(new WeightCategory("Middleweight", 81, 90));
        weightCategories.add(new WeightCategory("Light-Heavyweight", 90, 100));
        weightCategories.add(new WeightCategory("Heavyweight", 100, Double.POSITIVE_INFINITY));
    }

    private void enterAthleteName() {
        while (true) {
            System.out.print("Enter Athlete's Name: ");
            athleteName = scan.nextLine();

            if (athleteName.matches("[A-Za-z. ]+") && athleteName.length() > 1) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid name.");
            }
        }
        System.out.println("");
    }

    private void enterTrainingPlan() {
        System.out.println("\t\t\t╔════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("\t\t\t║                                     Training Plan Prices                       ║");
        System.out.println("\t\t\t╠═════════════════════╦══════════════════════════════════════════════════════════╣");
        System.out.println("\t\t\t║      Plan Type      ║                  Weekly Fee ($)                          ║");
        System.out.println("\t\t\t╠═════════════════════╬══════════════════════════════════════════════════════════╣");
        System.out.println("\t\t\t║       Beginner      ║                     $ 25.00                              ║");
        System.out.println("\t\t\t║     Intermediate    ║                     $ 30.00                              ║");
        System.out.println("\t\t\t║        Elite        ║                     $ 35.00                              ║");
        System.out.println("\t\t\t╠═════════════════════╩══════════════════════════════════════════════════════════╣");
        System.out.println("\t\t\t\t\t(1 for Beginner, 2 for Intermediate, 3 for Elite)");
        do {
            System.out.print("Enter Training plan: ");
            String input = scan.nextLine();
            try {
                choices = Integer.parseInt(input);
                switch (choices) {
                    case 1:
                        trainingPlan = "beginner";
                        validTrainingPlan = true;
                        break;
                    case 2:
                        trainingPlan = "intermediate";
                        validTrainingPlan = true;
                        break;
                    case 3:
                        trainingPlan = "elite";
                        validTrainingPlan = true;
                        break;
                    default:
                        System.out.println("Invalid input. Please enter a valid number.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid input.");
            }
        } while (!validTrainingPlan);
        System.out.println("");
    }

    private void enterCurrentWeight() {
        while (true) {
            System.out.print("Enter Current Weight (in kg): ");
            String kgInput = scan.nextLine();

            try {
                kg = Double.parseDouble(kgInput);
                kg = Math.round(kg);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number. Thank you!");
            }
        }
        System.out.println();
    }

    private void displayWeightCategories() {
        System.out.println("\t\t\t╔════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("\t\t\t║          Weight Category             ║           Upper Weight Limit (kg)       ║");
        System.out.println("\t\t\t║======================================║=========================================║");
        for (WeightCategory category : weightCategories) {
            String upperLimit = category.upperLimit == Double.POSITIVE_INFINITY ? "Unlimited (over 100)"
                    : String.format("%.0f", category.upperLimit);
            System.out.printf("\t\t\t║ %-35s ║ %-40s ║%n", category.name, upperLimit);
        }
        System.out.println("\t\t\t══════════════════════════════════════════════════════════════════════════════════");
    }

    private void enterWeightCategory() {
        displayWeightCategories();

        while (true) {
            System.out.print("Enter Weight Category: ");
            category = scan.nextLine();

            if (category.matches("[A-Za-z -]+") && category.length() > 1) {
                WeightCategory selectedCategory = weightCategories.stream()
                        .filter(wc -> wc.name.equalsIgnoreCase(category))
                        .findFirst()
                        .orElse(null);

                if (selectedCategory != null && kg > selectedCategory.lowerLimit && kg <= selectedCategory.upperLimit) {
                    break;
                } else {
                    System.out.println("Invalid weight category for the given weight. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid weight category.");
            }
        }
        System.out.println("");
    }

    private void enterCompetitionsPerMonth() {
        if (!trainingPlan.equalsIgnoreCase("Beginner")) {
            System.out.println("Competition entry fee - $22.00 per competition");
            while (true) {
                System.out.print("Enter Competition Per Month: ");
                String compeInput = scan.nextLine();
                try {
                    compe = Integer.parseInt(compeInput);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number, Thank you!");
                }
            }
        }
        System.out.println("");
    }

    private void enterPrivateCoachingHours() {
        if (!trainingPlan.equalsIgnoreCase("Beginner")) {
            do {
                System.out.print("Do you want to avail Private Coaching Hours? (yes/no): ");
                String choice = scan.nextLine();
                if (choice.equalsIgnoreCase("yes")) {
                    do {
                        System.out.println("Private Coaching Hours - $9.00 per hour ");
                        System.out.print("Enter number of Private Coaching Hours: ");
                        String tuitionInput = scan.nextLine();
                        try {
                            tuition = Integer.parseInt(tuitionInput);
                            if (tuition <= 5 && tuition >= 1) {
                                break;
                            } else {
                                System.out.println("Maximum is 5 Hours Only!");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid number, Thank you!");
                        }
                    } while (true);
                    break;
                } else if (choice.equalsIgnoreCase("no")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'yes' or 'no', Thank you!");
                }
            } while (true);
        }
    }

    // Getters
    public String getAthleteName() {
        return athleteName;
    }

    public String getTrainingPlan() {
        return trainingPlan;
    }

    public double getKg() {
        return kg;
    }

    public String getCategory() {
        return category;
    }

    public int getCompe() {
        return compe;
    }

    public int getTuition() {
        return tuition;
    }
}
