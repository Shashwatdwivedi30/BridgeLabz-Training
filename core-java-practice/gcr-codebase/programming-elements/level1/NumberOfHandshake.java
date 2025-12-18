import java.util.Scanner;
public class NumberOfHandshake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfStudents = sc.nextInt();
        int handshakes = (noOfStudents * (noOfStudents - 1)) / 2;       //formula is (n * (n-1)) / 2
        System.out.println("Maximum number of handshakes possible is "+handshakes);
    }
}
