import java.util.Scanner;

public class SelectionSort {
    static void selectionSort(int[] scores){
        int n = scores.length;
        for(int i = 0; i < n - 1; i++){
            int minIndex = i;

            for(int j = i + 1; j < n; j++){
                if(scores[j] < scores[minIndex]){
                    minIndex = j;
                }
            }
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] examScores = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter score of student " + (i + 1) + ": ");
            examScores[i] = sc.nextInt();
        }

        selectionSort(examScores);

        System.out.println("Sorted Exam Scores:");
        for (int score : examScores) {
            System.out.print(score + " ");
        }

        sc.close();
    }
}
