import java.util.Scanner;

public class CountSort {
    static void countingSort(int[] ages){
        int max = ages[0];
        for(int age : ages){
            if(age > max){
                max = age;
            }
        }

        int[] count = new int[max + 1];
        for(int age : ages){
            count[age]++;
        }

        int index = 0;
        for(int i = 0; i < count.length; i++){
            while(count[i] > 0){
                ages[index] = i;
                index++;
                count[i]--;
            }
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] ages = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            ages[i] = sc.nextInt();
        }

        countingSort(ages);

        System.out.println("Sorted Student Ages:");
        for (int age : ages) {
            System.out.print(age + " ");
        }

        sc.close();
    }
}
