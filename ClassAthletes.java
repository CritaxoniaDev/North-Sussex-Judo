package Programming.Programming;

class ClassAthletes {

    // Member variables to store athlete's information
    private String athleteName;

    private String trainingPlan;

    private double kg;

    private String category;

    private int compe;

    private int tuition;

    // Constructor to initialize athlete's information
    public ClassAthletes(String athleteName, String trainingPlan, double kg, String category, int compe, int tuition) {

        this.athleteName = athleteName;

        this.trainingPlan = trainingPlan;

        this.kg = kg;

        this.category = category;

        this.compe = compe;

        this.tuition = tuition;
    }

    // Method to calculate the total tuition cost
    public double Gettuitioncost() {
        return 9.00d * 4.00 * tuition;
    }

    // Method to calculate the total training plan cost
    public double GettrainingPlancost() {
        String plan = trainingPlan.toLowerCase();
        if ("beginner".equals(plan)) {
            return 25.00 * 4;
        } else if ("intermediate".equals(plan)) {
            return 30.00 * 4;
        } else if ("elite".equals(plan)) {
            return 35.00 * 4;
        } else {
            return 0;
        }
    }

    // Method to calculate the total cost of competitions
    public double GetCostCompetition() {
        if (trainingPlan.equalsIgnoreCase("Intermediate") || trainingPlan.equalsIgnoreCase("Elite")) {
            return 22.00 * compe;
        } else {
            return 0.00;
        }
    }

    // Method to calculate the total cost including all expenses
    public double GettotalCost() {
        double trainingFee = GettrainingPlancost();
        double competitionFee = GetCostCompetition();
        double tuitionFee = Gettuitioncost();
        return trainingFee + competitionFee + tuitionFee;
    }

    // Method to represent athlete's information and cost as a string
    @Override
    public String toString() {

        return "\n════════════════════════════════════════════════════════════════════════════════" +
                "\n║ Athlete's Information:                                                        ║" +
                "\n════════════════════════════════════════════════════════════════════════════════" +
                "\nName                     : " + athleteName +
                "\nTraining Plan            : " + trainingPlan +
                "\nCurrent Weight           : " + kg +
                "\nWeight Category          : " + category +
                "\nCompetition per Month    : " + compe +
                "\nPrivate Coaching         : " + tuition +
                "\n════════════════════════════════════════════════════════════════════════════════" +
                "\n════════════════════════════════════════════════════════════════════════════════" +
                "\n║ Athlete's Cost of the Month:                                                  ║" +
                "\n════════════════════════════════════════════════════════════════════════════════" +
                "\nCalculated Training Plan  : $" + String.format("%.2f", GettrainingPlancost()) +
                "\nCalculated Competition Fee: $" + String.format("%.2f", GetCostCompetition()) +
                "\nCalculated Private Hours  : $" + String.format("%.2f", Gettuitioncost()) +
                "\n--------------------------------------------------------------------------------" +
                "\nTotal Cost                : $" + String.format("%.2f", GettotalCost()) +
                "\n════════════════════════════════════════════════════════════════════════════════";
    }
}
