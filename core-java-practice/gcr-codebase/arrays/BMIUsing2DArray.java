import java.util.Scanner;

public class BMIUsing2DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of persons:");
        int number = sc.nextInt();

        // Multi-dimensional array:
        // column 0 -> Height (meters)
        // column 1 -> Weight (kg)
        // column 2 -> BMI
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];
        for (int i = 0; i < number; i++) {
            System.out.println("\nPerson " + (i + 1));

            // Height input
            do {
                System.out.print("Enter height (in meters): ");
                personData[i][0] = sc.nextDouble();
                if (personData[i][0] <= 0) {
                    System.out.println("Height must be positive. Please re-enter.");
                }
            } while (personData[i][0] <= 0);

            // Weight input
            do {
                System.out.print("Enter weight (in kg): ");
                personData[i][1] = sc.nextDouble();
                if (personData[i][1] <= 0) {
                    System.out.println("Weight must be positive. Please re-enter.");
                }
            } while (personData[i][1] <= 0);
        }

        for (int i = 0; i < number; i++) {
            double height = personData[i][0];
            double weight = personData[i][1];

            personData[i][2] = weight / (height * height); // BMI calculation

            if (personData[i][2] <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (personData[i][2] <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1));
            System.out.println("Height: " + personData[i][0] + " m");
            System.out.println("Weight: " + personData[i][1] + " kg");
            System.out.printf("BMI: %.2f\n", personData[i][2]);
            System.out.println("Status: " + weightStatus[i]);
            System.out.println();
        }
        sc.close();
    }
}
