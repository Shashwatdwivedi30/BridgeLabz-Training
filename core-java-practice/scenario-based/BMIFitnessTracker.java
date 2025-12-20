// Maya’s BMI Fitness Tracker 🏃‍♀️
// Maya, a fitness coach, wants to record the BMI of her clients.
// ● Ask for height and weight.
// ● Use formula BMI = weight / (height * height)
// ● Print category using if-else: Underweight, Normal, Overweight.
// Use clear variable names and comments to maintain code hygiene.

import java.util.*;
public class BMIFitnessTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter weight in kgs: ");
        double weight = sc.nextDouble();
        System.out.println("Enter height in cm: ");
        double heightCm = sc.nextDouble();
        double heightM = heightCm / 100;                //Convert cm to meter
        double bmi = weight / (heightM * heightM);      //Calculation of BMI
        System.out.println("BMI: " + bmi);
        //Printing category using if-else
        if (bmi <= 18.4) {
            System.out.println("Status: Underweight");
        } else if (bmi <= 24.9) {
            System.out.println("Status: Normal");
        } else if (bmi <= 39.9) {
            System.out.println("Status: Overweight");
        } else {
            System.out.println("Status: Obese");
        }
    }
}
