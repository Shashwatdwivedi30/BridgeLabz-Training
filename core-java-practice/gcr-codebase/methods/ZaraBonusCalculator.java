public class ZaraBonusCalculator {

    public static int[][] generateEmployeeData(int employees) {
        int[][] data = new int[employees][2];
        for (int i = 0; i < employees; i++) {
            // 5-digit salary
            data[i][0] = (int)(Math.random() * 90000) + 10000;

            // Years of service
            data[i][1] = (int)(Math.random() * 10) + 1;
        }
        return data;
    }

    public static double[][] calculateBonus(int[][] oldData) {
        double[][] newData = new double[oldData.length][2];

        for (int i = 0; i < oldData.length; i++) {
            int salary = oldData[i][0];
            int years = oldData[i][1];
            double bonus;

            if (years > 5) {
                bonus = salary * 0.05; 
            } else {
                bonus = salary * 0.02;
            }

            newData[i][0] = salary + bonus; //new salary
            newData[i][1] = bonus;  //bonus amount
        }
        return newData;
    }

    public static void displayReport(int[][] oldData, double[][] newData) {
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("%-10s %-15s %-18s %-15s %-15s%n",
                "Emp No", "Old Salary", "Years of Service", "Bonus", "New Salary");
        System.out.println("-----------------------------------------------------------------------");

        for (int i = 0; i < oldData.length; i++) {
            totalOldSalary += oldData[i][0];
            totalBonus += newData[i][1];
            totalNewSalary += newData[i][0];

            System.out.printf("%-10d %-15d %-18d %-15.2f %-15.2f%n",
                    (i + 1), oldData[i][0], oldData[i][1], newData[i][1], newData[i][0]);
        }

        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("%-10s %-15.2f %-18s %-15.2f %-15.2f%n","TOTAL" +totalOldSalary, "", totalBonus,totalNewSalary);
        System.out.println("-----------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        int employees = 10;
        int[][] employeeData = generateEmployeeData(employees);
        double[][] updatedData = calculateBonus(employeeData);
        displayReport(employeeData, updatedData);
    }
}