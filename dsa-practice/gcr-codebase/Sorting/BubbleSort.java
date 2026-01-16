import java.util.*;
public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of students");
        int n = sc.nextInt();
        int[] marks = new int[n];

        
        for(int i = 0; i < n; i++){
            System.out.println("Enter marks of student " +(i+1));
            marks[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++){
            for(int j = i; j < n-i-1; j++){
                if(marks[j] > marks[j+1]){
                    int temp = marks[j];
                    marks[j] = marks[j+1];
                    marks[j+1] = temp;
                }
            }
        }

        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + " ");
        }
        sc.close();
    }
}