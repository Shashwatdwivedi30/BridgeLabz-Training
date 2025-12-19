import java.util.Scanner;

public class GradeCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float physics = sc.nextFloat();
        float chemistry = sc.nextFloat();
        float maths = sc.nextFloat();
        float total = physics + chemistry + maths;
        float percentage = (total / 300) * 100;

        System.out.println("Average Marks "+(total/3));
        if (percentage >= 80) {
            System.out.println("Grade: A and Remarks: Level 4, above agency-normalized standards");
        } else if (percentage >= 70) {
            System.out.println("Grade: B and Remarks: Level 3, at agency-normalized standards");
        } else if (percentage >= 60) {
            System.out.println("Grade: C and Remarks: Level 2, below but approaching agency-normalized standards");
        } else if (percentage >= 50) {
            System.out.println("Grade: D and Remarks: Level 1, well below agency-normalized standards");
        } else if (percentage >= 40) {
            System.out.println("Grade: E and Remarks: Level 1, too below agency-normalized standards");
        } else {
            System.out.println("Grade: R and Remarks: Remedial standards");
        }
    }
}