import java.util.*;
public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Employee");
        int n = sc.nextInt();
        int[] employeeIDs = new int[n];

        
        for(int i = 0; i < n; i++){
            System.out.println("Enter ID of Employee" +(i+1));
            employeeIDs[i] = sc.nextInt();
        }

        for(int i = 1; i < n; i++){
            int key = employeeIDs[i];
            int j;
            
            for(j = i - 1; j>= 0 && employeeIDs[j] > key; j--){
                employeeIDs[j + 1] = employeeIDs[j];
            }

            employeeIDs[j + 1] = key;
        }

        for (int i = 0; i < employeeIDs.length; i++) {
            System.out.print(employeeIDs[i] + " ");
        }
        sc.close();
    }
}