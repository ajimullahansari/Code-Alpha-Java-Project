import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Student_Grade_Tracker_Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> studentGrades = new HashMap<>();
        ArrayList<Double> grades = new ArrayList<>();

        while (true) {
            try {
                System.out.println("1. Add Student Grade");
                System.out.println("2. View All Grades");
                System.out.println("3. Compute Average, Highest, and Lowest Grades");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int option = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (option == 1) {
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student grade: ");
                    double grade = scanner.nextDouble();
                    studentGrades.put(name, grade);
                    grades.add(grade);
                    System.out.println("Grade added successfully!");
                } else if (option == 2) {
                    System.out.println("Student Grades:");
                    for (Map.Entry<String, Double> entry : studentGrades.entrySet()) {
                        System.out.println("Name: " + entry.getKey() + ", Grade: " + entry.getValue());
                    }
                } else if (option == 3) {
                    if (grades.isEmpty()) {
                        System.out.println("No grades available to compute statistics.");
                    } else {
                        double sum = 0;
                        double highest = Double.MIN_VALUE;
                        double lowest = Double.MAX_VALUE;

                        for (double grade : grades) {
                            sum += grade;
                            if (grade > highest) {
                                highest = grade;
                            }
                            if (grade < lowest) {
                                lowest = grade;
                            }
                        }

                        double average = sum / grades.size();
                        System.out.println("Average Grade: " + average);
                        System.out.println("Highest Grade: " + highest);
                        System.out.println("Lowest Grade: " + lowest);
                    }
                } else if (option == 4) {
                    break;
                } else {
                    System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine(); // Consume newline
            }
            System.out.println("1. Add Student Grade");
            System.out.println("2. View All Grades");
            System.out.println("3. Compute Average, Highest, and Lowest Grades");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (option == 1) {
                System.out.print("Enter student name: ");
                String name = scanner.nextLine();
                System.out.print("Enter student grade: ");
                double grade = scanner.nextDouble();
                studentGrades.put(name, grade);
                grades.add(grade);
                System.out.println("Grade added successfully!");
            } else if (option == 2) {
                System.out.println("Student Grades:");
                for (Map.Entry<String, Double> entry : studentGrades.entrySet()) {
                    System.out.println("Name: " + entry.getKey() + ", Grade: " + entry.getValue());
                }
            } else if (option == 3) {
                if (grades.isEmpty()) {
                    System.out.println("No grades available to compute statistics.");
                } else {
                    double sum = 0;
                    double highest = Double.MIN_VALUE;
                    double lowest = Double.MAX_VALUE;

                    for (double grade : grades) {
                        sum += grade;
                        if (grade > highest) {
                            highest = grade;
                        }
                        if (grade < lowest) {
                            lowest = grade;
                        }
                    }

                    double average = sum / grades.size();
                    System.out.println("Average Grade: " + average);
                    System.out.println("Highest Grade: " + highest);
                    System.out.println("Lowest Grade: " + lowest);
                }
            } else if (option == 4) {
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}