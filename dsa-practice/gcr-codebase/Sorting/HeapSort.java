import java.util.Scanner;

public class HeapSort {
    static void heapSort(int[] salary) {
        int n = salary.length;

        // Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salary, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = salary[0];
            salary[0] = salary[i];
            salary[i] = temp;
            heapify(salary, i, 0);
        }
    }

    static void heapify(int[] salary, int n, int i) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && salary[left] > salary[largest])
            largest = left;

        if (right < n && salary[right] > salary[largest])
            largest = right;

        if (largest != i) {
            int temp = salary[i];
            salary[i] = salary[largest];
            salary[largest] = temp;

            heapify(salary, n, largest);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of job applicants: ");
        int n = sc.nextInt();

        int[] salary = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter expected salary of applicant " + (i + 1) + ": ");
            salary[i] = sc.nextInt();
        }

        heapSort(salary);

        System.out.println("Sorted Salary Demands (Ascending):");
        for (int s : salary) {
            System.out.print(s + " ");
        }

        sc.close();
    }
}