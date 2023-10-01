import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter your weight in kilograms: ");
            double weight = scanner.nextDouble();
            
            System.out.print("Enter your height in meters: ");
            double height = scanner.nextDouble();
            
            if (weight <= 0 || height <= 0) {
                throw new IllegalArgumentException("Weight and height must be positive values.");
            }
            
            double bmi = calculateBMI(weight, height);
            System.out.println("Your BMI is: " + bmi);
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid numeric values.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
    
    public static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }
}
