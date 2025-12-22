import java.util.Scanner;

public class BMICalculator {

    // Method to compute BMI and return BMI and status as String array
    public static String[] computeBMI(double weight, double heightCm) {
        double heightM = heightCm / 100.0; // convert cm to meters
        double bmi = weight / (heightM * heightM);
        bmi = Math.round(bmi * 100.0) / 100.0; // round to 2 decimals

        String status;
        if (bmi <= 18.4) status = "Underweight";
        else if (bmi <= 24.9) status = "Normal";
        else if (bmi <= 39.9) status = "Overweight";
        else status = "Obese";
        return new String[]{String.valueOf(bmi), status};
    }

    // Method to process all persons and return 2D array of height, weight, BMI, status
    public static String[][] processBMI(double[][] data) {
        int n = data.length;
        String[][] result = new String[n][4];
        for (int i = 0; i < n; i++) {
            double weight = data[i][0];
            double height = data[i][1];
            String[] bmiData = computeBMI(weight, height);
            result[i][0] = String.valueOf(height);
            result[i][1] = String.valueOf(weight);
            result[i][2] = bmiData[0];
            result[i][3] = bmiData[1];
        }
        return result;
    }

    // Method to display the 2D array in tabular format
    public static void displayBMI(String[][] data) {
        System.out.println("Height(cm)\tWeight(kg)\tBMI\tStatus");
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1] + "\t\t" + data[i][2] + "\t" + data[i][3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 10;
        double[][] personData = new double[n][2]; // column 0: weight, column 1: height

        // Take input for 10 persons
        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1) + ":");
            System.out.print("Enter weight (kg): ");
            personData[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm): ");
            personData[i][1] = sc.nextDouble();
        }
        String[][] bmiResults = processBMI(personData);
        displayBMI(bmiResults);
        sc.close();
    }
}
