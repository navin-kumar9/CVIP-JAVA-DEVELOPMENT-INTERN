import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private double totalFees;
    private double paidFees;

    public Student(int id, String name, double totalFees) {
        this.id = id;
        this.name = name;
        this.totalFees = totalFees;
        this.paidFees = 0.0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getTotalFees() {
        return totalFees;
    }

    public double getPaidFees() {
        return paidFees;
    }

    public void makePayment(double amount) {
        if (amount > 0 && paidFees + amount <= totalFees) {
            paidFees += amount;
            System.out.println("Payment of $" + amount + " received from " + name);
        } else {
            System.out.println("Invalid payment amount or exceeding total fees.");
        }
    }

    public double getRemainingFees() {
        return totalFees - paidFees;
    }

    @Override
    public String toString() {
        return "Student ID: " + id + ", Name: " + name + ", Total Fees: $" + totalFees + ", Paid Fees: $" + paidFees;
    }
}

public class FeesManagementSystem {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nFees Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Make Payment");
            System.out.println("3. View Student Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Total Fees: $");
                    double totalFees = scanner.nextDouble();

                    Student student = new Student(id, name, totalFees);
                    students.add(student);
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Student ID to make a payment: ");
                    int studentId = scanner.nextInt();
                    System.out.print("Enter Payment Amount: $");
                    double paymentAmount = scanner.nextDouble();

                    for (Student s : students) {
                        if (s.getId() == studentId) {
                            s.makePayment(paymentAmount);
                            System.out.println("Remaining Fees: $" + s.getRemainingFees());
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.println("Student Details:");
                    for (Student s : students) {
                        System.out.println(s);
                    }
                    break;

                case 4:
                    System.out.println("Exiting Fees Management System.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
