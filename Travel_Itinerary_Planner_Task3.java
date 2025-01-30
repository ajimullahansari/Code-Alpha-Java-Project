import java.util.ArrayList;
import java.util.Scanner;

class Destination {
    private String name;
    private int days;
    private double dailyBudget;

    public Destination(String name, int days, double dailyBudget) {
        this.name = name;
        this.days = days;
        this.dailyBudget = dailyBudget;
    }

    public String getName() {
        return name;
    }

    public int getDays() {
        return days;
    }

    public double getDailyBudget() {
        return dailyBudget;
    }

    @Override
    public String toString() {
        return "Destination: " + name + ", Days: " + days + ", Daily Budget: Rupees:: " + dailyBudget;
    }
}

public class Travel_Itinerary_Planner_Task3 {
    private ArrayList<Destination> itinerary;

    public Travel_Itinerary_Planner_Task3() {
        itinerary = new ArrayList<>();
    }

    public void addDestination(String name, int days, double dailyBudget) {
        Destination destination = new Destination(name, days, dailyBudget);
        itinerary.add(destination);
    }

    public void displayItinerary() {
        System.out.println("Your Travel Itinerary:");
        for (Destination destination : itinerary) {
            System.out.println(destination);
        }
    }

    public double calculateTotalBudget() {
        double totalBudget = 0;
        for (Destination destination : itinerary) {
            totalBudget += destination.getDays() * destination.getDailyBudget();
        }
        return totalBudget;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Travel_Itinerary_Planner_Task3 planner = new Travel_Itinerary_Planner_Task3();

        while (true) {
            System.out.println( "================================================");
            System.out.println("Enter destination name:> (or 'exit' to finish): ");
            System.out.println( "================================================");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Enter number of days: ");
            int days = scanner.nextInt();

            System.out.println("Enter daily budget: ");
            double dailyBudget = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            planner.addDestination(name, days, dailyBudget);
        }

        planner.displayItinerary();
        System.out.println( "=====================================================");
        System.out.println("Total Budget: Rupees " + planner.calculateTotalBudget());
        System.out.println( "======================================================");
    }
}