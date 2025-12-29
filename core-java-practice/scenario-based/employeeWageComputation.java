import java.util.Scanner;
public class employeeWageComputation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Employee Wage Computation Program");

        // User Case 1 (Checking employee is Present or Absent)
        int attendance = (int)(Math.random() * 2);
        if (attendance == 1) {
            System.out.println("Employee is Present");

            // User Case 4 (Switch Case Statement)
            System.out.println("Enter weather the Employee is full time or part time");
            String typeOfEmp = sc.next();
            int wagePerHour = 20;
            int workingDayPerMonth = 20;

            int totalHours = 0;
            int totalDays = 0;
            int maxHours = 100;

            switch(typeOfEmp) {
                case "fullTime": {
                    // User Case 2 (Calculating Daily Employee Wage)
                    int fullDayHour = 8;

                    //User Case 6 (Checking conditions of total working hours & days)
                    while (totalHours < maxHours && totalDays < workingDayPerMonth) {
                        totalDays++;
                        totalHours += fullDayHour;
                    }

                    int totalWage = totalHours * wagePerHour;
                    System.out.println("Total Working Days: " + totalDays);
                    System.out.println("Total Working Hours: " + totalHours);
                    System.out.println("Total Wage: " + totalWage);
                    break;
                }

                case "partTime": {
                    // User Case 3 (Part time Employee & Wage Calculation)
                    int partTimeHour = 6;

                    //User Case 6 (Checking conditions of total working hours & days)
                    while (totalHours < maxHours && totalDays < workingDayPerMonth) {
                        totalDays++;
                        totalHours += partTimeHour;
                    }

                    int totalWage = totalHours * wagePerHour;
                    System.out.println("Total Working Days: " + totalDays);
                    System.out.println("Total Working Hours: " + totalHours);
                    System.out.println("Total Wage: " + totalWage);
                    break;
                }

                default: {
                    System.out.println("Invalid type");
                }
            }

        } else {
            System.out.println("Employee is Absent");
        }
        sc.close();
    }
}