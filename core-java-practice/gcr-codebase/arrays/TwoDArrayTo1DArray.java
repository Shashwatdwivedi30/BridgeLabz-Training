import java.util.Scanner;

public class TwoDArrayTo1DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        // Take user input for rows and columns
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();        
        System.out.print("Enter number of columns: ");
        int columns = sc.nextInt();        
        // Create 2D array (Matrix)
        int[][] matrix = new int[rows][columns];
        
        // Take user input for 2D array elements
        System.out.println("Enter elements of the 2D array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }       
        // Create 1D array
        int[] oneDArray = new int[rows * columns];        
        // Copy 2D array elements to 1D array
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                oneDArray[index] = matrix[i][j];
                index++;
            }
        }
        
        // Display the 1D array
        System.out.println("Elements of 1D array:");
        for (int element : oneDArray) {
            System.out.print(element + " ");
        }
        sc.close();
    }
}